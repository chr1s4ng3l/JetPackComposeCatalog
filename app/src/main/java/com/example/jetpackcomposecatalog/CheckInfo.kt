package com.example.jetpackcomposecatalog

data class CheckInfo(
    val title: String,
    val selected: Boolean = false,
    var onCheckedChanged: (Boolean) -> Unit
)
