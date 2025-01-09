package kr.wooco.woocobe.place.infrastructure.storage.entity

import io.hypersistence.utils.hibernate.id.Tsid
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import kr.wooco.woocobe.common.infrastructure.storage.BaseTimeEntity

@Entity
@Table(name = "place_one_line_reviews")
class PlaceOneLineReviewJpaEntity(
    @Column(name = "content")
    val content: String,
    @Column(name = "place_Review_id")
    val placeReviewId: Long,
    @Column(name = "place_id")
    val placeId: Long,
    @Id @Tsid
    @Column(name = "place_one_line_review_id")
    val id: Long? = 0L,
) : BaseTimeEntity()
