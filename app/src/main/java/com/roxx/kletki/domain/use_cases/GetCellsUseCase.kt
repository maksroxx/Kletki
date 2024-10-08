package com.roxx.kletki.domain.use_cases

import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.domain.model.CellType
import com.roxx.kletki.domain.repository.CellRepository

class GetCellsUseCase(private val repository: CellRepository) {

    suspend operator fun invoke(): List<Cell> {
        return repository.getCells()
    }
}