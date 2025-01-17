package kr.wooco.woocobe.course.ui.web.controller.request

import kr.wooco.woocobe.course.domain.usecase.UpdateCourseInput
import java.time.LocalDate

data class UpdateCourseRequest(
    val name: String,
    val contents: String,
    val categories: List<String>,
    val placeIds: List<Long>,
    val visitDate: LocalDate,
) {
    fun toCommand(
        userId: Long,
        courseId: Long,
    ): UpdateCourseInput =
        UpdateCourseInput(
            userId = userId,
            courseId = courseId,
            name = name,
            contents = contents,
            categories = categories,
            placeIds = placeIds,
            visitDate = visitDate,
        )
}
