const arr = [-4, -3, -2, -1, 0, 1, 2, 5];

const solution = arr => {
  let left = 0; //제일 처음 인덱스
  let right = arr.length - 1; // 마지막 인덱스

  while (left < right) {//포인터가 같은 곳을 가리키거나 서로 교차되면 값을 못찾았으므로 loop 끝
    let sum = arr[left] + arr[right];

    if (sum === 0) {//합이 0이면
      return [arr[left], arr[right]];
    } else if (sum > 0) {// 양수면
      right--;
    } else {//음수면
      left++;
    }
  }
  //값을 못찾았다면 여기서 default로 undefined가 리턴된다
};

console.log(solution(arr)); // [-2, 2]