public class dp10_unbound_knapsack {

    public static  int t[][]= new int[1001][1001];

    public static void main(String[] args) {
        System.out.println("This is Unbound knapsack , ie element can be chosen more than one times");

        //basically when an item is rejected then its neglected, otherwise multiple times selections are availble for the given item.

         int n=4;
         int wt[]={1,3,4,5};
         int val[]={10,40,50,70};
         int C=8;                //capacity of kanpsack

        //ans will be 110

        // initialization will be same as in knapsack

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                if(i==0 || j==0)
                    t[i][j]=0;    //i==0 means no elements in array , so no profit and j==0 means the capacity of kanpsack is 0 so not profit here also.
            }
        }

        // now condition of the loops
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<C+1;j++)
            {
                if(wt[i-1] <= j)
                {
                    // include it and can again be available , t[i] not t[i-1]           //exclude it
                   t[i][j]=  Math.max( val[i-1] + t[i][ j- wt[i-1]]          ,                   t[i-1][j]  );
                }
                else t[i][j]= t[i-1][j];      //excluded, so element is processed, t[i-1]



            }
        }


        System.out.println("The maximum profit available is : " + t[n][C] );


        // Status of final matrix is
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<C+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }


    }


}
