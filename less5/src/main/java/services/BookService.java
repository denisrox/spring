package services;

import entities.Book;
import repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BooksRepository booksRepository;

    @Autowired
    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BookService() {
    }

    public List<Book> getAllBooksList() {
        return (List<Book>)booksRepository.findAll();
    }

    public void addBook(Book s) {
        booksRepository.save(s);
    }

    public void removeById(Long id) {
        booksRepository.deleteById(id);
    }
}
