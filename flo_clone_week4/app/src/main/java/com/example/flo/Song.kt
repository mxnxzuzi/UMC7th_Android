package com.example.flo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SongTable")
data class Song(
        var title: String = "",
        var singer: String = "",
        var second: Int = 0,
        var playTime: Int = 0,
        var isPlaying: Boolean = false
)