package com.test.algorithm;

import java.util.Random;

public class LVQueen1
{
    static Random rnd;//随机数产生器
    static int n;//皇后个数
    static int stop;
    static int[] x;//解向量
    
    private static boolean place(int k)//第k个皇后能不能放置在x[k]
    {
        for(int j = 1; j< k; j++)
        {
            if(Math.abs(k - j) == Math.abs(x[k] - x[j]) || x[j] == x[k])
                return false;
        }
        return true;
    }
    
    private  static boolean queensLV(int stop)//要放置n个皇后，先随机的放置stop个皇后
    {
        rnd = new Random();
        int k = 1;
        int count = 1;
        while((k <= stop) &&(count > 0))
        {
            count  = 0;
            int j = 0;
            for(int i = 1; i <= n; i++)
            {
                x[k] = i;
                
                if(place(k))
                {
                    if(rnd.nextInt(++count) == 0)
                        {
                            j = i;
                            System.out.println("j = " +j +" count = "+count );
                            //break;//有break如果第一此找到合适的列place(k)满足，那么此时random（1）==0恒成立，遇到下面的break，就把皇后放置在这个位置。如果这种放置皇后的方案不可行，下次循环还会执行同样的，故一直循环调不出来找不到方案。即剩下的所有皇后放置不了的可能性增大。
                            //没有break，会一直试探for循环结束。x[k]会在随机的选择当前可以放置的位置中for循环最后一个满足的列。那么后面如果n-1个皇后放置不了的可能性减小。
                        }
                }
            }
            if(count > 0) 
            {
                x[k++] = j;
                System.out.println("k = " + k+" x[k-1] = " + x[k-1]);
            }
        }
        return  (count> 0);
    }
    
    private  static void backtrack(int t)//放置好剩下的n-stop个皇后。
    {
        if(t > n)
        {
            System.out.println("------n-stop个皇后解法--------");
            for(int i = stop+1; i <= n; i++)//在放置好stop个皇后后，会显示所有可行的方案。由于是回溯，故形参t不停的变。要想只显示n-stop个数据的话，要重新设置stop为类成员。
            {
                System.out.println("("+i + " , " +x[i]+")" );
            }
            return ;
        }
        else 
            for(int i = 1; i <= n; i++)
            {
                x[t] = i;
                if(place(t)) 
                {
                    backtrack(t+1);
                    //break;不能有break。否则会出现无法回溯
                }               
            }
    }
    
    public static  void nQueen(int stop)
    {
        x = new int[n+1];
        for(int i = 0; i <= n; i++)//将待放置的n个皇后位置赋初值。
        {
            x[i] = 0;
        }
        
        while(!queensLV(stop));//放好stop个皇后。stop放置的越多，下面的回溯法放置剩下的皇后成功率越小。
        System.out.println("------前stop个皇后的解法--------");
        for(int i = 1; i <= stop; i++)//再放置好stop个皇后后，会显示所有可行的方案。
        {
            System.out.println( "("+i + " , " +x[i]+")" );
        }
        backtrack(stop+1);//放剩下的所有皇后,如果能放就成功。否则就失败。
    }
    
    public static void main(String[] args)
    {
        rnd = new Random();
        n = 8;
        stop = 3;
        nQueen(stop);
    }
 
}

















