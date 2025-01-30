package com.example.mirinfo.viewModel

import androidx.lifecycle.ViewModel
import com.example.mirinfo.data.models.Book
import com.example.mirinfo.data.repositories.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BookViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook: StateFlow<Book?> = _selectedBook

    init {
        loadBooks()
    }

    private fun loadBooks() {
        _books.value = BookRepository.getBooks()
    }

    fun selectBook(book: Book) {
        _selectedBook.value = book
    }
}