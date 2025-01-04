package kr.wooco.woocobe.course.infrastructure.gateway

import kr.wooco.woocobe.course.domain.gateway.CourseCommentStorageGateway
import kr.wooco.woocobe.course.domain.model.CourseComment
import kr.wooco.woocobe.course.infrastructure.storage.entity.CourseCommentJpaEntity
import kr.wooco.woocobe.course.infrastructure.storage.repository.CourseCommentJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
internal class CourseCommentStorageGatewayImpl(
    private val courseCommentJpaRepository: CourseCommentJpaRepository,
) : CourseCommentStorageGateway {
    override fun save(courseComment: CourseComment): CourseComment =
        courseCommentJpaRepository.save(CourseCommentJpaEntity.from(courseComment)).toDomain()

    override fun getByCommentId(commentId: Long): CourseComment? = courseCommentJpaRepository.findByIdOrNull(commentId)?.toDomain()

    override fun getAllByCourseId(courseId: Long): List<CourseComment> =
        courseCommentJpaRepository.findAllByCourseId(courseId).map { it.toDomain() }

    override fun deleteByCommentId(commentId: Long) = courseCommentJpaRepository.deleteById(commentId)
}
