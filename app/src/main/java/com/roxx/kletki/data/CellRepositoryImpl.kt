package com.roxx.kletki.data

import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.domain.repository.CellRepository

class CellRepositoryImpl: CellRepository {

    private val cells = mutableListOf<Cell>()

    override fun getCells(): List<Cell> {
        return cells
    }

    override fun addCell(cell: Cell) {
        cells.add(cell)
    }

    override fun getLastThreeCells(): List<Cell> {
        return if (cells.size >= 3) cells.takeLast(3) else emptyList()
    }

    override fun removeLastOfType(type: Cell) {
        val lastIndex = cells.indexOfLast { it == type }
        if (lastIndex != -1) {
            cells.removeAt(lastIndex)
        }
    }
}