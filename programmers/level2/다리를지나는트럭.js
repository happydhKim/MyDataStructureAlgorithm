function solution(bridgeLength, weight, truckWeights) {
  let timeCount = 0;
  let queue = Array(bridgeLength).fill(0);
  let queueSum = 0;
  let currentTruckInformation = truckWeights.shift();
  
  const initiateBridge = () => {
    queue.unshift(currentTruckInformation);
    queue.pop();
    queueSum += currentTruckInformation;
    timeCount++;
  };

  const setNextSecondBridgeStatus = () => {
    queueSum -= queue.pop();
    currentTruckInformation = truckWeights.shift();
  };

  const setNextSecondBridgeAction = () => {
    if (currentTruckInformation + queueSum <= weight) {
      queue.unshift(currentTruckInformation);
      queueSum += currentTruckInformation;
    } else {
      queue.unshift(0);
      truckWeights.unshift(currentTruckInformation);
    }
  };

  initiateBridge();

  while(queueSum) {
    setNextSecondBridgeStatus();
    setNextSecondBridgeAction();
    timeCount++;
  }

  return timeCount;
}
