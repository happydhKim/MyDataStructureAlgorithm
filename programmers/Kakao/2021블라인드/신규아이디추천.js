function solution(new_id) {
  const regex = new_id
           .toLowerCase()
           .replace(/[^\w-_.]/g, '')
           .replace(/\.{2,}/g, '.')
           .replace(/^\.|\.$/g, '')
           .replace(/^$/, 'a')
           .slice(0, 15)
           .replace(/\.$/, '');

  return regex.padEnd(3, regex[regex.length - 1]);
}

console.log(solution('...!@BaT#*..y.abcdefghijklm'));
console.log(solution('z-+.^.'));
console.log(solution('=.='));
console.log(solution('123_.def'));
console.log(solution('abcdefghijklmn.p'));

// 예1 "...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
// 예2	"z-+.^."	"z--"
// 예3	"=.="	"aaa"
// 예4	"123_.def"	"123_.def"
// 예5	"abcdefghijklmn.p"	"abcdefghijklmn"