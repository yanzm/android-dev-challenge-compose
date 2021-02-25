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

import java.util.UUID
import kotlin.random.Random

enum class Sex {
    MALE,
    FEMALE
}

data class Dog(val id: String, val name: String, val age: Int, val sex: Sex)

val dogNameAndSex = listOf(
    "Bailey" to Sex.MALE,
    "Max" to Sex.MALE,
    "Charlie" to Sex.MALE,
    "Buddy" to Sex.MALE,
    "Rocky" to Sex.MALE,
    "Jake" to Sex.MALE,
    "Jack" to Sex.MALE,
    "Toby" to Sex.MALE,
    "Cody" to Sex.MALE,
    "Buster" to Sex.MALE,
    "Duke" to Sex.MALE,
    "Cooper" to Sex.MALE,
    "Riley" to Sex.MALE,
    "Harley" to Sex.MALE,
    "Bear" to Sex.MALE,
    "Tucker" to Sex.MALE,
    "Murphy" to Sex.MALE,
    "Lucky" to Sex.MALE,
    "Oliver" to Sex.MALE,
    "Sam" to Sex.MALE,
    "Oscar" to Sex.MALE,
    "Teddy" to Sex.MALE,
    "Winston" to Sex.MALE,
    "Sammy" to Sex.MALE,

    "Bella" to Sex.FEMALE,
    "Lucy" to Sex.FEMALE,
    "Molly" to Sex.FEMALE,
    "Daisy" to Sex.FEMALE,
    "Maggie" to Sex.FEMALE,
    "Sophie" to Sex.FEMALE,
    "Sadie" to Sex.FEMALE,
    "Chloe" to Sex.FEMALE,
    "Bailey" to Sex.FEMALE,
    "Lola" to Sex.FEMALE,
    "Zoe" to Sex.FEMALE,
    "Abby" to Sex.FEMALE,
    "Ginger" to Sex.FEMALE,
    "Roxy" to Sex.FEMALE,
    "Gracie" to Sex.FEMALE,
    "Coco" to Sex.FEMALE,
    "Sasha" to Sex.FEMALE,
    "Lily" to Sex.FEMALE,
    "Angel" to Sex.FEMALE,
    "Princess" to Sex.FEMALE,
    "Emma" to Sex.FEMALE,
    "Annie" to Sex.FEMALE,
    "Rosie" to Sex.FEMALE,
    "Ruby" to Sex.FEMALE,
)

val list = dogNameAndSex.shuffled().map { (name, sex) ->
    Dog(
        UUID.randomUUID().toString(),
        name,
        Random.nextInt(0, 20),
        sex
    )
}
