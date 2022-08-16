public class dp5_equal_subset_sum_partition {

    public  static boolean[][] t= new boolean[1001][1001];

    public static void main(String[] args) {

        System.out.println("Checking equal subset sum partition is possible or not. ");

        int n=4;
        int arr[]={1,5,11,5};

        int sum=0;
        for(int i=0;i<n;i++)
        {sum+=arr[i];
        }

        boolean possible=check_subsetsum(arr,sum,n);

        System.out.println("Whether equal subset sum is possible to partitioned  --> " + possible);

    }

    public static boolean check_subsetsum(int arr[],int sum,int n)
    {
        //basic logic to check the sum is odd or not;
        if(sum%2!=0 ) return  false;                 //odd cant be partitioned equally.

        //next logic is to check half sum is present form subset ele, and automatically remaining ele will for another subset of size sum/2
        //search sum/2 subset is possible
        return check_halfsubsetsum(arr, sum/2 , n);

    }

    public static boolean check_halfsubsetsum(int arr[], int C ,int n)
    {
        //base cond --> initailization condition :
        for(int i=0;i<n+1;i++)
        {
            for(int j=0; j< C+1 ;j++)
            {
                if(i==0 ) t[i][j]=false;
                if(j==0) t[i][j]=true;
            }
        }

        // choice condition is changed to loops :
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<C+1;j++)
            {
                if(arr[i-1] <= j)
                {               //include it             //exclude it
                    t[i][j]= ( t[i-1][j -arr[i-1]] || t[i-1][j]  );
                }
                else    //exclude it
                    t[i][j]= t[i-1][j];

            }
        }

        //printing the full matrix foremed . to check the half subset sum is present or not.

        for(int i=0;i<n+1;i++)
        {
            for(int j=0; j< C+1 ;j++)
            {
               // System.out.print(t[i][j]+ " ");
            }
            System.out.println();
        }


   return t[n][C];               //return the last value of matrix
    }



}
