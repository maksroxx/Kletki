package com.roxx.kletki.presentation.mapper

import com.roxx.kletki.R
import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.presentation.model.CellUiModel
import com.roxx.kletki.ui.theme.AliveFirst
import com.roxx.kletki.ui.theme.AliveSecond
import com.roxx.kletki.ui.theme.DeadFirst
import com.roxx.kletki.ui.theme.DeadSecond
import com.roxx.kletki.ui.theme.LifeFirst
import com.roxx.kletki.ui.theme.LifeSecond

fun Cell.toUiModel(): CellUiModel {
    return when (this) {
        is Cell.AliveCell -> CellUiModel(
            type = Cell.AliveCell,
            firstColor = AliveFirst,
            secondColor = AliveSecond,
            imageRes = R.drawable.fireworks,
            name = "Живая",
            description = "и шевелится!"
        )

        is Cell.DeadCell -> CellUiModel(
            type = Cell.DeadCell,
            firstColor = DeadFirst,
            secondColor = DeadSecond,
            imageRes = R.drawable.skeleton,
            name = "Мертвая",
            description = "или прикидывается"
        )

        is Cell.LifeCell -> CellUiModel(
            type = Cell.LifeCell,
            firstColor = LifeFirst,
            secondColor = LifeSecond,
            imageRes = R.drawable.bird,
            name = "Жизнь",
            description = "Ку-ку!"
        )
    }
}