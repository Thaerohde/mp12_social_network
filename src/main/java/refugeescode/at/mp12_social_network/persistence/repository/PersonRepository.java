package refugeescode.at.mp12_social_network.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import refugeescode.at.mp12_social_network.persistence.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
