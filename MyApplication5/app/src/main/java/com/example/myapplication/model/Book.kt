package com.example.myapplication.model

data class Book(val name: String)

class BookList {
    private val _list: MutableList<Book> = mutableListOf()

    val list: List<Book>
        get() = _list.toList()

    fun addBook(book: Book) {
        _list.add(book)
    }
}
