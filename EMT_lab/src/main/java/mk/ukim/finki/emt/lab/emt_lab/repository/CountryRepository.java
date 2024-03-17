package mk.ukim.finki.emt.lab.emt_lab.repository;

import mk.ukim.finki.emt.lab.emt_lab.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository  extends JpaRepository<Country, Long> {
}
