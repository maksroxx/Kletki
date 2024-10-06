package com.roxx.kletki.data.repository

import com.roxx.kletki.data.local.CellDao
import com.roxx.kletki.data.mapper.toCell
import com.roxx.kletki.data.mapper.toCellEntity
import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.domain.repository.CellRepository

class CellRepositoryImpl(
    private val dao: CellDao
): CellRepository {

    override suspend fun getCells(): List<Cell> {
        return dao.getAllCells().map { it.toCell() }
    }

    override suspend fun addCell(cell: Cell) {
        dao.insertCell(cell.toCellEntity())
    }

    override suspend fun getLastCells(limit: Int): List<Cell> {
        return dao.getLastThreeCells(limit).map { it.toCell() }
    }

    override suspend fun removeLastOfType() {
        dao.delete("life")
    }
}