class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        return counter(differences, new int[differences.length+1], lower, upper, 0);
    }
    public int counter(int[] differences, int[] arr, int low, int high, int offset){
        if (differences.length == 0){
            return 0;
        }
        arr[0] = low + offset;
        arr[1] = low + differences[0];
        return counter(differences, arr, low, high, offset) + counter(differences, arr, low, high, offset);
    }
}