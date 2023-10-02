package creational.factory;

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
