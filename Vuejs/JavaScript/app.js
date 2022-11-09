//export 해서 사용하는 역할

// //import 해놓고 사용하지 않으면 vue-cli에서는 오류 발생!!!!!
// import { PLAYERS, MAX_SIZE, add, obj } from "./export.js";

// console.log(PLAYERS);
// console.log(MAX_SIZE);
// console.log(add(5, 7));
// console.log(obj.template);

// import { MAX_SIZE } from "./export.js";
// console.log(MAX_SIZE);

// import MY_SIZE from "./export.js";
// console.log(MY_SIZE);

// import obj2 from "./export.js";
// console.log(obj2);
// obj2.log();

// console.log(obj2.data().num);

//template만 들고 올 때

// import obj from "./export.js";
// let { template } = obj;
// console.log(template);
//export에서 default 사용하면

import { obj } from "./export.js";
let { template } = obj;
console.log(template);
//export에서 export{obj}이렇게 사용하면
