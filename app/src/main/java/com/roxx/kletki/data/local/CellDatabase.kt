package com.roxx.kletki.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roxx.kletki.data.local.entity.CellEntity

@Database(
    entities = [CellEntity::class],
    version = 1
)
abstract class CellDatabase: RoomDatabase() {

    abstract val dao: CellDao
}