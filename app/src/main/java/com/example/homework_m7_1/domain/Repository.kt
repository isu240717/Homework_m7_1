package com.example.homework_m7_1.domain

import androidx.lifecycle.LiveData
import com.example.homework_m7_1.base.BaseRepository
import com.example.homework_m7_1.data.AppApiService
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.data.models.CameraModel
import com.example.homework_m7_1.data.models.DoorModel
import javax.inject.Inject

class Repository @Inject constructor(private val api: AppApiService) : BaseRepository(api) {
    fun getCameras(): LiveData<Resource<CameraModel>> = apiRequest {
        api.getCameras().body()!!
    }
    fun getDoors(): LiveData<Resource<DoorModel>> = apiRequest {
        api.getDoors().body()!!
    }

}