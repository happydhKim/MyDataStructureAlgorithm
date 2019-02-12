//입출력
//형식 지정자
//%c 문자 한개, %d 부호가 있는 정수로서 10진수, %e 과학 계산용 표기, %E 과장 계산용 표기
//%f 실수로서 10진수, %g
//%p 포인터, 즉 메모리의 주소를 출력
//%o 부호가 없는 정수로서 8진수, %x,%X 16진수
//%% %문자 출력
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
