/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
  let answer = [];

  const getPascalTriangleRow = (previousRow, currentRow) => {
    for (let i = 1; i < previousRow.length; i++) {
      currentRow.push(previousRow[i - 1] + previousRow[i]);
    }
    currentRow.push(1);

    if(currentRow.length - 1 === rowIndex) {
      answer = currentRow;
      
      return;
    } else {
      getPascalTriangleRow(currentRow,[1]);
    }
  };

  if (rowIndex === 0) return [1];
  else if(rowIndex === 1) return [1, 1];
  else {
    getPascalTriangleRow([1, 1], [1]);
  }

  return answer;
};

console.log(getRow(2));