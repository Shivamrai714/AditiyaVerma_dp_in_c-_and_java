public class dp12_coins_change_max_no_ways {

    public static  int t[][]= new int[1001][1001];

    public static void main(String[] args) {
        System.out.println("Here we need to find the maximum / total no of ways to get the sum from the coins change.");

    int n=3;
    int coins[]={1,2,3};
    int sum=5;

        System.out.println("All ways are  :  { 1+1+1+1+1 , 1+1+1+2, 1+1+3 , 1+2+2 , 2+3 }  ");
  int C=sum;

  // initialization :
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                if(i==0 ) {
                    t[i][j] = 0;        // i==0 means no elements in array , so ways to divide =0
                }
                if(j==0){                 //  **********************************
                      t[i][j]=1;              // if j==0 sum is 0, yes 1 way availablle take empty {} set , it has sum 0 no matter how many elemenets in the array.
                }
            }
        }


        // loops to distribute the sum.

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<C+1;j++)
            {
                if(coins[i-1]<=j)
                {          // to get total no of ways just change max to +
                    t[i][j]= (  t[i][j- coins[i-1]]   +  t[i-1][j] );
                }
                else         //excluded
                    t[i][j]=t[i-1][j];
            }
        }

        System.out.println(" The maximum ways to have a change is  "+ t[n][C]);

// status of the updated matrix
        for(int i=0;i<n+1;i++){
            for(int j=0;j<C+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
        System.out.println();
        }



    }
}
