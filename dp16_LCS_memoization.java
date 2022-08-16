public class dp16_LCS_memoization {

    public  static  int t[][]=new int[1001][1001];

    public static int LCS(String x,String y, int n, int m)
    {
        // base cond
        if (n == 0 || m == 0)  return  0;

        //search in the stored results
        if ( t[n][m] != -1) {
            return t[n][m];
        }
        // choice diagram
        if ( x.charAt(n - 1) == y.charAt(m - 1) )
        {
            return t[n][m] = 1 + LCS(x, y, n - 1, m - 1);
            }
        else
        {   return t[n][m] = Math.max(LCS(x, y, n - 1, m), LCS(x, y, n, m - 1));
            }

    }


    public static void main(String[] args) {



        System.out.println("The memoization approch is just store the results of the recusive subcalls  : ");

        String x="abce";
        String y="ecae";

        int n=x.length();
        int m=y.length();

        // Work of the memset fucntion :
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                t[i][j]=-1;
            }
        }


        int lcs_lenght=LCS(x,y,n,m);

        System.out.println("Hence , we are the done with memoized approch : ");
        System.out.println("LCS lenght is " + lcs_lenght);

        System.out.println("Also print the   status of the matrix  ");

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
