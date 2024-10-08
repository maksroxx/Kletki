package com.roxx.kletki.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roxx.kletki.domain.use_cases.AddNewCellUseCase
import com.roxx.kletki.domain.use_cases.GetCellUiModelsUseCase
import com.roxx.kletki.presentation.model.CellUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CellsScreenViewModel @Inject constructor(
    private val addNewCellUseCase: AddNewCellUseCase,
    private val getCellUiModelsUseCase: GetCellUiModelsUseCase
) : ViewModel() {

    private val _cells = MutableStateFlow<List<CellUiModel>>(emptyList())
    val cells: StateFlow<List<CellUiModel>> get() = _cells

    init {
        loadCells()
    }

    private fun loadCells() {
        viewModelScope.launch {
            _cells.value = getCellUiModelsUseCase()
        }
    }

    fun addNewCell() {
        viewModelScope.launch {
            addNewCellUseCase()
            loadCells()
        }
    }
}