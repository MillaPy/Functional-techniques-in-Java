package imperative;
import java.util.List;
//import com.sun.tools.javac.util.List;
import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.Collectors;

import static imperative.main.Gender.*;
import static java.lang.System.*;
import static java.lang.System.out;
import static java.util.stream.Collectors.*;

public class main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Milla", FEMALE),
                new Person("Alice", FEMALE),
                new Person("Joshua", MALE),
                new Person("Maxy", FEMALE)
        );

        //imperative approach
        List<Person> females = new ArrayList<>();
        for(Person person : people){
            if (FEMALE.equals(person.gender))
                females.add(person);
        }
        for(Person female : females){
            out.println(female);
        }


        out.println("declarative approach: ");

        //declarative approach
        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(toList());
        females2.forEach(out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }
}
