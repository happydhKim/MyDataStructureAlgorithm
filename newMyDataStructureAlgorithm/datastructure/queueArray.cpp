Queue (큐)
큐는 선형 구조이며, 삽입된 순서대로 값이 나오는 FIFO(First in First Out)로 되어 있습니다. 이때 삽입하는 과정을 enqueue라고 하며 값을 빼내는 과정을 dequeue라고 합니다.
예를 들면 a, b, c 순서로 enqueue하고 큐에 있는 값들을 모두 dequeue하면 a, b, c 순서로 나오게 됩니다.
또한 큐에는 size, front, empty라는 함수가 있으며 size는 큐에 들어있는 값들의 수를 반환하는 함수이고, front은 큐에서 가장 먼저 삽입된 값을 반환하는 함수, empty는 큐가 비어 있는지 여부를 반환하는 함수입니다.

입력	출력
첫 줄에 명령어의 개수 N이 주어집니다. (1 ≤ N ≤ 1,000,000)
두번째 줄부터 N개의 줄에 걸쳐 아래의 명령어가 입력됩니다.
enqueue x : x를 큐에 삽입합니다.
dequeue : 가장 먼저 들어온 인자를 삭제합니다.
size : 큐의 크기를 출력합니다.
front: 큐의 맨 앞 인자 값을 출력합니다.	각 명령 순서에 따라 값을 출력합니다.

Sample Input
8
size
enqueue 4
enqueue 3
front
size
dequeue
front
size

Sample output
0
4
2
3
1

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
struct queue {
    int *data;
    int front,rear;
    int maxsize;
    int size;
    queue(int sz = 16) {
        maxsize = sz;
        front = 0;
        rear = 0;
        size = 0;
        data = (int*)malloc(maxsize*sizeof(int));
    }
};

int queue_size(queue& q) {
    return q.size;
}
bool queue_empty(queue& q) {
    return queue_size(q) == 0;
}
bool queue_full(queue& q) {
    return q.size == q.maxsize;
}
void queue_push(queue& q, int val) {
    assert(!queue_full(q));
    q.data[q.rear] = val;
    q.rear = (q.rear + 1) % q.maxsize;
    q.size++;
}
void queue_pop(queue& q) {
    assert(!queue_empty(q));
    q.front = (q.front + 1) % q.maxsize;
    q.size--;
}
int queue_front(queue& q) {
    assert(!queue_empty(q));
    return q.data[q.front];
}
int main() {
    int val;
    queue q;

    for (int i = 0; i < 5; i++) {
        queue_push(q,i); // input : 0 1 2 3 4
    }
    printf("output : ");
    while(!queue_empty(q)) {
        printf("%d ", queue_front(q));
        queue_pop(q);
    }

    return 0;
}
