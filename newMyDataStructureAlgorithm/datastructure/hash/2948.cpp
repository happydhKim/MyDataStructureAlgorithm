#include <cstring>
#include <iostream>
#include <string>
#include <vector>
#define MAX 100002
using namespace std;

vector<string> table[MAX]; // 해시의 체이닝 역할

int Hash(string str) {
    int sum = 0;
    int mul = 1;
    int p = 31;
    int m = MAX - 1;
    for (int i = 0; i < str.length(); i++) {
        sum += ((str[i] - 'a' + 1) * mul) % m;
        mul = (mul * p) % m;
    }
    return sum % m;
}

int check(string a, string b) {
    if (a.length() != b.length()) return 0;
    for (int i = 0; i < a.length(); i++) {
        if (a[i] != b[i]) return 0;
    }
    return 1;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    int T;
    int a, b;
    int cnt;
    string str;
    cin >> T;
    for (int ab = 1; ab <= T; ab++) {
        cin >> a >> b;
        for (int i = 0; i < a; i++) {
            cin >> str;
            table[Hash(str)].push_back(str);
        }
        for (int i = 0; i < b; i++) {
            cin >> str;
            int n = Hash(str);
            int L = table[n].size();
            for (int j = 0; j < L; j++) {
                if (check(table[n][j], str)) { // table[n][j] 어떤 특정한 대상의 해쉬값이 n이 나왔을 때, 그 n이 되는 대상들의 집합의
                    cnt++;
                    break;
                }
            }
        }
        cout << "#" << ab << " " << cnt << "\n";
        for (int i = 0; i < MAX; i++)
            if (!table[i].empty()) table[i].clear();
        cnt = 0;
    }
}
