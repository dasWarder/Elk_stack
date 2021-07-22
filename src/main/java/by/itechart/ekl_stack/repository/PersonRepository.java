package by.itechart.ekl_stack.repository;

import by.itechart.ekl_stack.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
