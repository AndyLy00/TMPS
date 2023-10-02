# Author: Siretanu Andreia-Cristina

----

# Topic: *Creational Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

&ensp; &ensp; Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

## Implementation

* Introduction

I decided to implement Singleton, Builder, Prototype and Factory design principles.
I created a java program where there is a Zoo and it is shown its workers. Also, workers has their own list of duties where they can work.

* Snippets from your files.

* Singleton Principle:

```java
public class Zoo {
    private static Zoo zoo;
    private String name;

    private Zoo() {
    }

    public static Zoo getInstance() {
        if (zoo == null) {
            zoo = new Zoo();
        }
        return zoo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

* Prototype Principle:

```java
@Override
public class ZooWorker implements Cloneable {
    private List<String> zooWork;
    private String fullName;
    private int salary;
    private Zoo zoo;

    public ZooWorker(ZooWorkerBuilder builder) {
        this.zooWork = builder.workZoo;
        this.fullName = builder.fullName;
        this.salary = builder.salary;
        this.zoo = builder.zoo;
    }

    public void workType(ZooDuties zooDuties) {
        zooWork.add(zooDuties.work());
    }

    public void deleteWork(ZooDuties zooDuties) {
        zooWork.remove(zooDuties.work());
    }

    public List<String> getZooWork() {
        return zooWork;
    }

    public String getFullName() {
        return fullName;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempWork = new ArrayList<String>(this.getZooWork());
        String tempFullName = this.getFullName();
        int tempSalary = this.getSalary();
        Zoo tempZoo = this.getZoo();
        return new ZooWorkerBuilder()
                .setSalary(tempSalary)
                .setZoo(tempZoo)
                .setZooWork(tempWork)
                .setFullName(tempFullName)
                .build();
    }
```

* Builder Principle:

```java
public static class ZooWorkerBuilder {
    private List<String> workZoo;
    private String fullName;
    private int salary;
    private Zoo zoo;

    public ZooWorkerBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public ZooWorkerBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public ZooWorkerBuilder setZooWork(List<String> zooWork) {
        this.workZoo = zooWork;
        return this;
    }

    public ZooWorkerBuilder setZoo(Zoo zoo) {
        this.zoo = zoo;
        return this;
    }

    public ZooWorker build() {
        return new ZooWorker(this);
    }
}
```

* Factory Principle:

```java
public class WorkTypeFactory {
    public ZooDuties ZooWorkType(String work)
    {
        if (work == null || work.isEmpty())
            return null;
        return switch (work) {
            case "P" -> new Protect();
            case "F" -> new Feed();
            case "C" -> new Clean();
            default -> throw new IllegalArgumentException("Unknown work " + work);
        };
    }
}
```

Main Class:

```java
 public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Zoo zoo = Zoo.getInstance();
        zoo.setName("Alunelu");
        Zoo zoo1 = Zoo.getInstance();
        System.out.println("Zoo name is " + zoo.getName());
        ZooWorker zooWorker = new ZooWorker.ZooWorkerBuilder()
                .setZooWork(new ArrayList<>())
                .setSalary(200)
                .setZoo(zoo)
                .setFullName("Valera")
                .build();

        WorkTypeFactory workTypeFactory = new WorkTypeFactory();
        ZooDuties c = workTypeFactory.ZooWorkType("C");
        ZooDuties f = workTypeFactory.ZooWorkType("F");
        ZooDuties p = workTypeFactory.ZooWorkType("P");
        zooWorker.workType(c);
        zooWorker.workType(f);
    
        ZooWorker zooWorker2 = (ZooWorker) zooWorker.clone();
        ZooWorker zooWorker3 = (ZooWorker) zooWorker.clone();
        zooWorker3.workType(p);
        ZooWorker zooWorker4 = (ZooWorker) zooWorker.clone();
        zooWorker4.deleteWork(c);

        System.out.println(zooWorker2.getZooWork());
        System.out.println(zooWorker3.getZooWork());
        System.out.println(zooWorker4.getZooWork());
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I choosed.
In my code I managed to implement somehow 4 creational design patterns. Moreover, I managed not only to copy and use them,
but also to connect 2 patterns in one class.