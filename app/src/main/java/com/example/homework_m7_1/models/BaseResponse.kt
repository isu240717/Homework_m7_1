package com.example.homework_m7_1.models

data class BaseResponse<T>(
    val success: Boolean,
    val data: T
)