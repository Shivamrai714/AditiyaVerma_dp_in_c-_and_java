public class dp23_find_deletion_to_make_LPS {
    public static int t[][]= new int[1001][1001];

    public static void main(String[] args) {

        System.out.println("Here we need to find the minimum no of deletion to make the LPS longest pallindormic substring");
        System.out.println("Using concept, as we need minimum deletion, ie len of LP Sub-string should be maximum : ");
        String x="agbcba";               // op : abcba      1 deletion

        String y=reverseit(x);

        int n=x.length(); int m=y.length();

        int LPS_length=LCS(x,y,n,m);

        System.out.println("NO OF DELETIONS ARE  : "+ (n-LPS_length)   );

        System.out.println("The lenght of the  LPS  is  : " + LPS_length);
        System.out.print("The LPS is   : ");
        print_lcs(x,y,n,m);

    }

    // just the code of the LCS using the tablulation dp
    public static int LCS(String x, String  y, int n,int m)
    {
        //initialization
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0) t[i][j]=0;
            }
        }

        // base condition
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                // check same char
                if(x.charAt(i-1)==y.charAt(j-1) )
                {
                    t[i][j]=1+ t[i-1][j-1];
                }
                // if not same char then , search for other sub call by takiung the max from them.
                else
                {
                    t[i][j]= Math.max( t[i-1][j] , t[i][j-1] );
                }

            }
        }



        return t[n][m];
    }



    // revese function :
    public  static  String reverseit(String temp)
    {
        char arr[]=temp.toCharArray();
        int n=temp.length();

        for(int i=0, j=n-1 ; i<j ; i++, j--)
        {
            int var = arr[i];
            arr[i]=arr[j];
            arr[j]= (char) var;
        }
        return  String.valueOf(arr);
    }


    public static void print_lcs(String x, String y, int n, int m)
    {
        String ans="";
        int i=n, j=m;
        while(i>0 && j>0)
        {
            // if char matches include it in ans , and move diagonally backward in the string
            if(x.charAt(i-1)==y.charAt(j-1))
            {
                ans+=x.charAt(i-1);
                i--; j--;
            }
            else {
                //move in diarection of the larger value
                if( t[i-1][j] > t[i][j-1]  ) i--;
                else  j--;

            }


        }
        String fin_ans=reverseit(ans);

        System.out.println(fin_ans);

    }






}


