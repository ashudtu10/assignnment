/***
 * Completing balancedSum function
 * Parameters : integer array
 * Returns index of the pivot element
 */

public int balancedSum(int arr[]){
    int arr_size = arr.length;
    int totalSum = 0;
    int sumLeft = 0;
    for(int i = 0; i< arr_size; i++){
        totalSum += arr[i];
    }
    for(int i = 0; i< arr_size; i++){
        if(sumLeft == totalSum - sumLeft - arr[i])
            return i;
        sumLeft += arr[i];
    }
    return -1;
}