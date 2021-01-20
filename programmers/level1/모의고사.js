function solution(answers) {
    var answer = [];
    let count = [0, 0, 0];

    const pattern1 = [1, 2, 3, 4, 5];
    const pattern2 = [2, 1, 2, 3, 2, 4, 2, 5];
    const pattern3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    for(let i = 0; i < answers.length; i++) {
        if(answers[i] == pattern1[i % pattern1.length]) count[0]++;
        if(answers[i] == pattern2[i % pattern2.length]) count[1]++;
        if(answers[i] == pattern3[i % pattern3.length]) count[2]++;
    }

    const max = Math.max(count[0], count[1], count[2]);
    for(let i = 0; i < count.length; i++) {
        if(max == count[i]) answer.push(i + 1);
    }

    return answer;
}