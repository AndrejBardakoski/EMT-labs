package mk.ukim.finki.emt.lab.emt_lab.model.views;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import mk.ukim.finki.emt.lab.emt_lab.model.enums.CategoryEnum;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
public class BookMatView {

    @Id
    private Long bookId;

    private Enum<CategoryEnum> category;

    private String name;

    public BookMatView() {
    }

    public BookMatView(Long bookId, Enum<CategoryEnum> category, String name) {
        this.bookId = bookId;
        this.category = category;
        this.name = name;
    }
}