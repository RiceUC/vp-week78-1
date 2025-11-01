package com.clarice.week78_1.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clarice.week78_1.R
import com.clarice.week78_1.ui.viewmodel.WeatherViewModel

@Composable
fun WeatherView(viewModel: WeatherViewModel) {

    var location by remember {
        mutableStateOf("")
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.home_background),
                contentScale = ContentScale.Crop
            )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar & Button
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Search Query
                OutlinedTextField(
                    value = location,
                    onValueChange = {
                        location = it
                    },
                    placeholder = {
                        Text(
                            text = "Enter city name...",
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            tint = Color.White,
                            contentDescription = "Search Icon"
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(35))
                        .background(Color.White.copy(alpha = 0.07f))
                        .border(
                            1.dp,
                            Color.White.copy(alpha = 0.25f),
                            RoundedCornerShape(35)
                        ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedContainerColor = Color.White.copy(alpha = 0.07f),
                        unfocusedContainerColor = Color.White.copy(alpha = 0.07f),
                        focusedPlaceholderColor = Color.White.copy(alpha = 0.7f),
                        unfocusedPlaceholderColor = Color.White.copy(alpha = 0.7f)
                    )
                )

                // Search Button
                Button (
                    onClick = {/* Button */},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.2f),
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(35),
                    modifier = Modifier
                        .height(56.dp)
                        .border(
                            1.dp,
                            Color.White.copy(alpha = 0.25f),
                            RoundedCornerShape(35)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                    Text("Search")
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WeatherPreview() {
    WeatherView(viewModel = WeatherViewModel())
}