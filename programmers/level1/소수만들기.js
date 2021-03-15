const isPrime = (num) => {
  for(let i = 2; i <= Math.sqrt(num); ++i) {
    if(num % i == 0) {
      return false; 
    }
  }

  return true; 
};

function solution(nums) { 
  const arr = [];
  let answer = 0;

  const combination = (
    arr,
    index,
    reverseCount,
    depth,
  ) => {
    if (reverseCount === 0) {
      const sum = arr.reduce((accumulator,currentValue) => accumulator + nums[currentValue], 0);
      if(isPrime(sum)) ++answer;
    } else if (depth === nums.length) {
      return;
    } else {
      arr[index] = depth;
      combination(arr, index + 1, reverseCount - 1, depth + 1);
      combination(arr, index, reverseCount, depth + 1); 
    }
  };

  combination(arr, 0, 3, 0); 

  return answer; 
}
