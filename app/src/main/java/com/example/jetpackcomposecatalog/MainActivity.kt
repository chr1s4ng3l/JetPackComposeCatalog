package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalog.ui.theme.JetPackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyText()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogTheme {
        MyTextField()
    }
}

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }

    TextField(value =myText, onValueChange ={myText = it})

}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {

        Text(text = "My Text")
        Text(text = "My Text", color = Color.Blue)
        Text(text = "My Text", fontWeight = FontWeight.ExtraBold)
        Text(text = "My Text", fontWeight = FontWeight.Light)
        Text(text = "My Text", fontFamily = FontFamily.Cursive)
        Text(text = "My Text", textDecoration = TextDecoration.LineThrough)
        Text(text = "My Text", textDecoration = TextDecoration.Underline)
        Text(
            text = "My Text",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            )
        )

        Text(text = "My Text", textDecoration = TextDecoration.None, fontSize = 30.sp)
    }
}
