#case1

from sys import stdin

def bfs(start,goal):
    global arr
    arr[start[0]][start[1]]=0
    queue = [(start,1)]
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    while queue:
        n,count = queue.pop(0)
        if n==goal:
            return count
        else:
            for i in range(4):
                nx = n[0]+dx[i]
                ny = n[1]+dy[i]
                if nx>=0 and nx<N and ny>=0 and ny<M and arr[nx][ny]==1:
                    arr[nx][ny]=0
                    queue.append(((nx,ny),count+1))

N,M = map(int, stdin.readline().split())
arr = [[0]*M for i in range(N)]
for i in range(N):
    tmp = stdin.readline()
    for j in range(M):
        arr[i][j]=int(tmp[j])
start = (0,0)
goal = (N-1,M-1)
print(bfs(start,goal))



#case2

from sys import*
input = stdin.readline
setrecursionlimit(10**6)

def bfs(y,x):
    q=[]
    q.append([y,x])
    while q:
        y,x=q.pop(0)
        if y==n-1 and x==m-1 :
            return visit[y][x]
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (ny<0 or nx<0 or ny>n-1 or nx>m-1 or arr[ny][nx]=='0'
                or visit[ny][nx]!=0):
                continue

            visit[ny][nx]=visit[y][x]+1
            q.append([ny,nx])

    return -1

n,m=map(int,input().split())
arr=[]
visit=[[0]*m for i in range(n)]
visit[0][0]=1
for i in range(n):
    arr.append(input().strip())
dy=[-1,1,0,0]
dx=[0,0,1,-1]

print(bfs(0,0))
