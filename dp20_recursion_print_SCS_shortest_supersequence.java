public class dp20_recursion_print_SCS_shortest_supersequence {

    public static  int t[][]= new int [1001][1001];


    //THIS CONCEPT IS LEARNT FROM THE ARTICLE OF GFG , to print the SCS using recursion .

    public static void print_scs_memoization(String x, String y, int n, int m)
    {
     // Basically the idea is to start from the last of matrix and include the common char then move diagonally up. else
        // move in direction of smaller val, before that include the corr. char in final string.

        String final_scs="";
        int i=n, j=m;

        while(i>0 && j>0)
        {
            if(x.charAt(i-1)==y.charAt(j-1))
            {
                final_scs+=x.charAt(i-1);
                i--; j--;
            }
            //
            else {
                //upper box is smaller move here, but include the  left box char of X string
                if(t[i-1][j] < t[i][j-1] )
                {
                    final_scs+=x.charAt(i-1);
                    i--;
                }
                else {
                    final_scs+=y.charAt(j-1);
                    j--;                      //in this case we move to left,so include the  Y .charAt
                }

            }

        }


        // if any end is reached copy the remaining in the string.
        while(i>0)
        {
            final_scs+=x.charAt(i-1); i--;
        }
        while(j>0)
        {
            final_scs+=y.charAt(j-1); j--;
        }

        String ans=reverseit(final_scs);
        System.out.println("........... " +  ans + "................");


    }

    public  static String reverseit(String temp)
    {   char arr[]=temp.toCharArray();
        int n=arr.length;

        for(int i=0 , j=n-1 ;   i<j ;   i++ , j--)
        {
            char t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
        return String.valueOf(arr);
    }


    public  static  int SCS(String x,String y , int n, int m ) {
        // base condition is that if any of the string is empty , the supersequence will be another string of particular length

        if (n == 0) return m;
        if (m == 0) return n;

        // choice digram  , : we will include (+1) the char which is common , and move to remainng char  ,
        // and if not present the , we will include the current char (+1) , but shift to smaller/min of two recursive calls made to get SCS


        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return t[n][m] = 1 + SCS(x, y, n - 1, m - 1);
        }
        else
        {       return t[n][m] = 1 + Math.min(SCS(x,y,n-1,m), SCS(x,y,n,m-1));           // current cchar is added , as need to find supersequence
              }




    }



    public static void main(String[] args) {

        System.out.println(" Printing the Shorteset Common Supersequence ...  ");

        String x="AGGTAB";
        String y="GXTXAYB";
        int n=x.length();
        int m=y.length();

        System.out.println("Here  base cond are changed and we need to differently fill the matrix is selecing min len for SCS");

        // here we are writing the memozation version of the SCS

        int scs_len=SCS(x,y,n,m);
        System.out.println("THe ScS lenght is  : " + scs_len) ;


        System.out.println("THe shortest SCS is  ");
        print_scs_memoization(x,y,n,m);

        //
        System.out.println("Printing the status of matrix after the SCS ");
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }




    }

}
