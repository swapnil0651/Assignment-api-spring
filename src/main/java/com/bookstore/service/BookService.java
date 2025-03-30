package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Transactional
    public Book createBook(BookDto bookDto) {
        Book book = new Book();
        updateBookFromDto(book, bookDto);
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Long id, BookDto bookDto) {
        Book book = getBookById(id);
        updateBookFromDto(book, bookDto);
        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Book> searchBooks(String title, String author, String category, Double rating, Pageable pageable) {
        if (title != null) {
            return bookRepository.searchByTitle(title, pageable);
        } else if (author != null) {
            return bookRepository.findByAuthorContainingIgnoreCase(author, pageable);
        } else if (category != null) {
            return bookRepository.findByCategoryContainingIgnoreCase(category, pageable);
        } else if (rating != null) {
            return bookRepository.findByRating(rating, pageable);
        }
        return bookRepository.findAll(pageable);
    }

    private void updateBookFromDto(Book book, BookDto dto) {
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setCategory(dto.getCategory());
        book.setPrice(dto.getPrice());
        book.setRating(dto.getRating());
        book.setPublishedDate(dto.getPublishedDate());
    }
} 