package com.example.travelappcompose.home.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelappcompose.home.HomeScreen
import com.example.travelappcompose.ui.theme.TravelAppComposeTheme

@Composable
fun SearchTextField(inputValue: (String) -> Unit, value: String){
    TextField(value = value,
        onValueChange = inputValue,
        enabled = true,
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "search", tint = Color.White)
        },
        textStyle = TextStyle(color = Color.White,
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif),
        maxLines = 1,
        singleLine = true,
        placeholder = { Text("Where do you want to go") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color(red = 255, green = 255, blue = 255, alpha = 50),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(4.dp))


    )
}

@Preview
@Composable
fun DefaultPreview() {
    TravelAppComposeTheme {
        SearchTextField(inputValue = {}, value = "eeerttrrrrr")
    }
}
