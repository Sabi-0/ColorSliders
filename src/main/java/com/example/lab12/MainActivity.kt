package com.example.lab12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab12.ui.theme.Lab12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab12Theme {
                ColorMixerScreen()
            }
        }
    }
}

@Composable
fun ColorMixerScreen() {
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .background(Color(red, green, blue))
        )

        Spacer(modifier = Modifier.height(16.dp))

        ColorSlider("Red", red) { red = it }
        ColorSlider("Green", green) { green = it }
        ColorSlider("Blue", blue) { blue = it }
    }
}

@Composable
fun ColorSlider(label: String, value: Float, onValueChange: (Float) -> Unit) {
    Column {
        Text(text = "$label: ${(value * 255).toInt()}")
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab12Theme {
        ColorMixerScreen()
    }
}
