package kr.wooco.woocobe.place.domain.usecase

import kr.wooco.woocobe.common.domain.usecase.UseCase
import kr.wooco.woocobe.place.domain.gateway.PlaceReviewStorageGateway
import kr.wooco.woocobe.place.domain.gateway.PlaceStorageGateway
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class DeletePlaceReviewInput(
    val userId: Long,
    val placeReviewId: Long,
)

@Service
class DeletePlaceReviewUseCase(
    private val placeReviewStorageGateway: PlaceReviewStorageGateway,
    private val placeStorageGateway: PlaceStorageGateway,
) : UseCase<DeletePlaceReviewInput, Unit> {
    @Transactional
    override fun execute(input: DeletePlaceReviewInput) {
        val placeReview = placeReviewStorageGateway.getByPlaceReviewId(input.placeReviewId)
            ?: throw RuntimeException()

        when {
            placeReview.isWriter(input.userId).not() -> throw RuntimeException()
        }

        placeReviewStorageGateway.deleteByPlaceReviewId(placeReviewId = placeReview.id)

        val place = placeReview.place

        place.deleteReview(oldRating = placeReview.rating)

        placeStorageGateway.save(place)
    }
}