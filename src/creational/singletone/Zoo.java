package creational.singletone;

public class Zoo {
    //static - creat doar o data
    private static Zoo zoo;
    private String name;
// crearea constructorului privat
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
