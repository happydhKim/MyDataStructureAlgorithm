
const permutation = (n) => {
  let arrayList = [];
	const check = Array(n).fill(false);
  for (let i = 0; i < n; i++) {
    arrayList.push(n + 1);
  }

  const dfs = (depth, index) => {
    if (depth === n) {
      let stringSet = '';
      for (let i = 0; i < n; i++) {
        stringSet += arrayList[i] + ' ';
      }
      console.log(stringSet);
      return;
    }

    for (let i = index; i < n; i++) {
      check[i] = true;
      arrayList[depth] = i;
      dfs(depth + 1, index + 1);
      check[i] = false;
    }
  };

  dfs(0, 0);
};

permutation(5);