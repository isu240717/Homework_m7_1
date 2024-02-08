package com.example.homework_m7_1.ui.doors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.homework_m7_1.data.Repository
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.models.DoorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getDoors(): LiveData<Resource<DoorModel>> = repository.getDoors()
}