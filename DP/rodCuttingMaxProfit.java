// https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] t = new int[n+1][price.length+1];
        int[] val = new int[price.length];
        for (int i = 1; i < price.length+1; i++){
            val[i-1] = i;
        }
        for (int i = 1; i < t.length; i++){
            for (int j = 1; j < t[0].length; j++){
                if (val[i-1]<=j){
                    t[i][j] = Math.max(price[i-1]+t[i][j-val[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][price.length];
    }
}
