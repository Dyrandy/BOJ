//package com.company;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] arr = new int[n];
//        int[] out = new int[n];
//        boolean[] visited = new boolean[n];
//        for (int i = 1; i <= n; i++) {
//            arr[i - 1] = i;
//        }
//
//        Perm(arr, out, visited, 0, n);
//
//        scan.close();
//    }
//
//    static void Perm(int[] arr, int[] out, boolean[] visited, int depth, int n) {
//        if (depth == n) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(out[j] + " ");
//                System.out.println();
//                return;
//            }
//
//            for (int i = 0; i < n; i++) {
//                if (!visited[i]) {
//                    visited[i] = true;
//                    out[depth] = arr[i];
//                    Perm(arr, out, visited, depth + 1, n);
//                    visited[i] = false;
//                }
//            }
//
//        }
//    }
//}

package com.company;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] p = new int[N];

        for(int i = 0; i < N; i++){
            p[i] = scan.nextInt();
        }

        int first = 0;
        int second = 0;
        int diff = 0;
        int temp;
        int save_p1;
        int save_p2;

        for(int i = 0; i < N; i++){
            if(p[i] == 1 && first == 0) {
                first = i;
            }
            else if(first != 0 && p[i] == 1){
                second = i;
                temp = second - first;
                if(temp > diff) {
                    diff = temp;
                    save_p1 = first;
                    save_p2 = second;
                }
                first = second;
                second = 0;
            }
        }
        //System.out.println(diff);
        System.out.print(diff / 2);
        scan.close();
    }
}
