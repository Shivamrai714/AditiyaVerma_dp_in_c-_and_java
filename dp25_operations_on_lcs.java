public class dp25_operations_on_lcs {

    public  static  int t[][]=new int[1001][1001];

    public static  int LCS(String x,String y, int n,int m)
    {
        //initalization
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0 ) t[i][j]=0;
            }
        }

        // loops condition
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                {
                    t[i][j]=1+t[i-1][j-1];
                }
                else
                {
                    t[i][j]= Math.max(t[i-1][j] , t[i][j-1] );
                }
            }
        }


        return  t[n][m];
    }


    public static void main(String[] args) {

        System.out.println("OPERATION 1 : Check  if Given string x is present in String y");
        System.out.println("The solution is : just find the lcs of both str, and check if lcs is equal to smaller string or not.  ");

        String x="ababdes";
        String y="bab";

        int n=x.length() ; int m=y.length();
        int len_LCS=LCS(x,y,n,m);
        String lcs= find_lcs(x,y,n,m);

        System.out.println(lcs);
        if(lcs.equalsIgnoreCase(y)) System.out.println("Yes present ");
        else System.out.println("Not present ");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////



        System.out.println("OPERATION 2 :No of insertion to convert to pallindromic subsequence");

  //String xx="aebcbda";           // either add the  e and d respectively to make pallindrome , or its same as removing /deleting the the two char :

// Its is jsut the same ques as the no of deletion need to make the pallindromic substring.,
        System.out.println("Done");
    }

    public  static String   find_lcs(String x,String y, int n,int m)
    {
        int i=n, j=m;
        String finali="";
        while(i>0 && j>0)
        {
            if(x.charAt(i-1)==y.charAt(j-1))
            {
                finali+=x.charAt(i-1);
                i--; j--;
            }

            else {
                if(t[i-1][j] > t[i][j-1])  i--;
                else j--;
            }
        }

        String lcs_ans=reverseit(finali);

        return lcs_ans;


    }


    public  static  String reverseit(String temp)
    {
        char arr[]=temp.toCharArray();
        int n=arr.length;

        for(int i=0 ,j=n-1 ; i<j ; i++ ,j--)
        {
            char v=arr[i];
            arr[i]=arr[j];
            arr[j]=v;
        }

        return String.valueOf(arr);
    }

}
