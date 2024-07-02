package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsCodelabTheme {
                    MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val names: List<String> = List(20) { "$it" }

    Surface(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ) {
        LazyColumn {
           items(names){
                name -> CardList(name = name)
           }
        }
    }
}

@Composable
fun CardList(name: String) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Card(
        modifier = Modifier.padding(vertical = 8.dp),
        colors = CardColors(
            contentColor = Color.White,
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding),
            ) {
                Text(text = name)
                Spacer(modifier = Modifier.height(16.dp))
                if (expanded) CardListItems()
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }

    }
}

@Composable
fun CardListItems() {
    Row(
        modifier = Modifier.fillMaxSize().border(2.dp, color = Color.White)
    ) {
        Text(text = "Items here")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}