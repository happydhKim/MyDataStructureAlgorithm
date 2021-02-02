function solution(n, lost, reserve) {
  const updatedLost = lost.filter(value => !reserve.includes(value));
  let updatedReserve = reserve.filter((value) => !lost.includes(value));
    
  return n - updatedLost.filter(value => {
    const lostMember = updatedReserve.find(reserve => Math.abs(reserve - value) <= 1);
    if(!lostMember) return true;
    updatedReserve = updatedReserve.filter(reserve => reserve !== lostMember);
  }).length;
}