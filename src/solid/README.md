# Author: Siretanu Andreia-Cristina

----

# Topic: *SOLID PRINCIPLES*
## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I have have created a simulation of an Zoo with animals.

* Snippets from your files.

* S -> Single Responsibility:
```java
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

```
* O -> Open Close:

I have added Movable and it's derivative classes.

* L -> Liskov Substitution:
```java
AnimalMind animalAction = new AnimalAction("Action");
```
* I -> Interface Segregation:
```java
Eater dog = new Dog();
```

* D -> Dependency Inversion:
```java
public class AnimalEatingAction implements AnimalHabit {
    //dependency inversion
    private Eater eater;

    //constructor (Dependency Injection)
    public AnimalEatingAction(Eater eater) {
        this.eater = eater;
    }

    public void performAction() {
        eater.eat();
    }
}
```

## Conclusion
To sum up, I have created a simulation of Zoo that have different animals and their functions.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.