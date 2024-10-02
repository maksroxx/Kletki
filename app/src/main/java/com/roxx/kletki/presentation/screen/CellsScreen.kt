package com.roxx.kletki.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roxx.kletki.ui.theme.BackgroundColor
import com.roxx.kletki.ui.theme.ButtonColor
import com.roxx.kletki.ui.theme.LocalSpacing
import kotlinx.coroutines.delay

@Composable
fun CellsScreen(
    viewModel: CellsScreenViewModel = hiltViewModel()
) {
    val cells = viewModel.cells.collectAsState()

    val listState = rememberLazyListState()

    LaunchedEffect(cells.value.size) {
        if (cells.value.isNotEmpty()) {
            delay(200L)
            listState.animateScrollToItem(cells.value.size - 1)
        }
    }

    Scaffold(
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalSpacing.current.medium)
                    .clip(RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.White
                ),
                onClick = { viewModel.addNewCell() }
            ) {
                Text(text = "Сотворить")
            }
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                BackgroundColor,
                                Color.Black
                            )
                        )
                    )
                    .padding(innerPadding)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    state = listState
                ) {
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = LocalSpacing.current.medium),
                            text = "Клеточное наполнение",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                    items(cells.value) { cell ->
                        CellItem(cell)
                    }
                }
            }
        }
    )
}
