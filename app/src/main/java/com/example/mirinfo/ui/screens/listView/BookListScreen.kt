package com.example.mirinfo.ui.screens.listView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mirinfo.data.models.Book
import com.example.mirinfo.viewModel.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(
    modifier: Modifier = Modifier,
    bookViewModel: BookViewModel = viewModel(),
    onBookClick: (Book) -> Unit
) {
    val books by bookViewModel.books.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Book List") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(books) { book ->
                BookItem(book, onBookClick)
            }
        }
    }
}

@Composable
fun BookItem(book: Book, onBookClick: (Book) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onBookClick(book) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = book.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = book.author, style = MaterialTheme.typography.bodyMedium)
        }
    }
}