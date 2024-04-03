package com.example.homework_m7_1.presentation.doors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.homework_m7_1.domain.Repository
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.data.models.DoorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getDoors(): LiveData<Resource<DoorModel>> = repository.getDoors()
}