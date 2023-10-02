package creational.builder_prototype;

import creational.factory.ZooDuties;
import creational.singletone.Zoo;

import java.util.ArrayList;
import java.util.List;
// interfata clonable
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
    public Object clone() {
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

    //inner class ZooWorkerBuilder
    public static class ZooWorkerBuilder {
        private List<String> workZoo;
        private String fullName;
        private int salary;
        private Zoo zoo;

        //fiecare variabila are functia seter
        public ZooWorkerBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this; //ne intoarce inapoi in constructor
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
}
