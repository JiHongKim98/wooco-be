package kr.wooco.woocobe.place.ui.web.controller.response

data class CreatePlaceResponse(
    val placeId: Long,
) {
    companion object {
        fun of(placeId: Long): CreatePlaceResponse =
            CreatePlaceResponse(
                placeId = placeId,
            )
    }
}
