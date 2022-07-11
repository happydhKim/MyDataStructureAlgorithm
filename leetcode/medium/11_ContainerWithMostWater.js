/**
 * @param {number[]} height
 * @return {number}
 */
 var maxArea = function(height) {
  const n = height.length;
  let toRight = 0;
  let toLeft = n - 1;
  let answer = 0;
  
  while(toRight < toLeft){
    const val = (toLeft - toRight) * Math.min(height[toRight], height[toLeft]);
    answer = val > answer ? val : answer;
    
    if (height[toLeft] < height[toRight]) {
      const curLeft = height[toLeft];
      while(toLeft >= 0 && height[toLeft] <= curLeft){
        toLeft--;
      }
    } else {
      const curRight = height[toRight];
      while(toRight < n && height[toRight] <= curRight){
        toRight++;
      }
    }               
  }
  
  return answer;
};

console.log(maxArea([1,8,6,2,5,4,8,3,7])); // 49
console.log(maxArea([1,1])); // 1
console.log(maxArea([4,3,2,1,4])); // 16