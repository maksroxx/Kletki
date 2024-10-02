package com.roxx.kletki.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roxx.kletki.R
import com.roxx.kletki.domain.model.Cell
import com.roxx.kletki.presentation.model.CellUiModel
import com.roxx.kletki.ui.theme.AliveFirst
import com.roxx.kletki.ui.theme.AliveSecond
import com.roxx.kletki.ui.theme.LocalSpacing

@Composable
fun CellItem(cell: CellUiModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.small)
            .clip(RoundedCornerShape(LocalSpacing.current.medium))
            .background(Color.White)
            .padding(LocalSpacing.current.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(LocalSpacing.current.medium)
    ) {
        Box(
            Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            cell.firstColor,
                            cell.secondColor
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(cell.imageRes),
                contentDescription = cell.name
            )
        }
        Column {
            Text(
                text = cell.name,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
            )
            Text(
                text = cell.description,
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
private fun CellItemPrev() {
    CellItem(
        CellUiModel(
            type = Cell.AliveCell,
            firstColor = AliveFirst,
            secondColor = AliveSecond,
            imageRes = R.drawable.fireworks,
            name = "Живая",
            description = "и шевелится!"
        )
    )
}