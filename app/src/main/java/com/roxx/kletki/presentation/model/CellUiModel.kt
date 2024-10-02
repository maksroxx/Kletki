package com.roxx.kletki.presentation.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.roxx.kletki.domain.model.Cell

data class CellUiModel(
    val type: Cell,
    val firstColor: Color,
    val secondColor: Color,
    @DrawableRes
    val imageRes: Int,
    val name: String,
    val description: String
)