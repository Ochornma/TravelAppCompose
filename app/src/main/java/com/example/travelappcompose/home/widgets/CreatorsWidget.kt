package com.example.travelappcompose.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappcompose.R
import com.example.travelappcompose.home.model.HomeScreeItemNames
import com.example.travelappcompose.ui.theme.TravelAppComposeTheme


@Composable
fun CreatorsWidgets() {

    val items = mutableListOf(
        HomeScreeItemNames(
            "Amy Adams",
            imageName = R.drawable.amy,

        ),
        HomeScreeItemNames(
            "Billy",
            imageName = R.drawable.billy,),
        HomeScreeItemNames(
            "Sam Smith",
            imageName = R.drawable.sam,)
    )
    val scrollState = rememberScrollState()

    Column {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Trending Creators",
                style = TextStyle(color = Color.Black, fontSize = 12.sp)
            )


            TextButton(
                onClick = { }, modifier = Modifier
            ) {
                Text(
                    text = "See All",
                    style = TextStyle(color = Color.Black, fontSize = 12.sp)
                )
            }

        }

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

                        Image(
                            painter = painterResource(id = item.imageName),
                            contentDescription = "", modifier = Modifier
                                .width(64.dp)
                                .height(64.dp)
                                .clip(RoundedCornerShape(32.dp))
                        )
                    Text(text = item.name, style = TextStyle(color = Color.Black, fontWeight = FontWeight.Normal))
                }

            }
        }
    }
}

@Preview()
@Composable
fun CreatorsWidgetsPreview() {
    TravelAppComposeTheme {
        CreatorsWidgets()
    }
}