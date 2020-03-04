package controllers;

import entities.Book;
import services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    private BookService bookService;

    @Autowired
    public void setStudentsService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        List<Book> allBooks = bookService.getAllBooksList();
        model.addAttribute("bookList", allBooks);
        return "main";
    }    
}
