/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
  const checkValid = (arr) => {
    let nums = {
      '1': 0,
      '2': 0,
      '3': 0,
      '4': 0,
      '5': 0,
      '6': 0,
      '7': 0,
      '8': 0,
      '9': 0,
    };
    for (let i = 0; i <= arr.length; i++) {
      if (nums[arr[i]] === '.') continue;
      if (nums[arr[i]] > 0) return false;
      if (nums[arr[i]] === 0) {
        nums[arr[i]]++;
      }
    }
    
    return true;
  };

  const isValidRow = () => {
    for (let i = 0; i < board.length; i++) {
      if (!checkValid(board[i])) {
        return false;
      }
    }
    return true;
  };

  const isValidColumn = () => {
    for (let i = 0; i < board.length; i++) {
      let arr = [];
      for (let j = 0; j < board.length; j++) {
        arr.push(board[j][i]);
      }
      if (!checkValid(arr)) {
        return false;
      }
    }
    return true;
  };

  const isValidBox = () => {
    for (let i = 0; i < 3; i++) {
      const depth = i * 3;
      let arr = [];
      for (let j = 0; j < board.length; j++) {
        if (j === 3 || j === 6) arr = [];
        for (let k = depth; k < depth + 3; k++) {
          arr.push(board[j][k]);
        }
        if (j === 2 || j === 5 || j === 8) {
          if (!checkValid(arr)) {
            return false;
          }
        }
      }
    }
    return true;
  };

  return isValidRow() && isValidColumn() && isValidBox();
};

// console.log(isValidSudoku(
//   [["5","3",".",".","7",".",".",".","."]
//   ,["6",".",".","1","9","5",".",".","."]
//   ,[".","9","8",".",".",".",".","6","."]
//   ,["8",".",".",".","6",".",".",".","3"]
//   ,["4",".",".","8",".","3",".",".","1"]
//   ,["7",".",".",".","2",".",".",".","6"]
//   ,[".","6",".",".",".",".","2","8","."]
//   ,[".",".",".","4","1","9",".",".","5"]
//   ,[".",".",".",".","8",".",".","7","9"]]
// ));
// console.log(isValidSudoku(
//   [["8","3",".",".","7",".",".",".","."]
//   ,["6",".",".","1","9","5",".",".","."]
//   ,[".","9","8",".",".",".",".","6","."]
//   ,["8",".",".",".","6",".",".",".","3"]
//   ,["4",".",".","8",".","3",".",".","1"]
//   ,["7",".",".",".","2",".",".",".","6"]
//   ,[".","6",".",".",".",".","2","8","."]
//   ,[".",".",".","4","1","9",".",".","5"]
//   ,[".",".",".",".","8",".",".","7","9"]]
// ));
console.log(isValidSudoku(
  [[".",".","4",".",".",".","6","3","."]
  ,[".",".",".",".",".",".",".",".","."]
  ,["5",".",".",".",".",".",".","9","."]
  ,[".",".",".","5","6",".",".",".","."]
  ,["4",".","3",".",".",".",".",".","1"]
  ,[".",".",".","7",".",".",".",".","."]
  ,[".",".",".","5",".",".",".",".","."]
  ,[".",".",".",".",".",".",".",".","."]
  ,[".",".",".",".",".",".",".",".","."]]));


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false



var isValidSudoku = function(board) {
  const set = new Set()
  
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      const value = board[i][j]
      if(value !== "."){
        const rowString = `${value} at row ${i}`
        const colString = `${value} at col ${j}`
        const boxString = `${value} at box ${Math.floor(i/3)}, ${Math.floor(j/3)}`
        
        if(set.has(rowString) || set.has(colString) || set.has(boxString)){
          return false
        }else{
          set.add(rowString)
          set.add(colString)
          set.add(boxString)
        }
      }
    }
  }

  return true
};