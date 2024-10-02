package com.roxx.kletki.domain.repository

import com.roxx.kletki.domain.model.Cell

interface CellRepository {
    fun getCells(): List<Cell>
    fun addCell(cell: Cell)
    fun getLastThreeCells(): List<Cell>
    fun removeLastOfType(type: Cell)
}