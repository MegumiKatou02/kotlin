package com.example.myapplication.model

class Student(val name: String) {
    private val bookList = BookList()

    fun addBook(book: Book = Book("Sách ${bookList.list.size + 1}")) {
        bookList.addBook(book)
    }

    fun getBooks(): List<Book> = bookList.list
}