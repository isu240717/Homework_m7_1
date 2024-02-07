package com.example.homework_m7_1.data

import androidx.lifecycle.LiveData
import com.example.homework_m7_1.base.BaseRepository
import com.example.homework_m7_1.models.Data
import javax.inject.Inject

class Repository @Inject constructor(private val api: AppApiService) : BaseRepository(api) {
    fun getCameras(): LiveData<Resource<List<Data>>> = apiRequest {
        api.getCameras().body()?.data?.cameras ?: emptyList()
    }

    fun getDoors(): LiveData<Resource<List<Data>>> = apiRequest {
        api.getDoors().body()?.data ?: emptyList()
    }

}