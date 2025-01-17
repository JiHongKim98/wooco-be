package kr.wooco.woocobe.auth.infrastructure.client.kakao.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(SnakeCaseStrategy::class)
data class KakaoSocialTokenResponse(
    val accessToken: String,
)
