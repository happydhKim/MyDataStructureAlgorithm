function solution(progresses, speeds) {
  let answer = [];

  const setNextDayProgresses = () => {
    for (let i = 0; i < progresses.length; i++) {
      progresses[i] += speeds[i];
    }
  };

  const removeCompletedJobList = () => {
    while (progresses[0] >= 100) {
      progresses.shift();
      speeds.shift();
    }
  };

  const getNextDayProgressInformation = () => {
    let jobDoneCount = 0;
    for (let i = 0; i < progresses.length; i++) {
      if(progresses[i] >= 100) {
        jobDoneCount++;
      } else {
        break;
      }
    }
    if(jobDoneCount) {
      removeCompletedJobList();
      answer.push(jobDoneCount);
    }
  };

  while (progresses.length) {
    setNextDayProgresses();
    getNextDayProgressInformation();
  }

  return answer;
}
