# https://www.acmicpc.net/problem/15649

from sys import stdout
from itertools import permutations
print = stdout.write

n, m = map(int, input().split())
for k in permutations([i for i in range(1, n+1)], m):
    print(' '.join(map(str, k))+'\n')
