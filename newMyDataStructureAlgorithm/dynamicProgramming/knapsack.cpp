DP1 - Knapsack
다이나믹 프로그랭밍이 사용되는 대표적인 예제에 Knapsack(배낭) 문제가 있습니다. 배낭 문제란, 무게 제한이 K인 배낭과 무게와 가치가 정해진 N개의 물건이 있을 때 가치의 총합이 가장 크도록 배낭을 싸는 문제입니다.
이때 각 물건은 하나씩만 존재하며 나누어 넣을 수 없습니다. 따라서 각 물건은 배낭에 넣거나, 넣지 않거나 둘 중 하나의 경우를 가집니다. 배낭에 넣은 물건 무게의 총합은 배낭의 무게 제한을 넘어서는 안 됩니다.

무게 제한이 7kg인 배낭과 아래와 같이 4개의 물건이 있을 때를 생각해봅시다. 각 물건에서 Vi는 그 물건의 가치를, Wi는 물건의 무게를 나타냅니다.

i	V	W
1	13	6
2	8	4
3	6	3
4	12	5
이때 가치의 총합이 가장 크도록 가방을 싸려면, 어떤 물건들을 넣어야 할까요?
동전 교환 문제와 마찬가지로 일반적으로 떠오르는 방법은 무게당 가치가 가장 높은 물건을 먼저 넣는 Greedy한 방법입니다. 무게당 가치를 계산해, 그 값이 높은 순으로 정렬한다면 위 표는 아래와 같아집니다.

i	V	W	Vi / Wi
4	12	5	2.40
1	13	6	2.17
2	8	4	2.00
3	6	3	2.00
가장 먼저 무게당 가치가 가장 높은 4번 물건을 가방에 넣습니다. 가방은 5kg이 차고 이때 가치의 합은 12입니다. 남은 무게 2kg에 대해 더 넣을 수 있는 물건이 없으므로 12가 최적값의 후보가 됩니다.
하지만 이는 최적값이 아닙니다. 이 문제의 최적값은 2번 물건과 3번 물건을 넣어 7kg으로 가방을 채운 가치의 합 14입니다.

역시 최적값을 찾기 위해 Greedy 방법을 계속 확장해봅시다. 다음 차례로는 4번 아이템을 빼고 그다음으로 무게당 가치가 높은 1번 물건을 가방에 넣습니다.
이때 가방은 6kg이 차고 가치의 합은 13이 됩니다. 남은 무게 1kg에 대해 더 넣을 수 있는 물건이 없으므로 13이 최적값의 후보가 됩니다. 다음으로 역시 1번 물건을 빼고 2번 물건을 넣습니다.
이때 가방은 4kg에 8의 가치합을 갖습니다. 남은 무게 3kg에 대해 3번 아이템을 추가로 넣을 수 있으므로 우리는 7kg에 14라는 최적값에 도달하게 됩니다.

하지만 이 값이 최적값이라는 것을 확신할 수 있을까요? 이보다 물건이 훨씬 다양해지고 가방의 중량 제한이 커진다면 어떻게 될까요? 우리는 이러한 Greedy한 방법으로는 구한 값이 최적인지 확신할 수 없습니다.
따라서 결국 모든 경우의 수를 다 보게 될 것입니다. 앞서 다룬 동전 문제와 같은 문제점에 도달하게 됩니다.

역시 해결 방법은 동적계획법입니다. V[N] = {13, 8, 6, 12}, W[N] = {6, 4, 3, 5}, D[i][j]: 'i번째 물건까지 넣는다/안 넣는다를 정했을 때, 무게 j이하를 채우는 가치의 합 중 최대값'이라고 정의합시다. 우리는 D[i][j]에 대해 아래와 같은 점화식을 세울 수 있습니다.


D[i][j] = Max(D[i-1][j], D[i-1][j - W[i]] + V[i])

위 D[i][j]를 채우는 두 가지 경우를 점화식으로 나타낸 것으로, D[i-1][j]는 i번째 물건을 넣지 않는 상태를, D[i-1][j-W[i]] + V[i]는 i번째 물건을 넣는 상태를 의미합니다.
이는 결국 D[N][K]라는 큰 문제를 위와 같은 형태의 sub-problem으로 나누어 풀게 되는 동적 계획법이 됩니다.

아래는 배낭 문제를 동적 계획법으로 푼 코드입니다.

입력	출력
첫 줄에 물건의 개수 N과 배낭의 무게 제한 K가 주어집니다. (1 ≤ N ≤ 100, 1 ≤ K ≤ 10,000)
둘째 줄부터 N개의 줄에 걸쳐 각 물건의 가치 Vi와 무게 Wi가 주어집니다. (1 ≤ Vi, Wi ≤ 10,000)	무게 제한 K안에서 담을 수 있는 물건 가치 총합의 최대값을 출력합니다.
Sample Input
4  7
13  6
8  4
6  3
12  5

Sample Output
14

#include <iostream>
using namespace std;

int d[101][10001], v[101], w[101];

int main() {
    int n, k;
    cin >> n >> k;

    for(int i = 1; i <= n; i++) {
        cin >> v[i] >> w[i];
    }

    for(int i = 1; i <= n; i++) {
        for(int j = 0; j <= k; j++) {
            if(j < w[i]) {
                d[i][j] = d[i - 1][j];
            } else if(d[i - 1][j - w[i]] + v[i] > d[i - 1][j]) {
                d[i][j] = d[i - 1][j - w[i]]  + v[i];
            } else {
                d[i][j] = d[i - 1][j];
            }
        }
    }

    int ans = 0;
    for(int i = 0; i <= k; i++){
        if(ans < d[n][i]){
            ans = d[n][i];
        }
    }
    cout << ans << "\n";
    return 0;
}