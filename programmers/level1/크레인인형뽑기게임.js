function solution(board, moves) {
  let basket = [];
  let answer = 0;

  const getDoll = (board, index) => {
    for (let i = 0; i < board.length; i++) {
      if (board[i][index]) {
        const doll = board[i][index];
        board[i][index] = 0;

        return doll;
      }
    }
  };

  moves.forEach((value) => {
    const doll = getDoll(board, value - 1);
    const isSameDolls = () => basket[basket.length - 1] === doll;

    if (!doll) return;
    
    if (isSameDolls()) {
      basket.pop();
      answer += 2;
    } else {
      basket.push(doll);
    }
  });
  
  return answer;
}