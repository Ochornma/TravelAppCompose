package com.example.travelappcompose.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappcompose.R
import com.example.travelappcompose.home.model.HomeScreeItemNames
import com.example.travelappcompose.ui.theme.TravelAppComposeTheme

@Composable
fun RestaurantsWidget() {

    val items = mutableListOf(
        HomeScreeItemNames(
            "Japan's Finest Tapas",
            imageName = R.drawable.tapas,

            ),
        HomeScreeItemNames(
            "Bar & Grill",
            imageName = R.drawable.bar_grill,),
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
                text = "Popular Places to Eat",
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
                .padding(top = 5.dp)
        ) {
            for (item in items){
                Card(shape = RoundedCornerShape(8.dp)) {
                    Row(
                        modifier = Modifier
                            .padding(4.dp)
                            .width(250.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Image(painter = painterResource(id = item.imageName),
                            contentDescription = null, modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                                .clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop)

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()) {
                                Text(
                                    text = item.name,
                                    style = TextStyle(color = Color.Black, fontSize = 12.sp)
                                )
                                Icon(painter = painterResource(id = R.drawable.more_horiz), contentDescription = "")
                            }


                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier) {

                                Icon(painter = painterResource(id = R.drawable.star), contentDescription = "",
                                modifier = Modifier.size(16.dp)
                                    .padding(end = 5.dp))

                                Text(
                                    text = "4.7 • Sushi • \$\$",
                                    style = TextStyle(color = Color.Black, fontSize = 12.sp,)
                                )

                            }


                            Text(
                                text = "Tokyo Japan",
                                style = TextStyle(color = Color.Black, fontSize = 12.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RestaurantsWidgetPreview() {
    TravelAppComposeTheme {
        RestaurantsWidget()
    }
}