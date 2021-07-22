package by.itechart.ekl_stack.controller;

import by.itechart.ekl_stack.model.Person;
import by.itechart.ekl_stack.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    @PostMapping
    public ResponseEntity savePerson(@RequestBody final Person person) {

        log.info("POST request for saving person");
        Person storedPerson = personService.savePerson(person);

        return ResponseEntity.created(URI.create("/person")).body(storedPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") final  Long id) {

        log.info("GET request for receiving a person by ID = {}", id);
        Person personById = personService.getPersonById(id);

        return ResponseEntity.ok(personById);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") final Long id) {

        log.info("DELETE request for removing a person with ID = {}", id);
        personService.deletePersonById(id);

        return ResponseEntity.noContent().build();
    }

}
