public class dp21_no_of_deletion_insertion {

    public  static  int t[][]= new int[1001][1001];

    public  static  int LCS(String x , String y , int n, int m)
    {
        // base condition is converted to the initialization :

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0 ) t[i][j]=0;          //if any of the string is of len 0 then lcs of itswill be 0
            }
        }

        // choice diagram is converted to the Loops
        //We use the tabulation approch , as the stack size is limited , so its get sometimes filled during the recursive functions call at memoization and recursive methods.

       for(int i=1;i<n+1;i++)
       {
           for(int j=1;j<m+1;j++)
           {
                if(x.charAt(i-1)==y.charAt(j-1))
                {
                    t[i][j]=1+t[i-1][j-1] ;                   // its simply means that if a char is equal , then +1 and do the call on remainig elements, but in tablutain we are comming bottom up (smaller sol to larger sol ) , so add +1 to len of previous sub problem solve diagonaly back box.

                }
                else {

                    // move in direction which has max value out of two subcalls
                    t[i][j]=  Integer.max(t[i-1][j] , t[i][j-1]);


                }
           }
       }

        // at last we will have the LCS lenght in the last box
        return  t[n][m];
    }


    public static void main(String[] args) {
        System.out.println("here we need to convert the string x to string y : And find no of deletion and insertion required to do  SO  ");

        System.out.println("Basically the trick is to covert X ->  LCS  -> Y");



        String x="heap";
        String y="pea";

        int n=x.length();
        int m=y.length();

        int len_lcs=LCS(x,y,n,m);

        System.out.println("The LCS length is  "+ len_lcs);
        System.out.println("No of Deletions " + ( n - len_lcs ) );
        System.out.println("No of insertion " + (m-len_lcs)  );

        System.out.println("Conversion is :  " + x + " - > " + print_lcs(x,y,n,m) + " -> "+ y );

    }







    // just simply printing the LCS as will

    public static  String print_lcs(String x , String y, int n,int m )
    {
        String ans="";

        int i=n, j=m;
        while(i>0 && j>0)
        {
            // if the char of last index matches include it
            if(x.charAt(i-1)==y.charAt(j-1))
            {
                ans+=x.charAt(i-1);             // now move to diagonlly up
           i--; j--;
             }

            else {
                // move in direction of larger value without includeing char
            if(t[i-1][j] > t[i][j-1]) i--;   //move up box in matrix.,
            else j--;                 //move left box in matrix
            }


        }

         String fin_ans=reverseit(ans);
      // System.out.println("LCS is  :" + fin_ans);

        return  fin_ans;
    }

    public static  String reverseit(String temp)
    {
        char arr[]= temp.toCharArray();
        int n=arr.length;
        for(int i=0, j=n-1 ; i<j  ;   i++ , j-- )
        {
            char var = arr[i];
            arr[i]=arr[j];
            arr[j]=var;
        }
     return String.valueOf(arr);
    }


}
