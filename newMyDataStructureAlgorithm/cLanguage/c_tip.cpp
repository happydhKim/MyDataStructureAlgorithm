//입출력
scanf("%s\n", );
// %d 정수, %f 실수, %c 단일문자, %s 문자열

//동적 메모리 할당 함수의 이해

void* malloc(size_t size);
void* calloc(size_t nmemb, size_t size);
void* realloc(void* ptr, size_t size);
//3개의 for문 같은 결과.
int num[5] = {10,20,30,40,50};
int* p,i;

p=num;
for( ; *p; p++)
  printf("%c",*p);

for (i = 0; i < p[i]; i++) {
  printf("%c",p[i]);
}

for (i = 0; i < *(str+i); i++) {
  printf("%c",*(str+i));
}
