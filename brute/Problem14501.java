package com.company;

import java.util.*;
public class Main {

    static int Big = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];

        for(int i = 0; i < N; i++){
            T[i] = scan.nextInt();
            P[i] = scan.nextInt();
        }


        Work(T, P, N, 0, 0);
        System.out.println(Big);
        scan.close();
    }

    static void Work(int[] T, int[] P, int N, int day, int money){
        if(day == N){
            if(Big < money) {
                Big = money;
            }
            return;
        }
        for(int i = day; i < N; i++){
            if(i + T[i] <= N){
//                System.out.print(money + " ");
                Work(T, P, N, i + T[i], money + P[i]);
            }
            if(i == N - 1){
                if(Big < money) {
                    Big = money;
                }
                return;
            }
        }
    }
}

//day + T[i]가 아니라 i + T[i]지만 N이랑 비교하면 안됨