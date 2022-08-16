public class dp2_knapsack_memoization {
  static int [][]t= new int [1001][1001];
//CTRL + ALT  + shift  : remove the type checkbox

  public static int knapsack(int wt[],int val[],int C,int n)
  {
      //base cond
      if(n==0 || C==0) return 0;

      // good step of memoization dp

     if( t[n][C]!=-1 ) return t[n][C];


      //choice diagram
      else if(wt[n-1]<=C)
      {                //included                                               //exclude
          return t[n][C]= Math.max(  val[n-1] + knapsack(wt,val,C-wt[n-1], n-1) , knapsack(wt,val,C,n-1));
      }
      else        //exluded
         return t[n][C]= knapsack(wt,val,C,n-1);

  }



    public static void main(String[] args) {
        System.out.println("Knapsack using the memoization : top-down dp");

         int n=4; int C=7;
        int wt[]={1,3,4,5};
        int val[]={1,4,5,7};

        //int [][]t= new int [n+1][C+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                t[i][j]=-1;
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
   int profit=knapsack(wt,val,C,n);
        System.out.println("Profit after knapsack : "+ profit);
        System.out.println();
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {

                System.out.print(t[i][j]+"  ");
            }
            System.out.println();
        }


    }

}
