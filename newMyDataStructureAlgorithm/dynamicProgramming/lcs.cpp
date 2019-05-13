DP2 - Longest Common Subsequence
수열(sequence)의 부분 수열(subsequence)이란 기존 수열의 일부 항을 원래 순서대로 나열해 얻을 수 있는 모든 수열을 의미합니다.
최장 공통 부분수열(Longest Common Subsequence, LCS)이란 주어진 수열 모두의 부분 수열이 되는 수열 중 가장 긴 수열을 찾는 문제입니다. 예를 들어 아래와 같은 두 수열 A, B를 생각해 봅시다.

A = {1, 2, 3, 4, 5, 6}
B = {1, 3, 5, 4, 2, 6}

위 두 수열의 최장 공통 부분수열은 LCS(A, B)는 {1, 3, 4, 6} 또는 {1, 3, 5, 6}이며 그 길이는 4 입니다.

또한 LCS는 수열뿐만 아니라 순서를 가지는 모든 구조에 대해 적용할 수 있습니다. LCS를 문자열에 대해 적용해봅시다.
"abaabcd"라는 문자열 A와 "baadca"라는 문자열 B가 있을 때, 두 문자열의 최장 공통 부분 수열 LCS(A, B)는 "baad" 또는 "baac"이며, 그 길이는 4가 됩니다.

A문자열의 길이를 LA, B문자열의 길이를 LB라고 할 때, 위와 같이 lcs[LA][LB] 테이블을 생각해봅시다.
이때 lcs[i][j]가 의미하는 것은 A문자열의 0~i번 인덱스까지의 부분 문자열(substring) A[0, i]와 B문자열의 0~j번 인덱스까지의 부분 문자열 B[0, j]의 LCS의 길이입니다.
즉 lcs 테이블은 아래와 같이 정의됩니다.

lcs[i][j] = LCS(A[0, i], B[0, j])의 길이

이제 lcs[i][j]를 살펴봅시다. 이 값은 다음과 같은 세 가지 상태로 나누어집니다.

1. lcs[i-1][j]에 A[i]가 새롭게 붙여진 경우
이미 구해진 lcs[i-1][j]에서 A[i]라는 글자가 하나 추가되어도 lcs[i][j]의 값은 증가할 수 없습니다.
B[j]까지는 이미 lcs[i-1][j]에서 사용되었을 수 있으므로 A[i]와 공통으로 사용될 B의 문자가 존재하지 않기 때문입니다.
따라서 이때 lcs[i][j]는 lcs[i-1][j]와 같은 값을 가질 수 있습니다.

2. lcs[i][j-1]에 B[j]가 새롭게 붙여진 경우
마찬가지로 lcs[i][j-1]에서 B[j]라는 글자가 하나 추가되어도 lcs[i][j]의 값은 증가할 수 없습니다.
A[i]까지는 이미 lcs[i][j-1]에서 사용되었을 수 있으므로 B[j]와 공통으로 사용될 A의 문자가 존재하지 않기 때문입니다.
따라서 이때 lcs[i][j]는 lcs[i][j-1]과 같은 값을 가질 수 있습니다.

3. lcs[i-1][j-1]에 A[i], B[j]가 새롭게 붙여진 경우
반면 lcs[i-1][j-1]에 A[i], B[j]라는 글자가 동시에 추가될 때를 생각해 봅시다.
만약 A[i]와 B[j]가 같은 글자라면 우리는 lcs[i][j]가 lcs[i-1][j-1]까지의 값에서 1 증가한다는 것을 알 수 있습니다.
LCS(A[0, i-1], B[0, j-1]) 수열의 마지막에 A[i](B[j])가 추가되기 때문입니다.

이 세 가지 상태를 일반화하여 lcs의 점화식을 정리해보면 다음과 같습니다.
lcs[i][j] = lcs[i-1][j-1]+1 (if A[i] == B[j])
lcs[i][j] = max(lcs[i-1][j], lcs[i]][j-1])

단 위 점화식의 경우 i가 0이거나 j가 0인 경우를 따로 처리해야만 합니다. 해당 점화식은 다음과 같습니다.
if(i == 0 && j == 0) lcs[i][j] = 1 (if A[i] == B[j])
else if(i == 0) lcs[i][j] = max(lcs[i][j-1], A[i] == B[j])
else if(j == 0) lcs[i][j] = max(lcs[i-1][j], A[i] == B[j])

이렇게 점화식의 경우가 다양해지는 불상사를 막기 위해, 문자열의 인덱스를 0이 아닌 1부터 시작하는 방법을 사용해볼 수 있습니다.
A의 인덱스가 [0, LA-1]이 아닌 [1, LA], B의 인덱스가 [0, LB-1]이 아닌 [1, LB]로 변경되면 점화식은 아래와 같이 한 번에 정리될 수 있습니다.
lcs[i][j] = 0 (if i==0 or j==0)
lcs[i][j] = lcs[i-1][j-1]+1 (if A[i] == B[j])
lcs[i][j] = max(lcs[i-1][j], lcs[i]][j-1])

입력
첫 줄에 문자열 A의 길이 LA와 문자열 B의 길이 LB가 주어집니다. (1 ≤ LA, LB ≤ 1,000)
둘째 줄에 문자열 A, 셋째 줄에 문자열 B가 주어집니다.

출력
두 문자열의 LCS의 길이를 출력합니다.
Sample Input
7  6
abaabcd
baadca

Sample Output
4

#include <iostream>
#include <string>
using namespace std;

int lcs[1001][1001];
string a, b;

int main() {
    int la, lb;
    cin >> la >> lb;
    cin >> a >> b;
    for(int i = 1; i <= la; i++) {
        for(int j = 1; j <= lb; j++) {
            if(a[i - 1] == b[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1;
            } else {
                if(lcs[i - 1][j] < lcs[i][j - 1]) {
                    lcs[i][j] = lcs[i][j - 1];
                } else {
                    lcs[i][j] = lcs[i - 1][j];
                }
            }
        }
    }
    cout << lcs[la][lb] << "\n";
    return 0;
}
