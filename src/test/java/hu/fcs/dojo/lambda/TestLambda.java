package hu.fcs.dojo.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class TestLambda {
    @Test
    void test01_runnable() throws InterruptedException {
        runInThread(new MyRunnable());
    }

    private class MyInnerRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello World!");
        }
    }

    @Test
    void test02A_runnableWithInnerClass() throws InterruptedException {
        runInThread(new MyInnerRunnable());
    }

    @Test
    void test02B_runnableWithLocalClass() throws InterruptedException {
        class MyLocalRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }
        runInThread(new MyLocalRunnable());
    }

    @Test
    void test02C_runnableWithAnonymousInnerClass() throws InterruptedException {
        runInThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
    }

    @Test
    void test03_runnableWithLambda() throws InterruptedException {
        runInThread(() -> System.out.println("Hello World!"));
    }

    private void runInThread(Runnable runnable) throws InterruptedException {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
    }

    private List<Animal> animals = Arrays.asList(
        new Dog("Morzsi", 2),
        new Cat("Kormi", 1)
    );

    @Test
    void test04_filterAnimals() {
        AnimalFilter.printAnimalsYoungerThan(animals, 2);
    }

    @Test
    void test05_filterAnimalsWithChecker() {
        AnimalFilter.printAnimalsWithChecker(animals, new CheckAnimal() {
            @Override
            public boolean test(Animal animal) {
                return animal.getAge() < 2;
            }
        });
    }

    @Test
    void test06_filterAnimalsWithCheckerLambda() {
        AnimalFilter.printAnimalsWithChecker(animals, animal -> animal.getAge() < 2);
    }

    @Test
    void test07_filterAnimalsWithCheckerLambda() {
        AnimalFilter.printAnimalsWithPredicate(animals, animal -> animal.getAge() < 2);
    }

    @Test
    void test08_filterAnimalsWithPredicateAndConsumer() {
        AnimalFilter.processAnimals(
            animals,
            animal -> animal.getAge() < 2,
            animal -> System.out.println(animal.getName())
        );
    }

    @Test
    void test09_filterAnimalsWithPredicateMapperAndConsumer() {
        AnimalFilter.processAnimals(
            animals,
            animal -> animal.getAge() < 2,
            animal -> animal.getName(),
            data -> System.out.println(data)
        );
    }

    @Test
    void test10_filterElementsWithPredicateMapperAndConsumer() {
        AnimalFilter.processElements(
            animals,
            animal -> animal.getAge() < 2,
            animal -> animal.getName(),
            data -> System.out.println(data)
        );
    }

    @Test
    void test11_filterElementsWithStreams() {
        AnimalFilter.processElementsWithStream(
            animals,
            animal -> animal.getAge() < 2,
            animal -> animal.getName(),
            data -> System.out.println(data)
        );
    }

    @Test
    void test12_filterElementsWithStreamsAndMethodReferences() {
        AnimalFilter.processElementsWithStream(
            animals,
            animal -> animal.getAge() < 2,
            Animal::getName,
            System.out::println
        );
    }
}
