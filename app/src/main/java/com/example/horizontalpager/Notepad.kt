package com.example.horizontalpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun Notepad() {
    Column(modifier = Modifier.fillMaxSize()) {
       Image(painter = painterResource(id = R.drawable.notepad), contentDescription = "notepad" )

    }
}