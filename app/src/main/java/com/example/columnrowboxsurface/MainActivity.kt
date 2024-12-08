package com.example.columnrowboxsurface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.columnrowboxsurface.ui.theme.ColumnRowBoxSurfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val list: List<Persons> = Persons.list
        setContent {
            Column (modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 45.dp)){
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray)
                        .border(width = 2.dp, color = Color.Black)
                ) {
                    Header()
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .border(width = 2.dp, color = Color.Black)
                        .padding(5.dp)
                ) {
                    ColumnName("Имя")
                    ColumnName("Зарплата")
                    ColumnName("Телефон")
                }
                for (i in 0..list.size - 1) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(width = 2.dp, color = Color.Black)
                            .padding(5.dp)
                    ) {
                        TableData(list[i].name)
                        TableData(list[i].salary.toString())
                        TableData(list[i].phone)
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    Text(
        text = "Данные по персоналу",
        fontSize = 22.sp
    )
}

@Composable
fun ColumnName(name: String) {
    Text(
        text = name,
        fontSize = 18.sp
    )
}

@Composable
fun TableData(name: String) {
    Text(
        text = name
    )
}