// 민기의 자전거 조립
// 코드 출처 : Kang

#include <stdio.h>
#define SWAP(a,b) {int temp = a;    a = b;  b = temp;}
#define HASH 8388617

int N;
int gear[2000];
int part_count[2000][2];
int lastpart;
typedef struct _hashmap{
    int t;
    long long count;
    long long value;
}hashmap;

hashmap map[HASH];

void qsrt(int m[2000], int start, int end);
void partsort();


int main() {
    int test_case;
    int T;

    scanf("%d", &T);

    for (test_case = 1; test_case <= T; test_case++)
    {
        unsigned long long totalcount = 0;

        scanf("%d", &N);
        for (int i = 0; i < N; i++) {
            scanf("%d ", &gear[i]);
        }
        qsrt(gear, 0, N-1);
        lastpart = 0;
        part_count[0][0] = gear[0];
        part_count[0][1] = 0;
        partsort();
        lastpart++;

        for (int i = 0; i < lastpart; i++) {
            //printf("i : %d(%d)\n", part_count[i][0], part_count[i][1]);
        }

        for (int a = 0; a < lastpart; a++) {
            if (part_count[a][1] >= 2) {
                if (part_count[a][1] >= 4) {
                    int acount_1 = (part_count[a][1]) * (part_count[a][1] - 1) / 2;
                    int acount_2 = (part_count[a][1] - 2) * (part_count[a][1] - 3) / 2;
                    if (acount_1 % 2 == 0) {
                        acount_1 = acount_1 / 2;
                    }
                    else {
                        acount_2 = acount_2 / 2;
                    }
                    if (acount_1 % 3 == 0) {
                        acount_1 = acount_1 / 3;
                    }
                    else {
                        acount_2 = acount_2 / 3;
                    }

                    long long acount = (long long)acount_1 * acount_2;
                    totalcount = totalcount + acount;
                }

                int acount = ((part_count[a][1]) * (part_count[a][1] - 1)) / 2;
                if (a < lastpart - 1) {
                    for (int b = a + 1; b < lastpart; b++){
                        if (part_count[a][1] >= 2) {
                            int bcount = ((part_count[b][1]) *  (part_count[b][1] - 1)) / 2;
                            totalcount = totalcount + (long long)(acount * bcount);
                        }
                    }
                }
                long long mPower = (long long)part_count[a][0] * part_count[a][0];
                for (int k = mPower % HASH;; k = (k + 1) % HASH){
                    if (map[k].t < test_case) {
                        map[k].t = test_case;
                        map[k].count = acount;
                        map[k].value = mPower;
                        break;
                    }
                }
            }
        }
        for (int a = 0; a < lastpart-1; a++) {
            for (int b = a + 1; b < lastpart; b++){
                int bcount = part_count[a][1] * part_count[b][1];
                long long mPower = (long long)part_count[a][0] * part_count[b][0];
                for (int k = mPower % HASH ;; k = (k + 1) % HASH){
                    if (map[k].t < test_case) {
                        map[k].t = test_case;
                        map[k].count = bcount;
                        map[k].value = mPower;
                        break;
                    }
                    else if (map[k].value == mPower) {
                        totalcount = totalcount + (bcount * map[k].count);
                        map[k].count = map[k].count + bcount;
                        break;
                    }
                }
            }
        }
        printf("#%d %lld\n", test_case, totalcount);
    }
    return 0;
}

void partsort()
{
    for (int i = 0; i < N; i++) {
        if (gear[i] == part_count[lastpart][0]) {
            part_count[lastpart][1] ++;
        }
        else {
            lastpart++;
            part_count[lastpart][0] = gear[i];
            part_count[lastpart][1] = 1;
        }
    }
}


void qsrt(int m[2000], int start, int end) {
    if (end <= start) {
        return;
    }
    if (end == start + 1) {
        if (m[start] > m[end]) {
            SWAP(m[start], m[end]);
        }
        return;
    }

    int mid = (start + end) / 2;
    if ((m[start] > m[mid] && m[end] < m[mid]) ||
        (m[start] < m[mid] && m[end] > m[mid])) {
        SWAP(m[start], m[mid]);
    }
    else if ((m[start] > m[end] && m[mid] < m[end]) ||
                (m[start] < m[end] && m[mid] > m[end])) {
        SWAP(m[start], m[end]);
    }

    int i = start +1;
    int j = end;
    while (i < j) {
        while (m[i] <= m[start]) {
            i++;
            if (i > end) {
                i--;
                break;
            }
        }
        while (m[j] > m[start]) {
            j--;
            if (j <= start) {
                break;
            }
        }
        if (i < j) {
            SWAP(m[i], m[j]);
        }
        else {
            break;
        }

    }
    SWAP(m[start], m[j]);

    qsrt(m, start, j - 1);
    qsrt(m, j+1, end);
}
