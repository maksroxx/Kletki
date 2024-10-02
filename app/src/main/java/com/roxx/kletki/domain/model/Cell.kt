package com.roxx.kletki.domain.model

sealed class Cell {
    object AliveCell: Cell()
    object DeadCell: Cell()
    object LifeCell: Cell()
}