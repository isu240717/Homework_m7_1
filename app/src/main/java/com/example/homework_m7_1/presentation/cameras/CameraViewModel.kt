package com.example.homework_m7_1.presentation.cameras

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.homework_m7_1.domain.Repository
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.data.models.CameraModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getCameras(): LiveData<Resource<CameraModel>> = repository.getCameras()
}