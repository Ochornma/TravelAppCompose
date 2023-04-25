package com.example.travelappcompose.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappcompose.R
import com.example.travelappcompose.home.model.Destination
import com.example.travelappcompose.ui.theme.TravelAppComposeTheme

@Composable
fun DestinationWidgets() {

    val items = mutableListOf(
        Destination(
            "Paris",
            imageName = R.drawable.eiffel_tower,
            country = "France",
            latitude = 48.855014,
            longitude = 2.341231
        ),
        Destination(
            "Tokyo",
            imageName = R.drawable.japan,
            country = "Japan",
            latitude = 35.67988,
            longitude = 139.7695
        ),
        Destination(
            "New York",
            imageName = R.drawable.new_york,
            country = "US",
            latitude = 40.71592,
            longitude = -74.0055
        ),
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
                text = "Popular Destination",
                style = TextStyle(color = Color.Black, fontSize = 12.sp)
            )


            TextButton(onClick = {  }, modifier = Modifier
            ) {
                Text(
                    text = "See All",
                    style = TextStyle(color = Color.Black, fontSize = 12.sp)
                )
            }

        }


        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .background(Color.Transparent)
                .padding(horizontal = 12.dp)
                .padding(bottom = 20.dp, top = 5.dp)
        ) {
            for (item in items) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        val painter = painterResource(id = item.imageName)
                        Image(
                            contentDescription = "", modifier = Modifier
                                .size(125.dp),
                            painter = painter,
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = item.name,
                            style = TextStyle(color = Color.Gray, fontSize = 12.sp, textAlign = TextAlign.Start),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = item.country,
                            style = TextStyle(color = Color.Gray, fontSize = 12.sp, textAlign = TextAlign.Start),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DestinationWidgetsPreview() {
    TravelAppComposeTheme {
        DestinationWidgets()
    }
}