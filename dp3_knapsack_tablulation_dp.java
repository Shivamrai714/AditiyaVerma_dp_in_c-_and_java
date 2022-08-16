//THis is actual bottom up dp : tablulation method.

public class dp3_knapsack_tablulation_dp {
    public static int[][] dp = new int[1001][1001];

    public static void main(String[] args) {

        int n=4;
        int[] wt={1,3,4,5};
        int[] val={1,4,5,7};
        int C=7;
         //base condition is converted to initialization
        for(int i=0;i<n+1;i++)
        {for(int j=0;j<C+1;j++)
            {
             if(i==0 || j==0 ) dp[i][j]=0;
            }
        }
        //choice diagram is converted to two for loops:
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<C+1;j++)
            {   //include - exclude choices            , just the change the code of knapsack   n  --> i   and C --> j
                if( wt[i-1] <= j)
                {
                    dp[i][j] = Math.max( val[i-1] + dp[i-1][ j-wt[i-1] ] , dp[i-1][j]   );
                }
                else    //exclude that ele
                {
                    dp[i][j]=dp[i-1][j];
                }

            }
        }

        System.out.println("The Profit is : " + dp[n][C] +"\n");



      for(int i=0;i<n+1;i++)
      {
          for(int j=0;j<C+1;j++)
          {
              System.out.print(dp[i][j]+" ");
          }
          System.out.println();
      }



    }


}


/*
Code helped in changing memoization to tabulation dp      ,, just replace the n with i nad C with the j.

 if( wt[n-1] <= C )
                {
                    returm t[n][C]= max( val[n-1] + t[n-1][ j - wt[n-1] ]  ,  t[n-1][j] );
                }
                //exclude it
               else {
                    return t[n][C] = t[n - 1][j];
                }

TO convert to dp just remove the return and replace the n -->i      and    C  ---> j
* */


