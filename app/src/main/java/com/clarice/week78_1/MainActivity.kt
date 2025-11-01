package com.clarice.week78_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.clarice.week78_1.ui.theme.Week78_1Theme
import com.clarice.week78_1.ui.view.WeatherView
import com.clarice.week78_1.ui.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get viewmodel & pass
        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class]

        enableEdgeToEdge()
        setContent {
            Week78_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherView(weatherViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week78_1Theme {
        Greeting("Android")
    }
}