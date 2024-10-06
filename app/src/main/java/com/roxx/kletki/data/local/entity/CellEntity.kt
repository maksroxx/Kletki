package com.roxx.kletki.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CellEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val type: String
)
