package Trainingstuff;

import java.util.Scanner;

public class red2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, k, g = 1, h = 1, x, y, p = 50, q = 50, r = 0;
        red2 ed = new red2();
        n = in.nextInt();
        boolean[][] arr1 = new boolean[n + 100][n + 100];
        m = in.nextInt();
        k = in.nextInt();
        for (; g <= m; g++) {
            x = in.nextInt();
            y = in.nextInt();
            if(x>=0&&y>=0&&x<=n-1&&y<=n-1){
                if (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1) {
                    ed.swit1(arr1, x, y);
                    ed.swit1(arr1, x + 1, y);
                    ed.swit1(arr1, x, y + 1);
                    ed.swit1(arr1, x - 1, y);
                    ed.swit1(arr1, x, y - 1);
                    ed.swit1(arr1, x - 1, y - 1);
                    ed.swit1(arr1, x + 1, y + 1);
                    ed.swit1(arr1, x - 1, y + 1);
                    ed.swit1(arr1, x + 1, y - 1);
                }
            }


        }
        for (; h <= k; h++) {
            x = in.nextInt();
            y = in.nextInt();
            if(x>=0&&y>=0&&x<=n-1&&y<=n-1){
                if (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1) {
                    ed.swit1(arr1, x, y);
                    ed.swit1(arr1, x + 2, y);
                    ed.swit1(arr1, x, y + 2);
                    ed.swit1(arr1, x - 2, y);
                    ed.swit1(arr1, x, y - 2);
                    ed.swit1(arr1, x - 2, y - 2);
                    ed.swit1(arr1, x + 2, y + 2);
                    ed.swit1(arr1, x - 2, y + 2);
                    ed.swit1(arr1, x + 2, y - 2);
                    ed.swit1(arr1, x + 2, y - 1);
                    ed.swit1(arr1, x + 2, y + 1);
                    ed.swit1(arr1, x + 1, y - 2);
                    ed.swit1(arr1, x - 1, y - 2);
                    ed.swit1(arr1, x - 2, y - 1);
                    ed.swit1(arr1, x - 2, y + 1);
                    ed.swit1(arr1, x - 1, y + 2);
                    ed.swit1(arr1, x + 1, y + 2);
                }
            }



        }
        for (; p <= n + 49; p++) {
            for (; q <= n + 49; q++) {
                if (!arr1[p][q]) {
                    r++;
                }
            }
            q = 50;
        }
        System.out.print(r);
    }


    public void swit1(boolean[][] arr, int a, int b) {
        arr[a + 50][b + 50] = true;
    }
}
