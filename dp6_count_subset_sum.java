public class dp6_count_subset_sum {

    public static int[][] t= new int[1001][1001];


    public static void main(String[] args) {

        System.out.println("Task is to count subset present with given sum ");

        int n=6;
        int sum=10;
        int []arr= {2,3,5,6,8,10};

        int count= find_subset_sum(arr,sum,n);

        System.out.println("The count of subset with given sum --> "+ count);



    }
    public  static  int find_subset_sum(int arr[],int sum,int n)
    {
        int C=sum;                 //just taken to refer to genral structure of knapsack priblem
        //base condition is changed to initialization of the dp

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                if(i==0) t[i][j]=0;    //no of ele in []=0 , so no sum is possible hence count=0;
                if(j==0) t[i][j]=1;   // when 0 sum is required and any no of ele present , yes possible take {empty set } ,hence cnt=1;
            }

        }

        // choice diagram is changed to the for loops to fill matrix

     for(int i=1;i<n+1;i++)
     {
         for(int j=1;j<C+1;j++)
         {
             if(arr[i-1] <= j)                                          // if current ele is less than the capacity we have option ot incude or exvclde it
             {             //include it             //exlude it
                 t[i][j]= t[i-1][ j -arr[i-1] ] + t[i-1][j] ;
             }
             else             //exclude it , wt grater then capapcity to hold.
                 t[i][j]=t[i-1][j];
         }
     }

     //also printing the matrix of subset sum  generated
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
