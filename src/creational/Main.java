package creational;

import creational.builder_prototype.ZooWorker;
import creational.factory.WorkTypeFactory;
import creational.factory.ZooDuties;
import creational.singletone.Zoo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Singleton
        Zoo zoo = Zoo.getInstance();
        zoo.setName("Alunelu");
        Zoo zoo1 = Zoo.getInstance();
        System.out.println("Zoo name is " + zoo1.getName());
        //Builder
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
        // Crearea functiei pentru zooWorker
        zooWorker.workType(c);
        zooWorker.workType(f);

        // (ZooWorker) generic care ne arata ca obiectul este de tip ZooWorker si nu Object
        ZooWorker zooWorker2 = (ZooWorker) zooWorker.clone(); // Primul zooWorker clonat
        ZooWorker zooWorker3 = (ZooWorker) zooWorker.clone();
        zooWorker3.workType(p); // Al doilea zooWorker i se atribuie si functia Protect
        ZooWorker zooWorker4 = (ZooWorker) zooWorker.clone();
        zooWorker4.deleteWork(c); // Al treilea zooWorker i se sterge functia Clean

        System.out.println(zooWorker2.getZooWork());
        System.out.println(zooWorker3.getZooWork());
        System.out.println(zooWorker4.getZooWork());
    }
}
