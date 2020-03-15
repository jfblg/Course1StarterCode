package playground;

public class MemoryModel {
    public static void main(String[] args) {

        Location l1 = new Location(10, 20);
        Location l2 = new Location(30, 40);

        l1 = l2;
        l2.latitude = 200;

        System.out.println(l1);
        System.out.println(l2);

    }
}
