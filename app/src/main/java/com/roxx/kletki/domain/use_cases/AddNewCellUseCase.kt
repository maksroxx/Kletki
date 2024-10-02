package com.roxx.kletki.domain.use_cases

import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.domain.repository.CellRepository

class AddNewCellUseCase(private val repository: CellRepository) {

    operator fun invoke() {
        val newCell: Cell = when ((0..1).random()) {
            0 -> Cell.AliveCell
            1 -> Cell.DeadCell
            else -> Cell.AliveCell
        }

        repository.addCell(newCell)

        val lastThreeCells = repository.getLastThreeCells()

        if (lastThreeCells.size == 3) {
            if (lastThreeCells.all { it is Cell.AliveCell }) {
                repository.addCell(Cell.LifeCell)
            } else if (lastThreeCells.all { it is Cell.DeadCell }) {
                repository.removeLastOfType(Cell.LifeCell)
            }
        }
    }
}