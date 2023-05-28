package com.example.horizontalpager.notepadfiles.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.horizontalpager.notepadfiles.presentation.add_edit_note.AddEditNoteScreen
import com.example.horizontalpager.notepadfiles.presentation.notes.NotesScreen
import com.example.horizontalpager.notepadfiles.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun Notepad() {
    Column(modifier = Modifier.fillMaxSize()) {
val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.NotesScreen.route
        ) {
            composable(route = Screen.NotesScreen.route) {
                NotesScreen(navController = navController)
            }
            composable(
                route = Screen.AddEditNoteScreen.route +
                        "?noteId={noteId}&noteColor={noteColor}",
                arguments = listOf(
                    navArgument(
                        name = "noteId"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                    navArgument(
                        name = "noteColor"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                )
            ) {
                val color = it.arguments?.getInt("noteColor") ?: -1
                AddEditNoteScreen(
                    navController = navController,
                    noteColor = color)
            }
        }

    }
}