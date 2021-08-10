/**
 * BALANCED ARRAY
 *
 * Given an array of numbers, find the index of the smallest array element (the pivot), for which the sums of the all
 * elements to the left and to the right are equal. The array may not be reordered.
 *
 * EXAMPLE
 *
 * arr=[1,2,3,4,6]
 * - the sum of the first three elements, 1+2+3=6, the value of the last element is 6.
 * - Using zero based indexing, arr[3]=4 is the pivot between the two subarrays.
 * - The index of the pivot is 3.
 *
 * @param arr
 */
function balancedSum(arr) {
    let index = -1;
    for (let i = 1; i < arr.length; i++) {
        let first_arr_sum = 0;
        let last_arr_sum = 0;

        for (let j = 0; j < i; j++) {
            first_arr_sum += arr[j]
        }
        for (let j = i + 1; j < arr.length; j++) {
            last_arr_sum += arr[j]
        }
        if(first_arr_sum === last_arr_sum) {
            index = i;
            break;
        }
    }
    return index;
}

let arr = [1,2,3,3]
console.log(balancedSum2(arr))
arr = [1,2,3,4,6]
console.log(balancedSum2(arr))

/**
 * The 2nd solve
 *
 * @param arr
 * @returns {number}
 */
function balancedSum2(arr) {
    let index = -1;
    let first_arr_sum = 0
    let last_arr_sum = 0
    main_loop:
    for (let i = 0; i < arr.length; i++) {
        first_arr_sum += arr[i];
        for (let j = arr.length - 1; j > 0; j--) {
            if (first_arr_sum === last_arr_sum && (j - i) === 2) {
                index = (i + 1);
                break main_loop;
            } else if (last_arr_sum < first_arr_sum) {
                last_arr_sum += arr[j];
            } else if (last_arr_sum >= first_arr_sum) {
                break;
            }
        }
    }
    return index;
}