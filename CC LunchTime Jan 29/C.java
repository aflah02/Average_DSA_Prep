/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int getBitsCount(Long n){
    	return (int)(Math.log10(n) / Math.log10(2)) + 1;
    }
    
    static Long solve(Long num){
    	if(num<=1){
    		return 0L;
    	}
    	else if(num==2 || num==3){
    		return 6L;
    	}
    	int bit = getBitsCount(num);
    	Long diff = Double.valueOf(Math.pow(2,bit)).longValue() - 1 - num;
    	Long sum = 0L;
    	if(diff==0){
    		return solve(num - 1);
    	}
    	sum = sum + solve(diff-1);
    	while(diff < num){
    		sum = sum + 2*(diff^num);
    		diff++;
    		num--;
    	}
    	return sum;
    }
    

	public static void C (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0){
		   	Long k = sc.nextLong();
		    System.out.println(solve(k)); 
		    t--;
		}

	}
}

