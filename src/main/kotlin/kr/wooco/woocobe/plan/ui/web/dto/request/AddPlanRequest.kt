package kr.wooco.woocobe.plan.ui.web.dto.request

// TODO: 장소 정보 추가
data class AddPlanRequest(
    val primaryRegion: String,
    val secondaryRegion: String,
    val visitDate: String,
)
