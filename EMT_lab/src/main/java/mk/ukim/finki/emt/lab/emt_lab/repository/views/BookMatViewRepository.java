package mk.ukim.finki.emt.lab.emt_lab.repository.views;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.lab.emt_lab.model.views.BookMatView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMatViewRepository extends JpaRepository<BookMatView, Long> {
}
