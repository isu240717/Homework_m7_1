package com.example.homework_m7_1.data.models

data class CameraModel(
    val `data`: Data,
    val success: Boolean
) {
    data class Data(
        val cameras: List<Camera>,
        val room: List<String>
    ) {
        data class Camera(
            val favorites: Boolean,
            val id: Int,
            val name: String,
            val rec: Boolean,
            val room: String,
            val snapshot: String
        )
    }
}