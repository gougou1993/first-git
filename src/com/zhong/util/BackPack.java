package com.zhong.util;

public class BackPack {

	public static void main(String[] args) {
		 int[] a={2,3,5,7};
	     int[] w={1,5,2,4};
	     System.out.println(backpack2(a,w,10));
	}
	
	public static int backpack2(int[] a,int[] w,int v){
		
		final int M = v;
		final int N = a.length;
		
		int[][] f=new int[N+1][M+1];
	       
	       for(int i=0;i<N;i++){
	    	   
	           for(int j=0;j<=M;j++){//遍历所有小于背包空间的所有空间情况 
	              
	        	   if(a[i]>j)//即j-a[i]<0,放不下 选择不放
	                   f[i+1][j]=f[i][j];
	               else
	                   f[i+1][j]=Math.max(f[i][j], f[i][j-a[i]]+w[i]);//看看放和不放哪个更优
	           }
	       }
	       
	       return f[N][M];

	}
	
	public static int backpack(int[] a,int v){
	       final int M=v;//背包空间
	       final int N=a.length;
	       
	       int[][] f=new int[N+1][M+1];
	       
	       for(int i=0;i<N;i++){
	           for(int j=0;j<=M;j++){//遍历所有小于背包空间的所有空间情况 
	              
	        	   if(a[i]>j)//即j-a[i]<0,放不下 选择不放
	                   f[i+1][j]=f[i][j];
	               else
	                   f[i+1][j]=Math.max(f[i][j], f[i][j-a[i]]+a[i]);//看看放和不放哪个更优
	           }
	       }
	       
	       return f[N][M];
	}
}
