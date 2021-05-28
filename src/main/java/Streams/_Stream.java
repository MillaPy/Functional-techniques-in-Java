package Streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static Streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Milla", FEMALE),
                new Person("Alice", FEMALE),
                new Person("Joshua", MALE),
                new Person("Maxy", FEMALE),
                new Person("Alex", PREFERNOTOTSAY)
        );

        people.stream()
                .map(person -> person.name)
                .mapToInt(String:: length)
                .forEach(x -> System.out.println(x));
        //transformation

        Predicate<Person> personPredicate =
                person -> PREFERNOTOTSAY.equals(person.gender);
        boolean containconlyfemales = people.stream()
                .noneMatch(personPredicate);

        System.out.println(containconlyfemales);

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
        MALE, FEMALE, PREFERNOTOTSAY
    }
}
