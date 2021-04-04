package mass;

import java.util.Scanner;

class Truck {

    Scanner k = new Scanner(System.in);

    public void powerOfN() {
        int truckLoadCapacity;
        int packCounts;

        System.out.println("Enter The Truck Capacity");
        truckLoadCapacity = k.nextInt();
        System.out.println("Enter The Pack Counts");
        packCounts = k.nextInt();

        int[] packs = new int[packCounts];

        for (int i = 0; i < packs.length; i++) {
            int r = (int) (Math.random() * 6);
            packs[i] = (int) Math.pow(2.0, Double.parseDouble(String.valueOf(r)));
            System.out.print(packs[i] + " ");
        }
        System.out.println("");

        int biggest = packs[0];
        int number = 0;
        int total = 0;
        int count = 0;
        int steps = 0;
        boolean noWay = true;

        while (total != truckLoadCapacity) {
            for (int i = 0; i < packs.length; i++) {
                if (biggest < packs[i] && packs[i] <= truckLoadCapacity) {
                    biggest = packs[i];
                    number = i;
                }
            }
            packs[number] = 0;

            if ((total + biggest) <= truckLoadCapacity) {
                total = total + biggest;
                System.out.print("Biggest: " + biggest + " ");
                System.out.println("Element: " + number);
                steps++;
            }

            number = 0;
            count++;
            biggest = packs[0];

            if (count == packs.length && total != truckLoadCapacity) {
                System.out.println("No solutions. Max total is: " + total);
                noWay = false;
                break;
            }

        }

        if (noWay) {
            System.out.println(steps + " steps.");
            System.out.println("Total is: " + total);
        }
    }

    public void normalNumbers() {
        int truckLoadCapacity;
        int packCounts;

        System.out.println("Enter The Truck Capacity");
        truckLoadCapacity = k.nextInt();
        System.out.println("Enter The Pack Counts");
        packCounts = k.nextInt();

        int[] packs = new int[packCounts];

        for (int i = 0; i < packs.length; i++) {
            packs[i] = (int) (Math.random() * 15);
            System.out.print(packs[i] + " ");
        }
        System.out.println("");

        int biggest = packs[0];
        int number = 0;
        int total = 0;
        int count = 0;
        int steps = 0;
        boolean noWay = true;

        while (total != truckLoadCapacity) {
            for (int i = 0; i < packs.length; i++) {
                if (biggest < packs[i] && packs[i] <= truckLoadCapacity) {
                    biggest = packs[i];
                    number = i;
                }
            }
            packs[number] = 0;

            if ((total + biggest) <= truckLoadCapacity) {
                total = total + biggest;
                System.out.print("Biggest: " + biggest + " ");
                System.out.println("Element: " + number);
                steps++;
            }

            number = 0;
            count++;
            biggest = packs[0];

            if (count == packs.length && total != truckLoadCapacity) {
                System.out.println("No solutions. Max total is: " + total);
                noWay = false;
                break;
            }

        }

        if (noWay) {
            System.out.println(steps + " steps.");
            System.out.println("Total is: " + total);
        }
    }
}

public class Mass {

    public static void main(String[] args) {
        Truck t = new Truck();
        t.powerOfN();
        System.out.println("**********");
        t.normalNumbers();
    }

}
