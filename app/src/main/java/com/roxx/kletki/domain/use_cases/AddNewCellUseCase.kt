package com.roxx.kletki.domain.use_cases

import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.domain.model.CellType
import com.roxx.kletki.domain.repository.CellRepository

class AddNewCellUseCase(private val repository: CellRepository) {

    suspend operator fun invoke() {
        val newCellType: CellType = when ((0..1).random()) {
            0 -> CellType.AliveCellType
            1 -> CellType.DeadCellType
            else -> CellType.AliveCellType
        }

        repository.addCell(Cell(type = newCellType))

        val lastThreeCells = repository.getLastCells(3)
        val lastFourCells = repository.getLastCells(4)

        if (lastThreeCells.size == 3) {
            if (lastThreeCells.all { it.type is CellType.AliveCellType }) {
                repository.addCell(Cell(type = CellType.LifeCellType))
            } else if (
                lastThreeCells.all { it.type is CellType.DeadCellType }
                && lastFourCells.first().type is CellType.LifeCellType) {
                repository.removeLastOfType()
            }
        }
    }
}