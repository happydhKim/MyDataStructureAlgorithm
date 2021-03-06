Longest Increasing Subsequence
증가 수열(Increasing Sequence)란 수열 A의 임의의 원소 A[i], A[j](i < j)에 대해 A[i] < A[j]가 성립하는 수열입니다.
최장 증가 부분 수열(Longest Increasing Subsequence)이란 수열 A의 부분 수열 중 증가 수열이 되는 가장 긴 수열을 의미합니다.
예를 들어 아래와 같은 수열 A가 있을 때 LIS(A)를 구하면 다음과 같습니다.

A = {20, 1, 7, 4, 5, 6, 13, 3}
LIS(A) = {1, 4, 5, 6, 13}

우리의 목표는 이러한 LIS의 길이를 구하는 것입니다. 위 수열 A에서 LIS(A)의 길이는 5가 됩니다.

이 문제를 해결하기 위해, 다음과 D[i]를 'i번째 원소를 마지막으로 갖는 최장 증가 수열의 길이'라고 정의해봅시다.
그렇다면 임의 값 i에 대해 D[i]는 어떻게 구할 수 있을까요? 먼저 i번째 원소 A[i]가 수열의 마지막에 위치해야 한다는 특성을 생각해봅시다.
이는 A[i]이전의 원소들로 이루어진 수열에 A[i]를 마지막으로 추가한다는 의미가 됩니다. 또한 A[i]가 마지막 원소이면서, 증가 수열이기 위해서는 어떻게 해야 할까요?
A[i] 이전의 원소가 A[i]보다 작은 값을 가져야 합니다.

위 두 가지 특성을 정리해보면, D[i]의 값은 i보다 작은 j에 대해 A[j] < A[i]를 만족하는 D[j] 중 최댓값 + 1이 됩니다. 이를 점화식을 정리해보면 다음과 같습니다.

D[i] = Minj = 0 to i-1, A[j] < A[i](D[j]) + 1

위 식에 따라 예제 수열 A의 D테이블을 채워보겠습니다. 먼저 초기 상태는 아래와 같습니다.

idx	0	1	2	3	4	5	6	7
A[i]	20	1	7	4	5	6	13	3
D[j]	0	0	0	0	0	0	0	0
각 인덱스 i에 대해 우리는 A[j](0 ≤ j < i)가 마지막에 위치하며 길이가 D[j]인 증가 수열에 A[i]를 추가할 수 있는지 확인해야 합니다.
위에서 다뤘듯 '추가할 수 있다'의 기준은 A[i]가 A[j]보다 큰 것을 의미합니다.
0 ~ i-1까지 이를 만족하는 j중 가장 큰 D[j]를 D[i]에 저장합니다.
만약 해당하는 j가 없다면 D[i]는 0이 됩니다. 이후 D[i]에 1을 더합니다.
이 과정은 A[i]를 마지막 원소로 추가하여 길이가 1 증가하는 것을 의미합니다.
이를 통해 위 테이블을 갱신해나가면 결과는 아래와 같습니다.

idx	0	1	2	3	4	5	6	7
A[i]	20	1	7	4	5	6	13	3
D[j]	1	1	2	2	3	4	5	2
위 테이블에서도 확인할 수 있듯, D[i]의 결과는 뒤로 갈수록 커지는 형태가 아닙니다.
A[i]의 값에 따라 D[i - 1]보다 D[i]가 작을 수도 있습니다.
따라서 최장 증가 부분 수열의 길이를 구하기 위해서는 D[i]의 값 중 가장 큰 값을 찾아야 합니다.

아래는 주어진 수열의 LIS의 길이를 구하는 코드입니다.

입력
첫 줄에 원소의 개수 N이 주어집니다. (1 ≤ N ≤ 1,000)
둘째 줄에 각 원소의 값을 나타내는 정수 N개가 주어집니다.
출력
주어진 수열의 LIS 길이를 출력합니다.
Sample Input
8
20  1  7  4  5  6  13  3
Sample Output
5


#include <iostream>
using namespace std;

int a[1000], d[1000];

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < i; j++) {
            if(a[j] < a[i]) {
                if(d[i] < d[j]) {
                    d[i] = d[j];
                }
            }
        }
        d[i]++;
    }
    int ans = 0;
    for(int i = 0; i < n; i++) {
        if(ans < d[i]) {
            ans = d[i];
        }
    }
    cout << ans << "\n";
    return 0;
}
