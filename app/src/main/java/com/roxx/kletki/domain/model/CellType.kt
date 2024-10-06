package com.roxx.kletki.domain.model

sealed class CellType(val name: String) {
    object AliveCellType: CellType("alive")
    object DeadCellType: CellType("dead")
    object LifeCellType: CellType("life")

    companion object {
        fun fromString(name: String): CellType {
            return when(name) {
                "alive" -> AliveCellType
                "dead" -> DeadCellType
                "life" -> LifeCellType
                else -> AliveCellType
            }
        }
    }
}