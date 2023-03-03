package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
//                    var myText by remember {
//                        mutableStateOf("Christopher")
//                    }
//                    MyTextField(myText){
//                        myText = it
//                    }

                    MyCheckBox()

                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogTheme {
        MyCheckBox()
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(
        checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Black,
            checkmarkColor = Color.Green

        )
    )
}

@Composable
fun MySwitch() {
    var mySwitchState by rememberSaveable {
        mutableStateOf(true)

    }


    Switch(
        checked = mySwitchState,
        onCheckedChange = { mySwitchState = !mySwitchState },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Green,
            checkedThumbColor = Color.Black,
            checkedTrackColor = Color.DarkGray
        )
    )


}

@Composable
fun MyProgressAdvance() {

    var myProgressState by rememberSaveable { mutableStateOf(0.0f) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        LinearProgressIndicator(progress = myProgressState)

        Row(Modifier.fillMaxSize()) {
            Button(onClick = { myProgressState -= 0.1f }) {
                Text(text = "Add")

            }

            Button(onClick = { myProgressState += 0.1f }) {
                Text(text = "Reduce")

            }
        }

    }
}

@Composable
fun MyProgress() {

    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            CircularProgressIndicator(color = Color.Green, strokeWidth = 5.dp)
            LinearProgressIndicator(
                Modifier.padding(top = 25.dp),
                color = Color.Blue,
                backgroundColor = Color.Black
            )
        }

        Button(onClick = { showLoading = !showLoading }) {

        }
    }
}

@Composable
fun MyTextFieldAdvance() {
    var msg by remember {
        mutableStateOf("")
    }
    var myText by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = myText, onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "*")
            } else {
                it
            }


        }, label = { Text(text = "Type your name") }, leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email, contentDescription = ""
            )
        }, colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue, unfocusedBorderColor = Color.Green
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        )

        Button(onClick = { msg = myText }) {

            Text(text = "Click here")

        }


        Text(text = msg)

    }


}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })

}


@Composable
fun MyButtonExample() {

    var enable by rememberSaveable() {
        mutableStateOf(true)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Button(
            onClick = { enable = false }, enabled = enable, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red, contentColor = Color.White
            ), border = BorderStroke(10.dp, Color.Green)

        ) {

            Text(text = "Hello")

        }

        OutlinedButton(
            onClick = { enable = false },
            enabled = enable,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White,
                disabledBackgroundColor = Color.Black,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Hi there")
        }

        TextButton(onClick = {}) {
            Text(text = "LOLOLO")
        }

    }
}


@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "StarIcon", tint = Color.Yellow)
}

@Composable
fun MyImage() {

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        modifier = Modifier
            .padding(10.dp)
            .border(5.dp, color = Color.Green)
            .size(40.dp)
    )
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
            text = "My Text", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough, TextDecoration.Underline
                )
            )
        )

        Text(text = "My Text", textDecoration = TextDecoration.None, fontSize = 30.sp)
    }
}
