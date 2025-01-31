package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public Book getBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}

	public void deleteBook(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new RuntimeException("Book with id " + id + " not found");
		}
		bookRepository.deleteById(id);
	}

	public List<Book> searchBooks(String title) {
		return bookRepository.findByTitleContainingIgnoreCase(title);
	}

	// Method to delete a book by its ID
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
}
