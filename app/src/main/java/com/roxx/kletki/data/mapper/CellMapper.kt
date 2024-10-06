package com.roxx.kletki.data.mapper

import com.roxx.kletki.data.local.entity.CellEntity
import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.domain.model.CellType

fun CellEntity.toCell(): Cell {
    return Cell(
        type = CellType.fromString(type)
    )
}

fun Cell.toCellEntity(): CellEntity {
    return CellEntity(
        type = type.name
    )
}