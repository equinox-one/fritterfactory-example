package one.equinox.fritterfactory.example.model;

import one.equinox.symbols.Symbolize;
import org.joda.time.LocalDate;

/**
 * Sample model of a person
 */
@Symbolize
public class Person {
    String name;
    String surname;
    int age;
    Adress adress;
    String description;
    Category category;
    LocalDate birthDate;
    String image;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", adress=" + adress +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", birthDate=" + birthDate +
                ", image='" + image + '\'' +
                '}';
    }
}
