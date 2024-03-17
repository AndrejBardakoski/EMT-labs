package mk.ukim.finki.emt.lab.emt_lab.service.Implementations;

import mk.ukim.finki.emt.lab.emt_lab.model.Author;
import mk.ukim.finki.emt.lab.emt_lab.model.Country;
import mk.ukim.finki.emt.lab.emt_lab.model.exeptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab.emt_lab.model.exeptions.CountryNotFoundException;
import mk.ukim.finki.emt.lab.emt_lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt.lab.emt_lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(CountryNotFoundException::new);
        Author author = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);

        author.setCountry(country);
        author.setName(name);
        author.setSurname(surname);
        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(CountryNotFoundException::new);

        Author author = new Author(name, surname, country);
        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
