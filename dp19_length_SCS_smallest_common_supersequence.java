public class dp19_length_SCS_smallest_common_supersequence {
    public static  int t[][]= new int[1001][1001];

    public static  int LCS(String x,String y , int n,int m)
    {
        // base condition
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0 )  t[i][j]=0;
            }
        }

        // loops - instead of the recursive calls
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(x.charAt(i-1)==y.charAt(j-1))
                    t[i][j]=1+t[i-1][j-1];
                else
                {
                    t[i][j]= Math.max(t[i-1][j] , t[i][j-1]) ;
                }
            }

        }

return t[n][m];
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


  public static void   print_scs(String x,String y,int n, int m)
    {
        // Here we the matrxi of LCS using it to print  the SCS
        int i=n, j=m;
String  final_string="";

        while(i>0 && j>0)
        {
            //  we will move in direction of the maxiumum value.

            if(x.charAt(i-1) == y.charAt(j-1))
            {
                final_string+=x.charAt(i-1); i--; j--;
            }
            else {
                // if the upper box is greter ,move its side
                if(t[i-1][j]   > t[i][j-1])
                {
                    final_string+= x.charAt(i-1);
                    i--;
                }
                else
                {
                    final_string+=y.charAt(j-1);
                  j--;
                }

            }
        }
        // if some char left in any string
        while(i>0)
        {
            final_string+=x.charAt(i-1);
            i--;
        }

        while(j>0)
        {
            final_string+=y.charAt(j-1);
            j--;
        }

        String ans=reverseit(final_string);
        System.out.println("The SCS is : ");                //........... AGGXTXAYB................
      //  print_scs(x,y,n,m);

        System.out.println("------------"+ans+"---------");

    }


    public static void main(String[] args) {

        System.out.println("Its simple just we need to minimine the final len of o/p string    ::  ");
        System.out.println("By looking the final combination, we noticied that the LCS part is present twice , So we can remove the LCS legth , so smallest super sequence will be formed.");

        String x="AGGTAB";
        String y="GXTXAYB";
        int n=x.length();
        int m=y.length();

        int len_LCS=LCS(x,y,n,m);

        System.out.println("The LCS came out to be "+ len_LCS);       //GTAB
        System.out.println("The len of smallest super sequence is : "+   (n+m-len_LCS)  );

        System.out.println("print the SCS supersequence: ");
        print_scs(x,y,n,m);


    }
}
