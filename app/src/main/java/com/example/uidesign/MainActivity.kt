package com.example.uidesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.uidesign.ui.theme.UIDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextScreen()
                }
            }
        }
    }
}
@Composable
fun TextScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        MyText("JetPack Compose")
        MyTextField()
    }
}
@Composable
fun MyText(name: String) {
    Text(text = "Hello $name!",
    fontStyle= FontStyle.Italic,
    color = colorResource(id = R.color.teal_200),
    fontSize = 30.sp,
    fontWeight = FontWeight.Bold
    )
}

@Composable
fun MyTextField(){
    val textValue= remember { mutableStateOf(" ") }
    
        TextField(
        value = textValue.value, onValueChange = {textValue.value= it},
        label = {}
        )

    OutlinedTextField(
        label = { Text(text = stringResource(id =
        R.string.email)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.teal_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_700)
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType
        = KeyboardType.Email),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
    )
    }



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UIDesignTheme {
        MyText("Android")
    }
}