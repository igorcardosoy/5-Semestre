package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HappyBirthdayTheme {
                        GreetingImage(
                            message = stringResource(R.string.happy_birthday_sir),
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier, from: String = "or not...") {

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier.padding(50.dp)
        )

        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, modifier: Modifier = Modifier, from: String = stringResource(R.string.or_not)) {
    val image = painterResource(R.drawable.androidparty)

    Box {
        Image(
            painter = image,
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(message = message, from = from)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_sir)
        )
    }
}