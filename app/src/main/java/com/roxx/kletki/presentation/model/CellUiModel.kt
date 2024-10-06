package com.roxx.kletki.presentation.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.roxx.kletki.domain.model.CellType

data class CellUiModel(
    val type: CellType,
    val firstColor: Color,
    val secondColor: Color,
    @DrawableRes
    val imageRes: Int,
    val name: String,
    val description: String
)