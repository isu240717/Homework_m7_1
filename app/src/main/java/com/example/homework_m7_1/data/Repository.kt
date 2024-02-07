package com.example.homework_m7_1.data

import androidx.lifecycle.LiveData
import com.example.homework_m7_1.base.BaseRepository
import com.example.homework_m7_1.models.BaseResponse
import com.example.homework_m7_1.models.Data
import com.example.homework_m7_1.models.SystemModel
import javax.inject.Inject

class Repository @Inject constructor(private val api: AppApiService) : BaseRepository(api) {
    fun getCameras(): LiveData<Resource<BaseResponse<SystemModel>>> = apiRequest {
        api.getCameras().body()!!
    }

    fun getDoors(): LiveData<Resource<BaseResponse<List<Data>>>> = apiRequest {
        api.getDoors().body()!!
    }

}