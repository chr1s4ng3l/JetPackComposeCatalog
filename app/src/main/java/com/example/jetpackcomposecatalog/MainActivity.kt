package com.example.jetpackcomposecatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
//                    var myText by remember {
//                        mutableStateOf("Christopher")
//                    }
//                    MyTextField(myText){
//                        myText = it
//                    }


                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogTheme {
        MyButtonExample()
    }
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = myText,
            onValueChange = {
                myText = if (it.contains("a")) {
                    it.replace("a", "*")
                } else {
                    it
                }


            },
            label = { Text(text = "Type your name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = ""
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Green
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

    }


}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })

}


@Composable
fun MyButtonExample() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Button(
            onClick = { Log.i("Whats up", "This is just an Example") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(10.dp, Color.Green)

        ) {

            Text(text = "Hello")

        }

    }
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
