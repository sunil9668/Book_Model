package com.book.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.repository.BookRepository;
import com.book.vo.Book;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository repository;

	@InjectMocks
	private BookServiceImpl service;

	@Test
	void testGetBookById() {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("Title");
		book.setAuthor("Author");
		book.setPublicationYear(2020);

		when(repository.findById(1L)).thenReturn(Optional.of(book));

		Book result = service.getBookById(1L);
		assertEquals("Title", result.getTitle());
	}
}
