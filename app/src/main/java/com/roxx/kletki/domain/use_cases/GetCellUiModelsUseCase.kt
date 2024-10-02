package com.roxx.kletki.domain.use_cases

import com.roxx.kletki.presentation.mapper.toUiModel
import com.roxx.kletki.presentation.model.CellUiModel

class GetCellUiModelsUseCase(private val getCellsUseCase: GetCellsUseCase) {

    operator fun invoke(): List<CellUiModel> {
        val domainCells = getCellsUseCase()
        return domainCells.map { it.toUiModel() }
    }
}