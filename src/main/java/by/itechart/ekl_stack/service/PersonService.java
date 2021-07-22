package by.itechart.ekl_stack.service;

import by.itechart.ekl_stack.model.Person;

public interface PersonService {

    Person savePerson(Person person);

    Person getPersonById(Long id);

    void deletePersonById(Long id);
}
