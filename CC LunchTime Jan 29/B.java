/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef{
    
    static Boolean check(String s,int n,int k){
    	if(n==0){
    		return true;
    	}
    	int sum = 0;
    	for(int i=n-1;i>=0;i--){
    		int x = Character.getNumericValue(s.charAt(i)) + sum ;
    		x = x % 10;
    		if(x!=0){
    			sum = sum + (10 - x);
    		}
    	}
    	if(sum<=k){
    		return true;
    	}
    	return false;
    }


    static int solve(String s,int start,int end,int k){
    	int ans = 0;
    	while(start<=end){
    		int mid = (start +  end)/2;
    		if(check(s,mid,k)){
    			ans = mid;
    			start = mid+1;
    		}
    		else{
    			end = mid-1;
    		}
    	}
    	return ans;
    }

	public static void B (String[] args) throws java.lang.Exception
	{
		Scanner sc =new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0){
		    int n,k;
        	n = sc.nextInt();
        	k = sc.nextInt();
        	String s;
        	s = sc.next();
        // 	System.out.println(n + " " + k + " " + s);
		    int ans = solve(s,1,s.length(),k);
		    System.out.println(ans);
		    t--;
		}
	}
}