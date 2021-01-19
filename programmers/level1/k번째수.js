function solution(array, commands) {
    return commands.map(command => {
        const [
          startPosition,
          endPosition,
          position,
        ] = command;

        const sortedArray = array
            .filter((_, index) => index >= startPosition - 1 && index <= endPosition - 1)
            .sort((a,b) => a - b);

        return sortedArray[position - 1];
    });
}