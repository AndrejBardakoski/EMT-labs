package mk.ukim.finki.emt.lab.emt_lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.lab.emt_lab.model.enums.CategoryEnum;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    Long id;

    String name;

    Enum<CategoryEnum> category;

    @ManyToOne
    Author author;

    Integer avalibleCopies;

    public Book() {
    }

    public Book(String name, Enum<CategoryEnum> category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.avalibleCopies = availableCopies;
    }
}

