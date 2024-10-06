package com.roxx.kletki.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roxx.kletki.data.local.entity.CellEntity

@Dao
interface CellDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCell(cell: CellEntity)

    @Query(
        """
            DELETE FROM cellentity
            WHERE id = (SELECT id FROM cellentity WHERE type = :type ORDER BY id DESC LIMIT 1)
        """
    )
    suspend fun delete(type: String)

    @Query("""
        SELECT * FROM cellentity
        ORDER BY id DESC
        LIMIT :limit
    """)
    suspend fun getLastThreeCells(limit: Int): List<CellEntity>

    @Query("SELECT * FROM cellentity")
    suspend fun getAllCells(): List<CellEntity>
}