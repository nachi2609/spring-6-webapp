package nachi.springframework.spring6webapp.services;

import nachi.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
