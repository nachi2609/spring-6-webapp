package nachi.springframework.spring6webapp.bootstrap;

import nachi.springframework.spring6webapp.domain.Author;
import nachi.springframework.spring6webapp.domain.Book;
import nachi.springframework.spring6webapp.domain.Publisher;
import nachi.springframework.spring6webapp.repositories.AuthorRepository;
import nachi.springframework.spring6webapp.repositories.BookRepository;
import nachi.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstname("Eric");
        eric.setLastname("Evans");

        Book b = new Book();
        b.setTitle("Domain Driven Design");
        b.setIsbn("123456");


        Author ericSaved = authorRepository.save(eric);
        Book bSaved = bookRepository.save(b);

        Author rod = new Author();
        rod.setFirstname("Rod");
        rod.setLastname("Johnson");

        Book b1 = new Book();
        b1.setTitle("J2EE Development without EJB");
        b1.setIsbn("545454");

        Author rodSaved = authorRepository.save(rod);
        Book bbSaved = bookRepository.save(b1);


        ericSaved.getBooks().add(bSaved);
        rodSaved.getBooks().add(bbSaved);
        bSaved.getAuthors().add(ericSaved);
        bbSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Only Publisher");
        publisher.setAddress("4757 Drayton");
        publisher.setCity("Catonsville");
        publisher.setState("Maryland");
        publisher.setZip("21250");
        Publisher pubSaved = publisherRepository.save(publisher);

        bSaved.setPublisher(pubSaved);
        bbSaved.setPublisher(pubSaved);

        pubSaved.getBooks().add(bSaved);
        pubSaved.getBooks().add(bbSaved);


        authorRepository.save(rodSaved);
        authorRepository.save(ericSaved);
        bookRepository.save(bSaved);
        bookRepository.save(bbSaved);

        System.out.println("In Botstrap");
        System.out.println("Publisher Count :"+publisherRepository.count());
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
