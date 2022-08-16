public class dp17_LCS_print {

    public static  int t[][]=new int[1001][1001];

    ///**************************    printing the LCS

    public  static  void print_lcs(String x,String y, int n,int m)
    {
        int i=n; int j=m;
        String lcs_ans="";
        while( i>0 && j>0 ) {

            // include the common character and move diagonally up
            if (x.charAt(i - 1) == y.charAt(j - 1))
            {       lcs_ans += x.charAt(i - 1);
            i--; j--;
            }

            else {
                //else simply move to the greater val in the above box or left box of t[][]
                if(t[i-1][j]  > t[i][j-1])   // move upwards
                 { i--;}

                else {j--;}         //move leftwards
            }

        }
String lcs=reveseit(lcs_ans);
        System.out.println(lcs);

    }

    public  static  String reveseit(String str) {
        char arr[] = str.toCharArray();
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            var v = arr[i];
            arr[i] = arr[j];
            arr[j] = v;
        }
    return String.valueOf(arr);
    }

    public static int LCS(String x,String y, int n, int m )
    {
        // base condition of initialization
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                t[i][j]=0;
            }
        }
        // loops
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(x.charAt(i-1)==y.charAt(j-1))           // it they are equal , then we include the current char at the LCS
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]= Math.max(t[i-1][j] , t[i][j-1]);
            }
        }

        return t[n][m];            // this will be the max len of LCS
    }


    public static void main(String[] args) {

        System.out.println("Its just a repeat of the LCS with the tablulation : bottom up dp ");

        String x="abacd";
        String y="bdar";

        int n=x.length();
        int m=y.length();


        // Step 1 it to find the length of LCS and fill the table of the matrix :

        int lcs_len=LCS(x,y,n,m);
        System.out.println("The lenght of the LCS is  : " + lcs_len);

        System.out.println("Now Printing the LCS using tha Matrix   :::::  ");

         print_lcs(x,y,n,m);

        System.out.println("Status of the matrix after the LCS operation ::   ");

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                System.out.print(" "+t[i][j]);
            }
            System.out.println();
        }



    }

}
