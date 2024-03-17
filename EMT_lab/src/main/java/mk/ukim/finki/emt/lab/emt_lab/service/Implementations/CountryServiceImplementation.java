package mk.ukim.finki.emt.lab.emt_lab.service.Implementations;

import mk.ukim.finki.emt.lab.emt_lab.model.Country;
import mk.ukim.finki.emt.lab.emt_lab.model.exeptions.CountryNotFoundException;
import mk.ukim.finki.emt.lab.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt.lab.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImplementation implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = countryRepository.findById(id).orElseThrow(CountryNotFoundException::new);

        country.setContinent(continent);
        country.setName(name);

        countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
