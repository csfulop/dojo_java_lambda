package hu.fcs.dojo.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class AnimalFilter {
    public static void printAnimalsYoungerThan(List<Animal> animals, int age) {
        for (Animal animal : animals) {
            if (animal.getAge() < age) {
                System.out.println(animal.getName());
            }
        }
    }

    public static void printAnimalsWithChecker(List<Animal> animals, CheckAnimal checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.println(animal.getName());
            }
        }
    }

    public static void printAnimalsWithPredicate(List<Animal> animals, Predicate<Animal> predicate) {
        for (Animal animal : animals) {
            if (predicate.test(animal)) {
                System.out.println(animal.getName());
            }
        }
    }

    public static void processAnimals(List<Animal> animals, Predicate<Animal> predicate, Consumer<Animal> consumer) {
        for (Animal animal : animals) {
            if (predicate.test(animal)) {
                consumer.accept(animal);
            }
        }
    }

    public static void processAnimals(List<Animal> animals, Predicate<Animal> predicate, Function<Animal, String> mapper, Consumer<String> consumer) {
        for (Animal animal : animals) {
            if (predicate.test(animal)) {
                String data = mapper.apply(animal);
                consumer.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(
        List<X> elements,
        Predicate<X> predicate,
        Function<X, Y> mapper,
        Consumer<Y> consumer
    ) {
        for (X element : elements) {
            if (predicate.test(element)) {
                Y data = mapper.apply(element);
                consumer.accept(data);
            }
        }
    }

    public static <X, Y> void processElementsWithStream(
        List<X> elements,
        Predicate<X> predicate,
        Function<X, Y> mapper,
        Consumer<Y> consumer
    ) {
        elements.
            stream().
            filter(predicate).
            map(mapper).
            forEach(consumer);
    }

}
