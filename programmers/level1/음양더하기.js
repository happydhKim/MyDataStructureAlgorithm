function solution(absolutes, signs) {
  return absolutes.reduce((prev, current, i) => prev + (signs[i] ? current : -current), 0);
}

