package mk.ukim.finki.emt.lab.emt_lab.repository;

import mk.ukim.finki.emt.lab.emt_lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
