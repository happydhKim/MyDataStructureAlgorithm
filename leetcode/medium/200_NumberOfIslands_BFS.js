const DIR = [
  { nx: 0, ny: 1},
  { nx: 1, ny: 0},
  { nx: -1, ny: 0},
  { nx: 0, ny: -1},
];

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  const m = grid.length;
  const n = grid[0].length;

  let queue = [];
  let check = Array.from(Array(m), () => Array(n).fill(false));
  let answer = 0 ;
  
  const bfs = () => {
    while (queue.length) {
      const {x, y} = queue.shift();
      for (let k = 0; k < 4; k++) {
        const {nx, ny} = DIR[k];
        const nextX = x + nx;
        const nextY = y + ny;
        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] === '1' && !check[nextX][nextY]) {
          check[nextX][nextY] = true;
          queue.push({ x: nextX, y: nextY });
        }
      }
    }
  }
  
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === '1' && !check[i][j]) {
        check[i][j] = true;
        queue.push({ x: i, y: j });
        bfs();
        answer++;
      }
    }
  }

  return answer;
};

console.log(numIslands([
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]));
console.log(numIslands(
  [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]
));
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3