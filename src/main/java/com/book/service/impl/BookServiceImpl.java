package com.book.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.repository.BookRepository;
import com.book.service.BookService;
import com.book.vo.Book;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository repository;

	@Autowired
	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found"));
	}

	@Override
	public Book createBook(Book book) {
		return repository.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		Book existing = getBookById(id);
		existing.setTitle(book.getTitle());
		existing.setAuthor(book.getAuthor());
		existing.setPublicationYear(book.getPublicationYear());
		return repository.save(existing);
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
}
