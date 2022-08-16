public class dp14_LCS_longest_common_subsequence_tabulation {

    // This is bottom up - dynamic programming approch to find the LCS ( tabulation approch )

    // dp 16  : Tabulataion is basically omitting the recursive call and completely storing the data in table format to answer major problems from the previous solved problems.
   // We need tablulation dp , so that the stack overflowe problem will not occur during the recursive calls of the version.


    public static  int t[][]= new int[1001][1001];
    public static  int LCS(String x, String y, int n,int m)
    {
          // initialization condition of base case      , ie if len of string in sub problems is 0 then LCS will be 0
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0 )
                t[i][j]=0;                // any of the string is empty then the LCS is ""
            }
        }
   //Now the choice diagram is converted to

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(x.charAt(i-1)==y.charAt(j-1) )             //checking the char of both string , if equal then include in lcs lenght.
                    t[i][j]=1+ t[i-1][j-1];

                else t[i][j]= Math.max(t[i-1][j], t[i][j-1]);      // otherwise choose from the max leght of upper box and left box
            }
        }

return  t[n][m];
    }


    public static String reverseit(String temp)
    {
        // java does not have the inbuilt funtion for the reverse , so build this .

        char arr[]=temp.toCharArray();
        int n=arr.length;
        for(int i=0 , j=n-1  ;   i<j   ;  i++, j--   )
        {
            char var=arr[i];
            arr[i]=arr[j];
            arr[j]=  var;

        }
      String final_ans= String.valueOf(arr);

        //  System.out.println("...............   "+ final_ans+ "   .............   ");
            return final_ans;
    }

    public static void print_lcs(String x,String y,int n, int m)
    {
        // to print start from the last index of the t[][]
        int i=n; int j=m;
        String lcs_ans="";
        while(i>0 && j>0)
        {
            if(x.charAt(i-1)==y.charAt(j-1) )
            {
                lcs_ans+=x.charAt(i-1);
                i--; j--;
            }
            else {
                  //upper box
                if(t[i-1][j] >  t[i][j-1])
                {
                    i--;         //moving in direction of the greater value , no need to include this in final ans :as they are not in LCS
                }
                else if(t[i-1][j] <= t[i][j-1])
                    j--;
                 }

        }
       String lcs=reverseit(lcs_ans);

        System.out.println(lcs);
    }


    public static void main(String[] args) {

        System.out.println("  Printing the LCS  - longest common subsequence  ");

        String x="abcdef";
        String y="rsbaegf";

        int n=x.length();
        int m=y.length();

        int len_lcs=LCS(x,y,n,m);

        System.out.println("The length of LCS is  : "+ len_lcs );

        System.out.println("The LCS is : ") ;
        print_lcs(x,y,n,m);

        System.out.println("Printing the Matrix ");

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                System.out.print(" "+ t[i][j]);
            }
            System.out.println();
        }


    }

}
