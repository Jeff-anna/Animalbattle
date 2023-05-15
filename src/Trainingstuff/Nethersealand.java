package Trainingstuff;

import java.util.Scanner;

public class Nethersealand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m, n, k, exam, i = 0, o = 0, p = 0,a=0;
        char element;
        Nethersealand ob = new Nethersealand();
      //  System.out.print("enter size and time:");
        m = input.nextInt();
        n = input.nextInt();
        k = input.nextInt();
        char[][] arr1 = new char[m][n];
        char[][] arr2=new char[m][n];
     //   System.out.print("draw the map:");
        for (int v; i <= m - 1; i++) {
            for (int x; o <= n - 1; o++) {
                arr1[i][o] = input.next().charAt(0);
                arr2[i][o]=arr1[i][o];
            }
            o = 0;
        }
        i = 0;
        for (int y = 1; y <= k; y++) {
            for (int g; i <= m - 1; i++) {
                for (int l; o <= n - 1; o++) {
                    element = arr1[i][o];
                    if (ob.ifbrand(element)) {
                        exam = ob.boarderexam(m, n, i, o);
                        switch (exam) {
                            case 0:
                                if (ob.ifextend(arr1[0][1])) {
                                    arr2[0][1] = 'B';
                                }
                                if (ob.ifextend(arr1[1][0])) {
                                    arr2[1][0] = 'B';
                                }
                                break;
                            case 1:
                                if (ob.ifextend(arr1[m - 1][n - 2])) {
                                    arr2[m - 1][n - 2] = 'B';
                                }
                                if (ob.ifextend(arr1[m - 2][n - 1])) {
                                    arr2[m - 2][n - 1] = 'B';
                                }
                                break;
                            case 2:
                                if (ob.ifextend(arr1[m - 1][1])) {
                                    arr2[m - 1][1] = 'B';
                                }
                                if (ob.ifextend(arr1[m - 2][0])) {
                                    arr2[m - 2][0] = 'B';
                                }
                                break;
                            case 3:
                                if (ob.ifextend(arr1[0][n - 2])) {
                                    arr2[0][n - 2] = 'B';
                                }
                                if (ob.ifextend(arr1[1][n - 1])) {
                                    arr2[1][n - 1] = 'B';
                                }
                                break;
                            case 4:
                                if (ob.ifextend(arr1[i - 1][o])) {
                                    arr2[i - 1][o] = 'B';
                                }
                                if (ob.ifextend(arr1[i + 1][o])) {
                                    arr2[i + 1][o] = 'B';
                                }
                                if (ob.ifextend(arr1[i][o + 1])) {
                                    arr2[i][o + 1] = 'B';
                                }
                                break;
                            case 5:
                                if (ob.ifextend(arr1[i - 1][o])) {
                                    arr2[i - 1][o] = 'B';
                                }
                                if (ob.ifextend(arr1[i + 1][o])) {
                                    arr2[i + 1][o] = 'B';
                                }
                                if (ob.ifextend(arr1[i][o - 1])) {
                                    arr2[i][o - 1] = 'B';
                                }
                                break;
                            case 6:
                                if (ob.ifextend(arr1[i][o - 1])) {
                                    arr2[i][o - 1] = 'B';
                                }
                                if (ob.ifextend(arr1[i][o + 1])) {
                                    arr2[i][o + 1] = 'B';
                                }
                                if (ob.ifextend(arr1[i - 1][o])) {
                                    arr2[i - 1][o] = 'B';
                                }
                                break;
                            case 7:
                                if (ob.ifextend(arr1[i][o + 1])) {
                                    arr2[i][o + 1] = 'B';
                                }
                                if (ob.ifextend(arr1[i][o - 1])) {
                                    arr2[i][o - 1] = 'B';
                                }
                                if (ob.ifextend(arr1[i + 1][o])) {
                                    arr2[i + 1][o] = 'B';
                                }
                                break;
                            case 8:
                                if (ob.ifextend(arr1[i - 1][o])) {
                                    arr2[i - 1][o] = 'B';
                                }
                                if (ob.ifextend(arr1[i + 1][o])) {
                                    arr2[i + 1][o] = 'B';
                                }
                                if (ob.ifextend(arr1[i][o + 1])) {
                                    arr2[i][o + 1] = 'B';
                                }
                                if (ob.ifextend(arr1[i][o - 1])) {
                                    arr2[i][o - 1] = 'B';
                                    break;
                                }
                        }
                    }
                }
                o = 0;
            }
            i = 0;
            for(int q=0;q<=m-1;q++){
                for(int c;a<=n-1;a++){
                    arr1[q][a]=arr2[q][a];
                }
                a=0;
            }
        }
        for (int v = 0; v <= m - 1; v++) {
            for (int l; p <= n - 1; p++) {
                element = arr1[v][p];
                System.out.print(element);
                System.out.print(" ");
            }
            p = 0;
            System.out.println();
        }
    }

    public boolean ifextend(char n) {
        if (n == 'W') {
            return false;
        } else
            return true;
    }

    public boolean ifbrand(char n) {
        if (n == 'B') {
            return true;
        } else
            return false;
    }

    public int boarderexam(int a, int b, int c, int d) {
        if (c == 0 && d == 0) {
            return 0;
        } else if (c == a - 1 && d == b - 1) {
            return 1;
        } else if (c == a - 1 && d == 0) {
            return 2;
        } else if (c == 0 && d == b - 1) {
            return 3;
        } else if ((c != 0) && (c != a - 1) && d == 0) {
            return 4;
        } else if ((c != 0) && (c != a - 1) && d == b - 1) {
            return 5;
        } else if (c == a - 1 && (d != 0) && (d != b - 1)) {
            return 6;
        } else if (c == 0 && d != 0 && d != b - 1) {
            return 7;
        } else
            return 8;
    }
}