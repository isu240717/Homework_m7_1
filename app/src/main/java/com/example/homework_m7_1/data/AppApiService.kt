package com.example.homework_m7_1.data

import com.example.homework_m7_1.data.models.CameraModel
import com.example.homework_m7_1.data.models.DoorModel
import retrofit2.Response
import retrofit2.http.GET

interface AppApiService {
    @GET("cameras/")
    suspend fun getCameras(): Response<CameraModel>

    @GET("doors/")
    suspend fun getDoors(): Response<DoorModel>
}