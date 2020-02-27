str = 'abcdefghijk,.';

var isUnique = function (str) {
    if(str.length > 128) {
        return false;
    }

    for (i = 0; i < str.length; i++) {
        for (j = 0; j <  str.length; j++) {
            if (str[i] == str[j]) {
                return false
            }
        }
    }
    return true

}
console.log(str.length)
console.log(isUnique(str))