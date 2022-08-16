public class dp1_recursion_knapsack {

    public  static int knapsack(int wt[],int val[], int C, int n)
    {
        //base cond : smallest valid input :
        if(n==0 || C==0) return 0;

        //choice diagram
        else if(wt[n-1] <= C)
        {               //include the ele , and add its profit         ,  exlude the ele                      , n-1 as next elemets to be processed, as we have alrady checked the nth ele by include or exluding.
           return Math.max ( val[n-1] + knapsack(wt,val,C-wt[n-1] ,n-1)  , knapsack(wt,val,C,n-1) );
        }

       else return knapsack(wt, val, C, n - 1);

    }

    public static void main(String[] args) {
        System.out.println("Knapsack 0/1 using recursion");

        int n=4;
        int C=7;

        int wt[]={1,3,4,5};
        int val[]={1,4,5,7};

        int profit= knapsack(wt,val,C,n);
        System.out.println("Profit is : " + profit);

    }
}