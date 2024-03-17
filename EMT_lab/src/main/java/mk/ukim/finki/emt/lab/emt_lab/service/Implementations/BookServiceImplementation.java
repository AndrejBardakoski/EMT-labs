package mk.ukim.finki.emt.lab.emt_lab.service.Implementations;

import mk.ukim.finki.emt.lab.emt_lab.model.Author;
import mk.ukim.finki.emt.lab.emt_lab.model.Book;
import mk.ukim.finki.emt.lab.emt_lab.model.DTO.BookDTO;
import mk.ukim.finki.emt.lab.emt_lab.model.enums.CategoryEnum;
import mk.ukim.finki.emt.lab.emt_lab.model.exeptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab.emt_lab.model.exeptions.BookNotFoundExceptuin;
import mk.ukim.finki.emt.lab.emt_lab.model.exeptions.NoAvailableBookCopiesExeption;
import mk.ukim.finki.emt.lab.emt_lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.emt_lab.repository.BookRepository;
import mk.ukim.finki.emt.lab.emt_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Enum<CategoryEnum> category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);

        Book book = new Book(name, category, author, availableCopies);
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Enum<CategoryEnum> category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundExceptuin::new);

        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvalibleCopies(availableCopies);

        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        CategoryEnum categoryEnum = CategoryEnum.values()[bookDTO.getCategory()];
        return save(bookDTO.getName(), categoryEnum, bookDTO.getAuthorId(), bookDTO.getAvailableCopies());
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        CategoryEnum categoryEnum = CategoryEnum.values()[bookDTO.getCategory()];
        return edit(id, bookDTO.getName(), categoryEnum, bookDTO.getAuthorId(), bookDTO.getAvailableCopies());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rent(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundExceptuin::new);
        Integer availableCopies = book.getAvalibleCopies();
        if (availableCopies <= 0) {
            throw new NoAvailableBookCopiesExeption();
        }
        availableCopies -= 1;
        book.setAvalibleCopies(availableCopies);
        bookRepository.save(book);
        return Optional.of(book);
    }
}
