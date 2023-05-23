package com.example.horizontalpager.notepadfiles.presentation.notes

import com.example.horizontalpager.notepadfiles.domain.model.Note
import com.example.horizontalpager.notepadfiles.domain.util.NoteOrder
import com.example.horizontalpager.notepadfiles.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
