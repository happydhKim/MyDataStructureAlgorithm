DP4 - Edit Distance
편집 거리(Edit Distance)는 문자열 A에서 문자열 B로 변경하는데 필요한 최소 연산 횟수를 구하는 문자열 유사도 판단 알고리즘입니다.
문자열 A에 대해 가능한 연산으로는 원하는 문자의 삽입, 삭제, 수정 등이 있습니다.

두 문자열 A: "kitten", B: "sitting"를 예로 들어봅시다.
우리는 A에 한 글자씩 삽입/삭제/수정하는 연산을 통해 B로 만들어야 합니다.
편의를 위해 문자열의 인덱스가 1부터 시작하도록 설정한 뒤, D[i][j]: A[1, i]까지 사용하여 B[1, j]까지 만들 때 필요한 최소 편집거리라고 정의한 다음과 같은 테이블을 생각해봅시다.

이 문제를 해결하기 위해서는 두 문자열에 대해서 한 문자씩 비교해 나가며, 각 위치별로 삽입/삭제/수정 연산의 경우를 다 따져봐야 합니다.
LCS와 유사하게 D[i][j]는 다음과 같은 세 가지 상태로 나누어집니다.

1. D[i - 1][j]에서 A[i]를 변형할 때 A[1, i - 1]은 B[1, j]와 동일하게 변형되어 있습니다. 따라서 A[i]는 삭제되어야 합니다.
2. D[i][j - 1]에서 B[j]를 변형할 때 A[1, i]는 B[1, j - 1]과 동일하게 변형되어 있습니다. 여기에 B가 한 글자 증가하게 되면, A의 뒤에 B[j]를 삽입해야 합니다.
3. D[i - 1][j - 1]에서 A[i]와 B[j]를 변형할 때 A[i]와 B[j]의 값이 같다면 A를 추가적으로 변형할 필요가 없습니다. 대신 A[i]와 B[j]가 다르다면 A[i]를 B[j]로 수정하는 연산이 필요합니다.


아래는 두 문자열이 주어졌을 때 A를 B로 바꾸기 위한 최소 편집거리를 동적계획법으로 구현한 코드입니다.

입력	
첫 줄에 문자열 A의 길이 LA와 문자열 B의 길이 LB가 주어집니다. (1 ≤ LA, LB ≤ 1,000)
둘째 줄에 문자열 A, 셋째 줄에 문자열 B가 주어집니다.

출력
A를 B로 바꾸기 위한 최소 편집거리를 출력합니다.

Sample Input
6  7
kitten
sitting

Sample Output
3

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int la = sc.nextInt();
        int lb = sc.nextInt();

        String a = sc.next();
        String b = sc.next();

        int d[][] = new int[la + 1][lb + 1];
        for (int i = 1; i <= la; i++) {
            d[i][0] = i;
        }
        for (int j = 1; j <= lb; j++) {
            d[0][j] = j;
        }
        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                }
                else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
                }
            }
        }
        System.out.println(d[la][lb]);
    }
}
