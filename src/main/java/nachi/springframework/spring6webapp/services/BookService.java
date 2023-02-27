package nachi.springframework.spring6webapp.services;

import nachi.springframework.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
