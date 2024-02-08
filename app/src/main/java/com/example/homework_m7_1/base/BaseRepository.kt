package com.example.homework_m7_1.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.homework_m7_1.data.AppApiService
import com.example.homework_m7_1.data.Resource
import kotlinx.coroutines.Dispatchers

abstract class BaseRepository (private val api: AppApiService){
    fun <T> apiRequest(apiCall: suspend () -> T): LiveData<Resource<T>> =
        liveData(Dispatchers.Main) {
            emit(Resource.Loading())
            try {
                val response = apiCall.invoke()
                if (response != null) {
                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
                Log.e("ololo", "${e.message}")
            }

        }

}