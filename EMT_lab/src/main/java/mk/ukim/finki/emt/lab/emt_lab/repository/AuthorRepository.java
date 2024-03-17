package mk.ukim.finki.emt.lab.emt_lab.repository;

import mk.ukim.finki.emt.lab.emt_lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
