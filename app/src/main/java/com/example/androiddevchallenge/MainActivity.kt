/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!

@Composable
fun MyApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController, startDestination = "DogList") {
            composable("DogList") {
                DogList { dog ->
                    navController.navigate("DogDetail/${dog.id}")
                }
            }
            composable(
                "DogDetail/{dogId}",
                arguments = listOf(navArgument("dogId") { type = NavType.StringType })
            ) { backStackEntry ->
                val dog = backStackEntry.arguments?.getString("dogId")
                    ?.let { dogId -> list.find { it.id == dogId } }
                    ?: Dog("-1", "unknown", 0, Sex.MALE)
                DogDetail(dog)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun DogList(onDogSelected: (Dog) -> Unit = {}) {
    LazyColumn {
        items(list.size) {
            val dog = list[it]
            Text(
                text = dog.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onDogSelected(dog)
                    }
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun DogDetail(dog: Dog) {
    Column {
        Text(
            text = dog.name,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = "age : ${dog.age}",
            fontSize = 22.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = dog.sex.toString(),
            fontSize = 22.sp,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun DogDetailPreview() {
    DogDetail(list.first())
}
