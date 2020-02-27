//Create a function that reverse a string
//'Hi my name is wayme'
//'emyaw si eman iH'
const str = 'Hi my name is Anfrei'

function reverse(str) {
  //check input
  if (!str || str.length < 2 || typeof str !== 'string') {
    return 'hmm that is not good';
  }

  const backwords = [];
  // backwords =  ['3'];
  startPoint = str.length - 1;

  for (i = startPoint; i >= 0; i--) {
    backwords.push(str[i]);
  }
  console.log(backwords)
  newBackWords = backwords.join('')
  return newBackWords;
 }

 function reverse2(str) {
   return str.split('').reverse().join('');
 }

 const reverse3 = str => str.split('').reverse().join('')

 console.log(reverse3('Hi my name is wayne'))