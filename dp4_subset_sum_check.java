public class dp4_subset_sum_check {

   public static boolean[][]t= new boolean[1001][1000];            //global array declared.

    public static void main(String[] args) {
        System.out.println("Checking the subset sum is possible or not.");

        int n=5;
        int[] arr={2,3,7,8,10};
        int sum=11;

        boolean possible= check_subsetsum(arr, sum, n);

        System.out.println("Whether subset sum is possible : " + possible);

    }

    public static boolean check_subsetsum(int[] arr, int C, int n)
    {
        //base condition is turened into initailization
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                if(i==0) t[i][j]=false;   //if ele presnet is 0 , no subset sum can be achieved hence false;
                if(j==0) t[i][j]=true;    // if no of ele in arr[] can be any, so can we have 0 sum (j==0) yes take {empty set}
             }
        }
        //choice dialgram is changed to loop conditions

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<C+1;j++)
            {
                if(arr[i-1] <= j)
                {  //include                          //exlude
                    t[i][j]= ( t[i-1][j - arr[i-1]] || t[i-1][j] );
                }
                else //exlude
                {  t[i][j]= t[i-1][j] ;   }

            }
        }





        //printing the matrix after solution

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }



        return t[n][C];
    }


}
