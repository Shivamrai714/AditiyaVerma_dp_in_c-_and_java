public class dp7_minimum_subset_sum_difference {



//VERY IMPORTANT AND LITTLE TRICKY QUESTION : need to find the range , and eliminate possibilities.

    //Task is to minimise the difference between sums of any two subsets .
    //  eg    {1,6,5} - {11} = 1 best answer

    // range = sum of elements
    // let s1 is smaller in sum , s2 = range-s1 ;
    //we need to minimize :    s2-s1 = mini       , or put s2 value
    //                          (range-s1) -s1 =mini
    //                          range -2(s1) = mini
    // now we are left with putting the values of s1 , and minimizing expression .
    //IMP NOTES , larger the value of s1 , expressioin will be much minimized.

    // The s1 can have the sum  max of range/2 and min 0f 0 , but not all possible sum between them ,
    // hence we need to go through the subset sum matrix last row with all ele , loop form range/2 to 0  and need to check whether sums (range/2 ,. . . , 0 )  are T or not.

    //we will break the loop at first true(T) found: as we move from range/2 to 0 , so maxumum the valid sum, minimum the value of the whole expression.











    public static boolean[][] t= new boolean[1001][1001];

    public static void main(String[] args) {
        System.out.println("Task is to find the minimum subset sum differences  ");

         int n=4;
         int []arr={1,6,11,5};

         int range=0;
         for(int i=0;i<n;i++){ range+=arr[i] ; }

         int mini=find_min_subset_sum_diff(arr,range,n);

        System.out.println("The minimum subset sum diff is  : : " + mini);
    }

    public static int find_min_subset_sum_diff(int arr[],int C, int n)
    {
        //base cond
        for(int i=0;i<n+1;i++)
        {for(int j=0;j<C+1;j++)
        {if(i==0)  t[i][j]=false;
        if(j==0) t[i][j]=true;
        }
        }
        //choice diagram
        for(int i=1;i<n+1;i++)
        {
            for (int j = 1; j < C + 1; j++)
            {
              if(arr[i-1] <= j)
              {
                  t[i][j]=(t[i-1][j -arr[i-1] ] || t[i-1][j]);
              }
              else
                  t[i][j]=t[i-1][j];
            }
        }

        //display the formed matrix
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
           {
               System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }

        //Now working on to minimize the expression (range- 2*s1) , by finding max valid val of s1.
        int k;
        for(k=C/2;k>=0 ;k--)
        {
            if(t[n][k] == true) {}
        }

        //The k sum is valid for s1 , hence max the s1 minimized the expression

        return C-2*(k);

    }


}
