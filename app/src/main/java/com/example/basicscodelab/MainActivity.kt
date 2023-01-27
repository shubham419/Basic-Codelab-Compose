package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import androidx.compose.runtime.remember


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize() )
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier , names : List<String> = listOf("World", "compose")){
    Column(modifier = Modifier.padding(vertical = 4.dp) ) {
        for(name in names){
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember{ mutableStateOf(false) }
    val extraPadding = if(expanded.value) 48.dp else 0.dp
    Surface(color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp) ){
        Row(modifier =  Modifier.padding(24.dp) ) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
               ) {
                Text(text = "Hello,")
                Text(text = "$name!" )
        }
            ElevatedButton(onClick = {
                expanded.value = !expanded.value
            }) {
                Text( if (expanded.value)  "show more" else "Show less")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
      MyApp(modifier = Modifier.fillMaxSize())
    }
}