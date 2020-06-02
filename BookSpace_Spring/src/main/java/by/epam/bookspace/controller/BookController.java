package by.epam.bookspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String main() {
        return "books";
    }

    @GetMapping("/add")
    public String add() {
        return "add_book";
    }

    @GetMapping("/all")
    public String all() {
        return "all_book";
    }
}
