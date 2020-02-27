function mergeSortedArrays(array1, array2) {
    const mergeArray = [];
    let array1Item = array1[0];
    let array2Item = array2[0];
   
    i =1;
    j =1;

    //check input
    if (array1.length === 0) {
        return array1;
    }
    if  (array2.length  === 0) {
        return array2;
    }

    while (array1Item || array2Item) {
        if (!array2Item || array1Item < array2Item) {
            mergeArray.push(array1Item)
            array1Item=array1[i];
            i++
              
        } else {
            mergeArray.push(array2Item);
            array2Item = array2[j];
            j++;
        }
    }


    return mergeArray;
}

console.log(mergeSortedArrays([0,3,4,30,44], [4,6,31]));