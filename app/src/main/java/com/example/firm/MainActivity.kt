package com.example.firm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firm.ui.theme.FirmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirmInfoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun FirmInfoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Фирма продажи спортзалов",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.firm),
            contentDescription = "Изображение компании",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        InfoCard(title = "Контактная информация") {
            BasicText(text = "Телефон: (123) 456-7890")
            BasicText(text = "Email: sport@firm.com")
            BasicText(text = "Веб-сайт: www.sport.com")
        }
        InfoCard(title = "Адрес бизнеса") {
            BasicText(text = "12, 34 Улица Пушкина, Город Москва, Страна Россия")
        }
        InfoCard(title = "Описание бизнеса") {
            BasicText(text = "Мы предоставляем отличные услуги для наших клиентов: от продажи спортзалов до сдачи их в аренду")
        }
        InfoCard(title = "Часы работы") {
            BasicText(text = "Пн-Пт 9:00 - 18:00, Сб 10:00 - 14:00")
        }
    }
}
@Composable
fun InfoCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            content = content
        )
    }
}
@Preview(showBackground = true)
@Composable
fun FirmInfoScreenPreview() {
    FirmTheme {
        FirmInfoScreen()
    }
}
