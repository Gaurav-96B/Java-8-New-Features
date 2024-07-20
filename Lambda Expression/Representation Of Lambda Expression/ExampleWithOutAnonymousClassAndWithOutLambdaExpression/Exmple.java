@FunctionalInterface
interface Cab {
    public void bookCab();
}

class Uber implements Cab {
    public void bookCab() {
        System.out.println("Booked Uber");
    }
}

public class Exmaple {
    public static void main(String[] args) {
        Cab cab = new Uber();
        cab.bookCab();
    }
}
