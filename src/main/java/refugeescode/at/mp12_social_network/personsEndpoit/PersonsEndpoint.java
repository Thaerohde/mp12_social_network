package refugeescode.at.mp12_social_network.personsEndpoit;

import org.springframework.web.bind.annotation.*;
import refugeescode.at.mp12_social_network.persistence.model.Person;
import refugeescode.at.mp12_social_network.persistence.repository.PersonRepository;

import java.security.Permissions;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@RestController
@RequestMapping("/persons")
public class PersonsEndpoint {


    private PersonRepository personRepository;


    public PersonsEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> getAll() {
        return personRepository.findAll();
    }

    @PostMapping
    Person addPerson(@RequestBody String person) {
        personRepository.save(new Person(person));
        return new Person(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void makeFriebdship(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Person> person1 = personRepository.findById(id1);
        Optional<Person> person2 = personRepository.findById(id2);
        if (person1.isPresent() && person2.isPresent()) {
            person1.get().getFriend().add(person2.get());
            personRepository.save(person1.get());
        }

    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void removeFriebdship(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Person> person1 = personRepository.findById(id1);
        Optional<Person> person2 = personRepository.findById(id2);
        if (person1.isPresent() && person2.isPresent()) {
            person1.get().getFriend().remove(person2.get());
            personRepository.save(person1.get());
        }


    }
}

