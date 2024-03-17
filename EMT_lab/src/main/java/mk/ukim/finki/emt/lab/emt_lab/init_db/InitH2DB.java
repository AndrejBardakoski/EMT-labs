package mk.ukim.finki.emt.lab.emt_lab.init_db;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.lab.emt_lab.model.Country;
import mk.ukim.finki.emt.lab.emt_lab.model.enums.CategoryEnum;
import mk.ukim.finki.emt.lab.emt_lab.service.AuthorService;
import mk.ukim.finki.emt.lab.emt_lab.service.BookService;
import mk.ukim.finki.emt.lab.emt_lab.service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class InitH2DB {
    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public InitH2DB(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    private void init() {
        initCountry();
        initAuthor();
        initBook();
    }

    private void initCountry() {

        countryService.save("Macedonia", "Europe");
        countryService.save("Russia", "Europe");
        countryService.save("UK", "Europe");
        countryService.save("France", "Europe");
        countryService.save("Germany", "Europe");
        countryService.save("USA", "North America");
        countryService.save("Mexico", "North America");
        countryService.save("Pakistan", "Asia");
        countryService.save("India", "Asia");
        countryService.save("Nepal", "Asia");
        countryService.save("Japan", "Asia");
        countryService.save("China", "Asia");
    }

    private void initAuthor() {
        authorService.save("William", "Shakespeare", 3L);
        authorService.save("Agatha", "Agatha", 3L);
        authorService.save("Agatha", "Agatha", 3L);
        authorService.save("Leo", "Tolstoy", 2L);
        authorService.save("Alexander", "Pushkin", 2L);
        authorService.save("Rene", "Goscinny", 4L);
        authorService.save("Mickey", "Spillane", 6L);
    }

    private void initBook() {
        bookService.save("Romeo and Juliet", CategoryEnum.DRAMA,1L,12);
        bookService.save("Othello", CategoryEnum.DRAMA,1L,5);
        bookService.save("Richard III", CategoryEnum.HISTORY,1L,5);
        bookService.save("Murder on the Orient Express", CategoryEnum.THRILLER,2L,4);
        bookService.save("War and Peace", CategoryEnum.NOVEL,4L,24);
        bookService.save("Anna Karenina", CategoryEnum.NOVEL,4L,7);
        bookService.save("Eugene Onegin", CategoryEnum.CLASSICS,5L,7);
    }

}
