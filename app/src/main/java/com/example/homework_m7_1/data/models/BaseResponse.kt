package com.example.homework_m7_1.data.models

data class BaseResponse<T>(
    val success: Boolean,
    val data: T
)