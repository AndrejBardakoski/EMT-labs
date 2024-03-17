package mk.ukim.finki.emt.lab.emt_lab.model.DTO;

import lombok.Data;

@Data
public class BookDTO {

    String name;

    Integer category;

    Long authorId;

    Integer availableCopies;

    public BookDTO() {
    }

    public BookDTO(String name, Integer category, Long authorId, Integer avalibleCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = avalibleCopies;
    }
}
