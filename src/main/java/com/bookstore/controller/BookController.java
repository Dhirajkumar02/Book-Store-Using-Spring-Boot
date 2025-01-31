package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book-list";
    }

    @GetMapping("/new")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book()); // Ensure 'book' is properly initialized
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("book", bookService.getBookById(id));
        } catch (RuntimeException e) {
            return "redirect:/books?error=BookNotFound";
        }
        return "book-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books"; // Redirect back to the book list after deletion
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("title") String title, Model model) {
        model.addAttribute("books", bookService.searchBooks(title));
        return "book-list";
    }
}
