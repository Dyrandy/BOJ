#include <iostream>
#include <algorithm>
#include <cmath>
#include <map>
#include <vector>
#include <queue>
#include <functional>
#include <memory.h>
        using namespace std;
        #define INF 1000000001
        typedef long long ll;

        ll arr[1001];
        long long fibo(int a){
        if (arr[a] != 0) return arr[a];
        if(a == 1 || a == 2){
        return 1;
        }
        else return arr[a] = fibo(a - 1) + fibo(a - 2);
        }
        int main(){
        int n;
        scanf("%d", &n);
        printf("%lld\n", fibo(n));
        return 0;
        }
