package Trainingstuff;

import java.util.Scanner;
import java.util.Arrays;

public class Ascendingnumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total, b = 0, mid = 0;
        System.out.print("How many numbers will you put:");
        total = input.nextInt();
        int[] array1 = new int[total];
        int[] array2 = new int[1];
        for (int count = 1; count <= array1.length; count++, b++) {
            System.out.print("enter the numbers:");
            array1[b] = input.nextInt();
        }

        for (int count = 1; count <= array1.length; count++) {
            for (int c = count; c <= total - 1; c++) {
                if (array1[count - 1] <= array1[c]) {

                } else {
                    mid = array1[c];
                    array1[c] = array1[count - 1];
                    array1[count - 1] = mid;
                }


                System.out.print(Arrays.toString(array1));


            }

        }
        System.out.println("hello\n");


    }
}
