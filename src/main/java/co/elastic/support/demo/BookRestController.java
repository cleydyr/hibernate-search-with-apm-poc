package co.elastic.support.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/indexSomething")
    public List<Book> indexSomething() {
        Book book = new Book();
        book.setTitle("De Brevitate Vitae");
        book.setIsbn(UUID.randomUUID().toString());
        book.setPageCount(200);

        bookRepository.save(book);

        return bookRepository.findAll();
    }
}
