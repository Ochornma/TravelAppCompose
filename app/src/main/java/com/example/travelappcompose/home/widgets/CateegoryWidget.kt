package com.example.travelappcompose.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelappcompose.R
import com.example.travelappcompose.home.model.HomeScreeItemNames
import com.example.travelappcompose.ui.theme.TravelAppComposeTheme

@Composable
fun CategoryWidget(){
val items = mutableListOf(
    HomeScreeItemNames("Art", imageName = R.drawable.palette),
    HomeScreeItemNames("Sports", imageName = R.drawable.sports),
    HomeScreeItemNames("Live Events", imageName = R.drawable.music),
    HomeScreeItemNames("Food", imageName = R.drawable.food),
    HomeScreeItemNames("History", imageName = R.drawable.book),
)
    val scrollState = rememberScrollState()
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .background(Color.Transparent)
            .padding(horizontal = 12.dp)
            .padding(top = 20.dp)
    ){
        for (item in items){
           Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {
               Box(modifier = Modifier
                   .width(64.dp)
                   .height(64.dp)
                   .clip(RoundedCornerShape(32.dp))
                   .background(Color.White)) {
                   Image(
                       painter = painterResource(id = item.imageName),
                       contentDescription = "", modifier = Modifier.align(Center)
                   )
               }
               Text(text = item.name, style = TextStyle(color = Color.White, fontWeight = FontWeight.Normal))
           }

        }
    }
}

@Preview()
@Composable
fun CategoryPreview() {
    TravelAppComposeTheme {
        CategoryWidget()
    }
}
