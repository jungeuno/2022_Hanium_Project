package com.avengers.maskfitting.mafiafin.main.weather.api

import com.avengers.maskfitting.mafiafin.BuildConfig
import com.avengers.maskfitting.mafiafin.main.weather.model.tm.TmCoordinatesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KakaoLocalAPI {
    // 헤더로 인증정보 전달
    @Headers("Authorization: KakaoAK ${BuildConfig.KAKAO_API_KEY}")
    @GET("v2/local/geo/transcoord.json?output_coord=TM")
    suspend fun getTmCoordinates(
        @Query("x") longitude: Double,
        @Query("y") latitude: Double
    ): Response<TmCoordinatesResponse>

}