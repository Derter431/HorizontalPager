package com.example.horizontalpager.notepadfiles.domain.use_case

import com.example.horizontalpager.notepadfiles.domain.model.Note
import com.example.horizontalpager.notepadfiles.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}