@FunctionalInterface
interface Cab {
    public void bookCab();
}

public class Exmaple {
    public static void main(String []args) {
        Cab cab=new Cab() {
            public void bookCab() {
                System.out.println("Booked Uber");
            }
        };
        cab.bookCab();
    }
}
