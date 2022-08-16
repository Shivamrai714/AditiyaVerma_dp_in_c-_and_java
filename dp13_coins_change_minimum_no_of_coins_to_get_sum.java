public class dp13_coins_change_minimum_no_of_coins_to_get_sum {

    public static  int t[][]= new int[1001][1001];

    public static void main(String[] args) {
        System.out.println("here we need to find the minimum no of coins required to get the sum as required ");
        //VERY IMP QUES :
        System.out.println("It requies 2 time initialization , base condition + the 2 row additionaly ");

         int n=3;
         int coins[]={25,10,5};
         int sum=30;

         int C=sum;          //used to simple address the variable.

        System.out.println("He we are asked about the no of coins to get sum, if no cond is adjusted we assume we need Infinity coins to get that required sum");


        // base condition :
        for(int i=0;i<n+1;i++)
        {
            for(int j=1;j<C+1 ;j++)      // statring j=1 , as i==0 and j==0 is except , as no elements so
            {
                if(i==0 )
                {                     // i==0 means no elements in the array , to get any sum 0 1 2 etc is not possible practically ,hence mathematically its infinite .
                    t[i][j]=Integer.MAX_VALUE-1;
                }
                if(j==0)
                {
                    t[i][j]=0;                       // j==0 means sum is 0 no matter any no of elements present in the array , empty set {} always as sum 0 , so coins needed is 0 for empty set
                }
            }
        }
// initialization of the 2 row

        // to fill the content when i=1, 1 element in array
        for(int j=1;j<C+1;j++)
        {
            if(j%coins[0]==0)     t[1][j]= j/coins[0];
            else if(j%coins[0]!=0)  t[1][j]=Integer.MAX_VALUE-1;                   // its take 1 less as to avoid overflow of value from integer when 1 is added to the INT_MAX,,
        }

// now normal loops filling

for(int i=2;i<n+1;i++)
{
    for(int j=1;j<C+1;j++)
    {
        if(coins[i-1]<=j)
        {   //included and re-available                       //excluded
                         t[i][j]= Math.min (   1 +  t[i][j-coins[i-1]]  ,        t[i-1][j]  ) ;         // 1+ as 1 coin is now included now.
        }
        else {     //excluded
            t[i][j]=t[i-1][j];
        }

    }
}


        System.out.println("Hence the minimum no of coins are required are  : " +  t[n][C] );

//status of matrix after the minimum no of coins operation
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
