package com.example.horizontalpager.notepadfiles.presentation.notes

import com.example.horizontalpager.notepadfiles.domain.model.Note
import com.example.horizontalpager.notepadfiles.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()

}
