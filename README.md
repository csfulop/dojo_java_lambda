Java Lambda dojo
----------------

1. Create a class that implements `Runnable` and prints "Hello World!". Execute it with a `Thread`.
1. Create the previous `Runnable` with *Inner Class*, *Local Class* and *Anonymous Inner Class*.
1. Create the previous `Runnable` with a *Lambda Expression*.

1. Create static method `printAnimalsYoungerThan` to filter a `List` of `Animals` whose age is less than a given value and print their `name`. 
Iterate the `List` elements with a `for` loop and check the items in the loop with an `if` condition.
1. Create a `CheckAnimal` interface with a `test` method. The `test` method gets an `Animal` input parameter.
Create a static method `printAnimalsWithChecker` to filter a `List` of `Animals` that match the given checker and print their `name`.
Use an *Anonymous Inner Class* to implement the interface and move the age checking into it.
1. Instead of the *Anonymous Inner Class* use a *Lambda Expression* to implement the `CheckAnimal` interface.   
1. Create a static method `printAnimalsWithPredicate` which uses the standard functional interface `Predicate` instead of our `CheckAnimal` interface.
1. Create a static method `processAnimals` to filter a `List` of `Animals` to match a given `Predicate`.
The method should have a third `Consumer` parameter.
Use a *Lambda Expression* and move the `name` printing logic into it.
1. Create a new version of `processAnimals` similar to the previous one.
It should have a new `Function` parameter.
This `Function` should be used to map an `Animal` to a `String` and now the `Consumer` should accept `String`.
Use this `Function` to separate what to print (the `name` of the `Animal`) from how to print (to the standard output)
1. Use Generics to generalize the previous method and create a new `processElements` method.
It should work with any type parameter of `List` and `Consumer`.
The `Function` should map from the type parameter of the `List` to the type parameter of the `Consumer`. 
1. Create a new static method `processElementsWithStream` which has the same parameters and do the same task as the previous one.
But now instead of the `for` loop and `if` condition use streams.
1. Use the previous method but when calling it use *Method Reference*s for the `Function` and `Consumer` parameters.  

Based on: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
