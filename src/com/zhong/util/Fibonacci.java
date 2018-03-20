package com.zhong.util;
/**
 * 
 * 当遇到复杂问题时我们经常会通过递归的方式将大事化小，小事化了。
 * 但是有时候将复杂问题简单地分解成几个子问题，问题求解耗时会按问题规模呈幂级数增加。
 * 这时候为了节约重复求相同子问题的时间，引入一个数组(或临时变量)，不管它们是否对最终解有用，
 * 把所有子问题的解存于该数组(或临时变量)中，这就是动态规划的基本思想。
 * 
	作者：Acamy丶
	链接：https://www.jianshu.com/p/514d535eceab
	來源：简书
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fib1(2));
	}
	
	public static int fib1(int n){
		
		if(n<2){
			return n;
		}
		return fib1(n-1) + fib1(n-2);
	}
	
	
	public static int fib2(int n){
		if(n < 2) return n;
		
		int a = 0;//第一个值
		int b = 1;//第二个值
		
		int tmp = 0;//辅助变量
		
		for(int i = 2;i<=n;i++){
			
			tmp = a+b;
			
			//往后挪一个值
			a = b;
			b = tmp;
			
		}
		
		return tmp;
	
	}
	
	

	/**
	 * 问题描述：有一座高度为n级的楼梯，从下往上走，
	 * 每跨一步只能向上1级或者2级台阶，求出一共有多少种走法。
	 * @param n
	 * @return
	 */
	public static int getNum(int n){
		if(n<=2){
			return n;
		}
		return getNum(n-1) + getNum(n-2);
	}
	/**
	 * 问题描述：有一座高度为n级的楼梯，从下往上走，
	 * 每跨一步只能向上1级或者2级台阶，求出一共有多少种走法。
	 * @param n
	 * @return
	 */
	public static int getNum2(int n){
		
		if(n <=2) return n;
		
		
		int a = 1;//只有一级台阶
		int b = 2;//有2级台阶的情况
		
		int tmp = 0;//辅助变量
		
		for(int i = 3;i<=n;i++){
			tmp  = a+b;
			a = b;
			
			b = tmp;
		}
		
		return tmp;
	}
	
	
	
	/**
     * 递归方式实现求两个字符串最长公共字序列的长度
     * @param str1 第一个字符串
     * @param m 第一个字符串需要比较的长度
     * @param str2 第二个字符串
     * @param n 第一个字符串需要比较的长度
     * @return
     */
    public static int lcs(String str1,int m,String str2,int n){
        if(m == 0 || n == 0) return 0;//如果其中有一个元素为空则返回0
        if(str1.charAt(m - 1) == str2.charAt(n - 1)) 
            return lcs(str1,m - 1,str2,n - 1) + 1;//如果需要比较的两个字符串最后一个字符相同则将问题缩小
        
        //剩下的情况则两个字符串的最后一个字符不相等，取两种情况中的最大值
        return getMax(lcs(str1,m - 1,str2,n),lcs(str1,m,str2,n - 1));
    }

	/**
     * 非递归方式实现求两个字符串最长公共字序列的长度
     * @param str1 第一个字符串
     * @param m 第一个字符串需要比较的长度
     * @param str2 第二个字符串
     * @param n 第一个字符串需要比较的长度
     * @return
     */
    public static int lcs1(String str1,int m,String str2,int n){
        if(m == 0 || n == 0) return 0;
        //构建一个m + 1行 n + 1列的辅助二维数组,里面的元素初始值都为0
        int[][] arr = new int[m + 1][n + 1];
        //依次求二维数组中的值
        for(int i = 1;i <= m;i ++){
        	
        	
            for(int j = 1;j <= n; j ++){
                //当最后一个字符相等时等于左上角的元素加1
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) arr[i][j] = arr[i - 1][j - 1] + 1;
                //不相等时取紧邻左边元素和上边元素者的大者
                else arr[i][j] = getMax(arr[i - 1][j],arr[i][j - 1]);
            }
            
        }
        return arr[m][n];//二维数组右下角的元素即我们需要的值
    }
    public static int getMax(int x,int y){
    	return x>y?x:y;
    }
	
    
    
	
}
