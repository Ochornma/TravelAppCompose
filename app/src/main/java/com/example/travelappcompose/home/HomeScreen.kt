package com.example.travelappcompose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappcompose.home.widgets.CategoryWidget
import com.example.travelappcompose.home.widgets.DestinationWidgets
import com.example.travelappcompose.home.widgets.SearchTextField
import com.example.travelappcompose.ui.theme.TravelAppComposeTheme

@Composable
fun HomeScreen() {
    val gradient = Brush.linearGradient(
        0.0f to Color(red = 0.9882131f, green = 0.6823857f, blue = 0.25098395f, alpha = 1f),
        500.0f to Color(red = 0.99608034f, green = 0.4463254f, blue = 0.26979348f, alpha = 1f),
        start = Offset.Zero,
        end = Offset.Infinite,
        tileMode = TileMode.Clamp)
    val scrollState = rememberScrollState()
    val inputValue = remember { mutableStateOf("") }

    Box(modifier =
    Modifier
        .fillMaxSize()
        .background(gradient)) {

        //this view is to make the gradient not visible below
        //during scrolling
        Box(modifier =
        Modifier
            .fillMaxSize()
            //padding must come before background
            .padding(top = 500.dp)
            .background(Color.White))
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.Transparent)) {
            Text(text = "Discover", fontSize = 40.sp,
                fontWeight = FontWeight.Bold, color = Color.White,
                modifier = Modifier.padding(top = 40.dp, start = 12.dp)
            )

            SearchTextField(inputValue = {
                inputValue.value = it
            }, value = inputValue.value)

            CategoryWidget()

            Column(modifier = Modifier
                .padding(top = 40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)

            ) {
                DestinationWidgets()
            }

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TravelAppComposeTheme {
        HomeScreen()
    }
}