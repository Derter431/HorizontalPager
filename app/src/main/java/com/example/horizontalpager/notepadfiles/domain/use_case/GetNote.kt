package com.example.horizontalpager.notepadfiles.domain.use_case

import com.example.horizontalpager.notepadfiles.domain.model.Note
import com.example.horizontalpager.notepadfiles.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}