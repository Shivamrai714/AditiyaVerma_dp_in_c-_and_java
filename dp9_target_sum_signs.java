public class dp9_target_sum_signs {

    public  static int[][] t= new int[1001][1000];

    public static void main(String[] args) {
                 // SAME PROBLEM AS THE COUNT OF subsetS WITH GIVEN DIFFERENCE ( here  SUM )
        int n=4;
        int arr[]={1,1,2,3};
        int sum=1;

        System.out.println(" The task is to adjust the + and - sign is elements such tha when net sum is taken it comes as given sum. ");

      // basically the idea is to group the + sign elements and - sign elemts ,
        //then this questionn is same as    { sum of + ele sub set } - {sum of all -ve ele of sub set } = difference (sum) given.

        // hence equation is s1- s2= diff given
                           //s1+ s2 = range

      // To find the count of target sum : search if sum_temp is present how many times. sum_temp=  ( diff + range  ) /2

        int range=0; for(int i=0;i<n;i++) range+=arr[i];

                     int temp_sum= (sum+ range)/2;

                     int ans=find_counts_subset_sum_possible(arr, temp_sum,n);

        System.out.println("Hence the target sum is achieved in  follwing ways  : "+ ans);

    }


    public  static  int find_counts_subset_sum_possible(int arr[] ,int C, int n)
    {
        //base condition is of initialization is  :
         for(int i=0;i<n+1;i++)
         {
             for(int j=0;j<C+1;j++)
             {
                 if(i==0 ) t[i][j]=0;
                 if(j==0) t[i][j]=1;
             }
         }

         // choice diagram is changed to loops conditions :

        for(int i=1;i<n+1; i++)
        {
            for(int j=1; j< C+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    t[i][j]= t[i-1][j- arr[i-1]] +t[i-1][j] ;
                }
                else
                t[i][j]= t[i-1][j];
               }
        }

        System.out.println("Also displaying the matrix formed ..");
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
