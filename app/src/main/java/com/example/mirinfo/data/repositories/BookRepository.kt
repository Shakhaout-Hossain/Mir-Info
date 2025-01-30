package com.example.mirinfo.data.repositories

import com.example.mirinfo.data.models.Book

object BookRepository {
    fun getBooks(): List<Book> {
        return listOf(
            Book(1, "1984", "George Orwell"),
            Book(2, "To Kill a Mockingbird", "Harper Lee"),
            Book(3, "The Great Gatsby", "F. Scott Fitzgerald"),
            Book(4, "Moby Dick", "Herman Melville")
        )
    }
}