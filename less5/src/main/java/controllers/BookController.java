package controllers;

import entities.Book;
import services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setStudentsService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Book book = new Book();
        book.setName("Unknown");
        book.setDated("1999-05-10 00:00:00");
        book.setTitle("Unknown");
        model.addAttribute("book", book);
        return "add-book-form";
    }
    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Book book) {
        bookService.addBook(book);
        return "redirect:/";
    }
}
