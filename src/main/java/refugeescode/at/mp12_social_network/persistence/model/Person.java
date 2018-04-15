package refugeescode.at.mp12_social_network.persistence.model;


import javax.persistence.*;
import java.security.PrivateKey;
import java.util.*;

@Entity
public class Person {


    @GeneratedValue
    @Id
 private Long id;
 private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Person> friend  = new ArrayList<>();

    public Person() {
    }

    public Person(String name){
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriend() {
        return friend;
    }

    public void setFriend(List  <Person> friend) {
        this.friend = friend;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }

}
