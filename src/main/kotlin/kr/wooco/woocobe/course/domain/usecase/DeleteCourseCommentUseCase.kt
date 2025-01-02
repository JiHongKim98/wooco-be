package kr.wooco.woocobe.course.domain.usecase

import kr.wooco.woocobe.common.domain.usecase.UseCase
import kr.wooco.woocobe.course.domain.gateway.CourseCommentStorageGateway
import kr.wooco.woocobe.course.domain.gateway.CourseStorageGateway
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class DeleteCourseCommentInput(
    val userId: Long,
    val commentId: Long,
)

@Service
class DeleteCourseCommentUseCase(
    private val courseStorageGateway: CourseStorageGateway,
    private val courseCommentStorageGateway: CourseCommentStorageGateway,
) : UseCase<DeleteCourseCommentInput, Unit> {
    @Transactional
    override fun execute(input: DeleteCourseCommentInput) {
        val courseComment = courseCommentStorageGateway.getByCommentId(input.commentId)
            ?: throw RuntimeException()

        courseComment.isValidCommenter(input.userId)

        courseCommentStorageGateway.deleteByCommentId(commentId = courseComment.id)

        val course = courseStorageGateway.getByCourseId(courseComment.courseId)
            ?: throw RuntimeException()
        course.decreaseComments()
        courseStorageGateway.save(course)
    }
}
