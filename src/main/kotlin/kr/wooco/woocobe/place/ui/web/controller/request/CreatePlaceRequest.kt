package kr.wooco.woocobe.place.ui.web.controller.request

import kr.wooco.woocobe.place.domain.usecase.AddPlaceInput

data class CreatePlaceRequest(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val kakaoMapPlaceId: String,
    val phoneNumber: String,
) {
    fun toCommand(): AddPlaceInput =
        AddPlaceInput(
            name = name,
            latitude = latitude,
            longitude = longitude,
            address = address,
            kakaoMapPlaceId = kakaoMapPlaceId,
            phoneNumber = phoneNumber,
        )
}
