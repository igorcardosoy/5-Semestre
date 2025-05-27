package com.example.cartaodevisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaodevisita.ui.theme.CartaoDeVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaoDeVisitaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.hsl(125f, 0.32f, 0.87f)
                ) {
                    CartaoDeVisita(
                        title = "Igor Cardoso",
                        subtitle = "Android Developer Extraordinaire",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun CartaoDeVisita(
    title: String,
    subtitle: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = "image",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.hsl(198f, 0.81f, 0.14f))
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = subtitle,
                fontSize = 16.sp,
                color = Color(0xFF008000),
                fontWeight = FontWeight.Medium
            )
        }

        Footer(
            phone = "+11 (123) 444 555 666",
            social = "@igorcardosoy",
            email = "igorcardosoy@pdz.app.br"
        )
    }
}

@Composable
fun Footer(
    phone: String,
    social: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactLine(Icons.Default.Phone, phone)
        ContactLine(Icons.Default.Share, social)
        ContactLine(Icons.Default.Email, email)
    }
}

@Composable
fun ContactLine(icon: ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006400),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = info)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CartaoDeVisitaTheme {
        CartaoDeVisita(
            title = "Igor Cardoso",
            subtitle = "Android Developer Extraordinaire",
            Modifier.background(color = Color.hsl(125f, 0.32f, 0.87f))
        )
    }
}
