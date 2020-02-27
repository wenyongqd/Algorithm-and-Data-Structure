//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4];
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,5]
//It should return 1

//Given an array = [2,3,4,5]
//It should return undefined

function firstRecurringCharacter(input) {
    for (i = 0; i < input.length; i++) {
        for ( j = 0; j < i; j++) {
            const temp = input[i]
            if ( temp === input[j]) {
                return temp
            }
        }
    }
    return undefined
}

function firstRecurringCharacter2(input) {
    let map = new Map()
    for (i = 0; i < input.length; i++) {
        if(input[i] === map.get(input[i])) {
            return input[i]
        }
        map.set(input[i],input[i])
    }
    console.log(map.size)
    return undefined
}

function firstRecurringCharacter3(input) {
    let map = {}
    for (i = 0; i < input.length; i++) {
        if ( map[input[i]] === input[i]) {
            return input[i]
        }
        map[input[i]] = input[i]
    }

    return undefined

}

var map = {}
map.key = 1
map.key = 2
map[1] = 1
console.log(map[1])

const str1 = [2,5,1,2,3,5,1,2,4];
const str2 = [2,1,1,2,3,5,1,2,5];
const str3 = [2,3,4,5];

console.log(firstRecurringCharacter3(str3));
