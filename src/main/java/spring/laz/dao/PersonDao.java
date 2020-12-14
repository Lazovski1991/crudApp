package spring.laz.dao;

import org.springframework.stereotype.Component;
import spring.laz.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Voloda"));
        people.add(new Person(++PEOPLE_COUNT, "Sasha"));
        people.add(new Person(++PEOPLE_COUNT, "Valera"));
        people.add(new Person(++PEOPLE_COUNT, "Vasa"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
