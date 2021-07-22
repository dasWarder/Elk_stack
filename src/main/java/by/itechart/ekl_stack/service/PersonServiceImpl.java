package by.itechart.ekl_stack.service;

import by.itechart.ekl_stack.model.Person;
import by.itechart.ekl_stack.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {

        notNull(person, "The person must be not null");
        log.info("Save a person");

        Person stored = personRepository.save(person);

        return stored;
    }

    @Override
    public Person getPersonById(Long id) {

        notNull(id, "THe id must be not null");
        log.info("Receive a person with ID = {}", id);

        Optional<Person> possiblePerson = personRepository.findById(id);
        Person receivedPerson = possiblePerson.orElseThrow(NullPointerException::new);

        return receivedPerson;
    }

    @Override
    public void deletePersonById(Long id) {

        notNull(id, "The id must be not null");
        log.info("Remove a person with ID = {}", id);

        personRepository.deleteById(id);
    }
}
