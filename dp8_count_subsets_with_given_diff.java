public class dp8_count_subsets_with_given_diff {

    public  static  int[][] t= new int[1001][1001];          //global array declared.

    public static void main(String[] args) {

        System.out.println("Finding the  count subsets with given difference");

        int n=4;
        int arr[]={1,1,2,3};
        int diff=1;

        //simple equation :  s1 -s2 = diff             and we already know s1 + s2 = range
                   //        s1+ s2= range
                  // on solving equation , s1= (range + diff )/ 2  ;

        //basically we need to find the count of the s1 sum possible

        int sum=0;
        for( int i=0;i<n;i++) sum+=arr[i];
  int temp_sum= (diff+sum)/2;
     int ans= find_count_of_subsets(arr,temp_sum,n);

        System.out.println("Hence the count os subsets with given difference is : " + ans) ;
    }

    public static  int find_count_of_subsets(int arr[], int C , int  n)
    {
         //basic condition of initialization \
        for(int i=0;i< n+1;i++)
        {
            for(int j=0; j<C+1;j++)
            {
                if(i==0 ) t[i][j]=0;
                if(j==0)  t[i][j]=1;
            }
        }

  // choice diagram is changed to the loops condition.
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<C+1;j++)
            {
                if(arr[i-1] <= j  )
                {
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else
                    t[i][j]=t[i-1][j];
            }
        }





// printing the 2 d MAtrix formed.
        for(int i=0;i< n+1;i++)
        {
            for(int j=0; j<C+1;j++)
            {
                System.out.print(t[i][j]+ " ");
            }
            System.out.println();
        }

return t[n][C];

    }


}

