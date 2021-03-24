package howmanytimes;

import java.util.Arrays;
import java.util.Random;

class process {

    public void fillArray(int[] array) {
        Random r = new Random();

        System.out.print("Array: \t");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) r.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    int numberss;

    public int[] counting(int[] array) {

        Arrays.sort(array);

        System.out.print("Sorted Array: \t");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        int numbers = 1;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                numbers++;
            }
        }
        System.out.println("Number of different numbers: " + numbers);

        numberss = numbers;
        int[] array2 = new int[numbers];
        numbers = 0;
        int count = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] == array[i - 1]) {
                count++;
            } else {
                array2[numbers] = count;
                numbers++;
                count = 1;
            }
        }
        array2[array2.length - 1] = count;

        for (int i = 0; i < array2.length; i++) {
            System.out.print("array2[" + i + "]:" + array2[i] + " ");
        }
        System.out.println("");

        return array2;
    }

    public void find(int[] array, int[] array2) {
        int biggest = array2[0];
        int count = 0;
        boolean repeat = false;

        for (int i = 1; i < array2.length; i++) {
            if (biggest < array2[i]) {
                biggest = array2[i];
            }
        }

        for (int i = 0; i < array2.length; i++) {
            if (array2[i] == biggest) {
                count++;
            }
        }
        if (count > 1) {
            repeat = true;
        }
        System.out.println("The most repeating time: " + biggest);
        System.out.println("Biggest number repeats: " + repeat);

        if (!repeat) {
            int countAgain = 1;

            for (int i = 1; i < array.length; i++) {
                if (array[i] == array[i - 1]) {
                    countAgain++;
                } else if (countAgain == biggest) {
                    System.out.println(array[i - 1] + " " + biggest);
                    break;
                } else {
                    countAgain = 1;
                }
            }

        } else {
            int countAgain = 1;
            int bigger = 0;

            for (int i = 1; i < array.length; i++) {
                if (array[i] == array[i - 1]) {
                    countAgain++;
                } else if (countAgain == biggest && array[i - 1] > bigger) {
                    bigger = array[i - 1];
                    countAgain = 1;
                } else {
                    countAgain = 1;
                }
            }

            if (countAgain == biggest && array[array.length - 1] > bigger) {
                bigger = array[array.length - 1];
            }

            System.out.println("Biggest: " + bigger + " Count: " + biggest);
        }

    }

    // Second algorithm is starting here
    component[] numbers;

    public void secondFind(int[] array) {

        numbers = new component[numberss];

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        System.out.println("Number of different numbers:  " + numbers.length);

        int element = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new component();
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                if (!numbers[element].first) {
                    numbers[element].first = true;
                    numbers[element].number = array[i - 1];
                    element++;
                } else {
                    component tmp = numbers[element];
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new component();
                    tmp.next.number = array[i - 1];
                    element++;
                }
            } else {
                if (!numbers[element].first) {
                    numbers[element].first = true;
                    numbers[element].number = array[i - 1];
                } else {
                    component tmp = numbers[element];
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new component();
                    tmp.next.number = array[i - 1];
                }
            }
        }

        numbers[element].number = array[array.length - 1];
        System.out.print("Sorted Array: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i].number + " ");
        }
        System.out.println("");

        component ilk = numbers[0];

        int count = 0;
        int biggestCheck = 0;
        int biggest = numbers[0].number;
        for (int i = 0; i < numbers.length; i++) {
            ilk = numbers[i];
            count = 0;
            System.out.println("");
            while (ilk.next != null) {
                System.out.print(ilk.number);
                ilk = ilk.next;
                count++;
            }
            count++;
            System.out.print(ilk.number);
            if (biggestCheck <= count) {
                biggestCheck = count;
                biggest = numbers[i].number;
            }

        }
        if (ilk.next != null) {
            while (ilk.next != null) {
                System.out.print(ilk.number);
                ilk = ilk.next;
                count++;
            }
        } else {
            count++;
            System.out.print(ilk.number);
            System.out.println("");
        }

        if (biggestCheck <= count) {
            biggestCheck = count;
            biggest = numbers[numbers.length - 1].number;
        }

        System.out.println("Biggest: " + biggest + " Count: " + biggestCheck);
    }

}

class component {

    component next;
    int number;
    boolean first;

    public component() {
        next = null;
        number = 0;
        first = false;
    }
}

public class HowManyTimes {

    public static void main(String[] args) {
        long startTime = System.nanoTime();       //time start
        System.out.println("*****With First Algorithm*****");

        process p = new process();

        int[] array = new int[10];

        p.fillArray(array);
        int[] array2 = p.counting(array);
        p.find(array, array2);

        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;
        System.out.println("Time: " + (double) estimatedTime / 1000000000);

        long startTimeAgain = System.nanoTime();

        System.out.println("*****With Second Algorithm*****");
        p.secondFind(array);

        long endTimeAgain = System.nanoTime();
        long estimatedTimee = endTimeAgain - startTimeAgain;
        System.out.println("Time: " + (double) estimatedTimee / 100000000);
    }

}
