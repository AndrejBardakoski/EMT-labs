package mk.ukim.finki.emt.lab.emt_lab.service;

import mk.ukim.finki.emt.lab.emt_lab.model.Book;
import mk.ukim.finki.emt.lab.emt_lab.model.DTO.BookDTO;
import mk.ukim.finki.emt.lab.emt_lab.model.enums.CategoryEnum;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Enum<CategoryEnum> category, Long authorId, Integer availableCopies);
    Optional<Book> edit(Long id,String name, Enum<CategoryEnum> category, Long authorId, Integer availableCopies);
    Optional<Book> save(BookDTO bookDTO);
    Optional<Book> edit(Long id,BookDTO bookDTO);
    void deleteById (Long id);
    Optional<Book> rent(Long id);

}
