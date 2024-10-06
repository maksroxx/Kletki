package com.roxx.kletki.domain.repository

import com.roxx.kletki.domain.model.Cell

interface CellRepository {
    suspend fun getCells(): List<Cell>
    suspend fun addCell(cell: Cell)
    suspend fun getLastCells(limit: Int): List<Cell>
    suspend fun removeLastOfType()
}