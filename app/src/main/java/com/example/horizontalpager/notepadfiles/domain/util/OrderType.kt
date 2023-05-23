package com.example.horizontalpager.notepadfiles.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
