package com.example.homework_m7_1.data

import com.example.homework_m7_1.models.BaseResponse
import com.example.homework_m7_1.models.Data
import com.example.homework_m7_1.models.SystemModel
import retrofit2.Response
import retrofit2.http.GET

interface AppApiService {
    @GET("cameras/")
    fun getCameras(): Response<BaseResponse<SystemModel>>

    @GET("doors/")
    fun getDoors(): Response<BaseResponse<List<Data>>>
}