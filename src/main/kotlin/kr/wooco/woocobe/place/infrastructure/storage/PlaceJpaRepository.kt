package kr.wooco.woocobe.place.infrastructure.storage

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceJpaRepository : JpaRepository<PlaceEntity, Long> {
    fun existsByKakaoMapPlaceId(kakaoMapPlaceId: String): Boolean
}
