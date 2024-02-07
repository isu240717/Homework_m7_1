package com.example.homework_m7_1.models

data class SystemModel(
    val room: List<String>? = null,
    val cameras: List<Data>
)
data class Data(
    val name: String,
    val snapshot: String ?= null,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val rec: Boolean ?= null
)

/*{
    "success": true,
    "data": [
        {
            "name": "Door Door",
            "room": "FIRST",
            "id": 1,
            "favorites": true
        }
        {
            "name": "Door Door, Door Door",
            "snapshot": "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
            "room": "FIRST",
            "id": 6,
            "favorites": true
        }
    ]
}*/
/*{
  "success": true,
  "data": {
    "room": [
      "FIRST",
      "SECOND"
    ],
    "cameras": [
      {
        "name": "Camera 1",
        "snapshot": "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
        "room": "FIRST",
        "id": 1,
        "favorites": true,
        "rec": false
      }
    ]
  }
}*/