Dynamic Programming(동적 계획법)
1. 동적계획법이란
동적 계획법이란, 복잡한 문제를 여러 개의 작은 문제로 나누어 해결하는 문제 해결 기법입니다.
가장 큰 특징은 이미 계산된 부분 문제가 다시 발생하면, 이전 계산값을 참조하여 이용하는 것입니다.
이전 계산값을 저장해둘 공간이 필요해 시간을 줄이는 대신, 메모리를 사용합니다.


동적 계획법이란, 복잡한 문제를 여러 개의 작은 부분 문제(sub-problem)로 나누어 해결하는 문제 해결 기법입니다.
동적 계획법의 특징 중 하나는 이미 계산된 부분 문제가 다시 발생하면 새롭게 계산하지 않고 이전의 계산값을 참조하여 이용하는 것입니다.
이 방법은 부분 문제를 다시 해결하는 데 필요한 시간을 절약할 수 있지만, 이전 계산값을 저장해둘 공간이 필요하므로 시간과 메모리의 trade-off라고 할 수 있습니다.

동적 계획법이 사용되는 대표적인 예제로 분할정복에서 잠깐 살펴본 피보나치 함수의 계산이 있습니다. 피보나치 함수란 다음과 같이 정의됩니다.

fib(N) = fib(N - 1) + fib(N - 2) (fib(0) = 1, fib(1) = 1)

fib(7)을 단순 탐색으로 구현하려고 한다면 아래와 같은 sub-problem으로 나누어집니다.

2. Top-Down와 Bottom-Up

동적 계획법의 구현은 크게 Top-Down방식과 Bottom-Up방식으로 나뉘어집니다.
Top-Down방식은 큰 문제에서 작은 부분문제를 재귀적으로 호출하여 리턴 되는 값을 이용하여 큰 문제를 해결하는 방식입니다.
중복되는 부분문제를 피하기 위해 앞서 소개한 Memoization기법을 함께 사용하며, 위에서 다룬 피보나치 함수의 구현방법 또한 이에 속합니다.

반대로 Bottom-Up방식은 작은 부분문제들을 미리 계산해두고, 이 부분문제들을 모아 큰 문제를 해결하는 방식입니다. 일반적으로 배열에 값을 채워나가는 형태로 구현합니다.
두 가지 방법은 각각의 장단점이 있습니다. Top-Down방식의 경우, 재귀함수를 통해 구현되므로 함수 호출에 대한 오버헤드가 발생합니다.
반면 Bottom-Up방식의 경우 반복문을 통해 구현되므로 이러한 자원에 비교적 자유로워 시간 및 메모리의 최적화가 쉽습니다.

하지만 Bottom-Up방식의 경우 큰 문제를 해결하기까지 어떠한 sub-problem이 요구되는지 알 수 없으므로 전체 문제를 계산하기 위해 모든 부분문제를 해결해야 합니다.
하지만 Top-Down방식의 경우 큰 문제를 해결하기 위해 필요한 sub-problem만을 호출하므로 필요한 부분만 계산하게 되어 특정한 경우에는 Bottom-Up방식보다 빠르게 동작할 수 있습니다.

3. Coin Change Problem

동적계획법의 또 다른 대표적인 예로 Coin Change Problem(동전 교환 문제)이 있습니다.
동전 교환 문제란 동전의 종류 N과 각 동전의 금액이 주어졌을 때 특정 금액 K를 만들기 위한 동전의 최소 개수를 구하는 문제입니다.
이때 각 동전의 개수는 무한히 많다고 가정합시다.

1, 5, 12원짜리 동전이 있고, 15원을 만들어야 하는 경우를 생각해봅시다.
이를 해결할 때 가장 먼저 떠오르는 것은 가장 큰 금액의 동전부터 먼저 사용하는 Greedy한 방법입니다.
동전을 적게 쓰기 위해서는 큰 동전을 쓰는 것이 유리하다는 생각으로 먼저 12원짜리 동전을, 이후 남은 3원을 1원짜리 동전 세 개로 채워 12 + 1 + 1 + 1의 총 4개의 동전으로 15원을 만듭니다.
하지만 이 경우는 최적값이 아닙니다. 5 + 5 + 5 총 3개의 동전으로 15원을 만드는 방법이 있기 때문입니다.

이를 해결하기 위해서는 어떻게 해야 할까요? 사용한 Greedy 방법을 계속 확장해봅시다.
다음 차례로는 12원짜리 동전을 하나 제외하고, 다음으로 큰 5원짜리 동전을 최대한 많이 사용하게 될 것입니다. 5 + 5 + 5라는 최적값을 찾게 됩니다.
하지만 만약 이보다 동전을 적게 사용하는 해가 있다면 어떻게 될까요? 또한 이 값이 최적값이라는 것을 어떻게 확신할 수 있을까요? 모릅니다.
결국 Greedy 방법은 모든 경우를 다 찾게 될 것입니다.
동전이 100개만 되더라도 그 경우의 수는 계산이 힘들 만큼 많아집니다.

이때 사용하게 되는 것이 동적계획법입니다.
C[N] = {1, 5, 12}, D[i]: ‘i원을 만들기 위해 필요한 동전의 최소개수’라고 정의합시다.
우리는 D[K]에 대해 아래와 같은 점화식을 세울 수 있습니다.

D[K] = Mini=0 to N-1, K > C[i](D[K - C[i]]) + 1

위 식은 K원을 만들기 위해서는 K보다 작은 금액에 새로운 동전이 더해지는 원리입니다.
더해지는 새로운 동전의 금액이 C[i]라면 D[K](K원을 만들기 위해 필요한 동전의 최소개수)의 후보값은 N개의
금액에 대해서 D[K - C[i]]((K - C[i])원을 만들기 위해 필요한 동전의 최소개수)에 C[i]원 동전 하나를 추가하는 방법들이 될 것입니다.
이는 결국 D[K]라는 큰 문제를 D[K - C[i]]라는 sub-problem으로 나누어 풀게 되는 동적 계획법이 됩니다.

input
첫 줄에 동전의 개수 N과 만들어야 하는 금액 K가 주어집니다. (1 ≤ N ≤ 100, 1 ≤ K ≤ 10,000)
둘째 줄에 N개의 동전의 금액이 주어집니다. 모든 동전의 금액은 10,000보다 작거나 같은 양의 정수입니다.
3  15
1  5  12

output
K원을 만들기 위해 필요한 동전의 최소개수를 출력합니다.
만약 K원을 만드는게 불가능하다면 -1을 출력합니다.
3

#include <iostream>
using namespace std;

int coin[100], d[10001];

int main() {
    int n, k;
    cin >> n >> k;

    for(int i = 0; i < n; i++) {
        cin >> coin[i];
    }

    for(int i = 1; i <= k; i++) {
        d[i] = -1;
        for(int j = 0; j < n; j++) {
            if(coin[j] <= i) {
                if(d[i - coin[j]] < 0) continue;
                if(d[i] < 0) d[i] = d[i - coin[j]] + 1;
                else if(d[i - coin[j]] + 1 < d[i]) d[i] = d[i - coin[j]] + 1;
            }
        }
    }

    cout << d[k] << "\n";
    return 0;
}
