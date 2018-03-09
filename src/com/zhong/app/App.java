package com.zhong.app;
/**
 * 			
 * //1.https://www.cnblogs.com/10158wsj/p/6782124.html?utm_source=tuicool&utm_medium=referral

 * @author admin
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("This is my first git.");
	
		int[] a = {4,3,2,1};
		
		App.insertSort(a);
		
		
		//App.selectSort(a);
		for (int i : a) {
			System.out.print(i);
		}
		
	}
	
	public static void insertSort(int[] a){
		int len = a.length;
		int insertNum;
		
		for (int i = 1; i < len; i++) {
			
			insertNum = a[i];
			int j = i - 1;
			
			while(j>=0 && a[j]>insertNum){
				
				a[j+1] = a[j];
				j--;
			}
			//2.
			/*for(;j>=0;j--){
				if(a[j]> insertNum){
					a[j+1]  = a[j];
				}else{
					break;
				}
			}
			*/
			a[j+1] = insertNum;
		}
	}
	
	/**
	 * 3.简单选择排序
	 * 
		常用于取序列中最大最小的几个数时。
		
		
		(如果每次比较都交换，那么就是交换排序；如果每次比较完一个循环再交换，就是简单选择排序。)
		
		遍历整个序列，将最小的数放在最前面。
		
		遍历剩下的序列，将最小的数放在最前面。
		
		重复第二步，直到只剩下一个数。

		代码实现：
			首先确定循环次数，并且记住当前数字和当前位置。
			将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
			比对完成后，将最小的值与第一个数的值交换。
			重复2、3步。
	 * @param a
	 */
	public static void selectSort(int[] a){
		
		int len  = a.length;
		
		for (int i = 0; i < len; i++) {//循环次数
			
			int value = a[i];
			
			int position = i;
			
			for(int j = i+1;j < len;j++){// 找到最小的值和位置
				
				if(a[j] < value){
					
					value = a[j];
					position = j;
					
				}
				
			}
			
			
			a[position] = a[i];//进行交换
			
			a[i] = value;
			
		}
	}
	/***
	 * 4.堆排序
		对简单选择排序的优化。
		
		将序列构建成大顶堆。
		
		将根节点与最后一个节点交换，然后断开最后一个节点。
		
		重复第一、二步，直到所有节点断开。
	 * @param a
	 */
	public  void heapSort(int[] a){
        int len=a.length;
        //循环建堆  
        for(int i=0;i<len-1;i++){
            //建堆  
            buildMaxHeap(a,len-1-i);
            //交换堆顶和最后一个元素  
            swap(a,0,len-1-i);
        }
    }
     //交换方法
    private  void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    //对data数组从0到lastIndex建大顶堆  
    private void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始  
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点  
            int k=i;
            //如果当前k节点的子节点存在  
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引  
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在  
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大  
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引  
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值  
                if(data[k]<data[biggerIndex]){
                    //交换他们  
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
}
