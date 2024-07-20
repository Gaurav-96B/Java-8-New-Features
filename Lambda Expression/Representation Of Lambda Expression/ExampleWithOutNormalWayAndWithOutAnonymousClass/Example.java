@FunctionalInterface
interface Cab {
    public void bookCab();
}

public class Exmaple {
    public static void main(String[] args) {
        Cab cab = () - > System.out.println("Booked Uber");
        cab.bookCab();
    }
}
