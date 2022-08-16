public class dp18_LCSS_longest_common_substring {

    public  static  int t[][]= new int[1001][1001];

    public  static  int max_lenght=0,  index=0;
    public  static  int LCSS(String x,String y, int n, int m)
    {
        //base condition : converted to initailization :
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0 )  t[i][j]=0 ;           // any of sub problems if have len as 0 , then corresponding LCSS is 0
            }
        }


        // now the loops are replacing the choice diagram
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                //
                if(   x.charAt(i-1) == y.charAt(j-1)   )
                {
                     t[i][j]= 1+ t[i-1][j-1];

                     //also need to store the max len found and till which index

                    if(t[i][j]>max_lenght)  {max_lenght=t[i][j] ;  index=i; }

                }
                else
                {                         //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                       t[i][j]=0;           // if the char do not match then LCSS will be of 0 len for them .
                }



            }
        }
        return  max_lenght;
    }

  public static  void print_lcss(String x, String y, int n,int m)
  {
      // we have the index at which the longest common substring stopped
      // we have len of LCSS
      int time=max_lenght;
      int ind=index;
      String ans="";
      while(time-- >0 )
      {
          ind--;             //char is actually at 1 less pos in string
          ans+=x.charAt(ind);
      }
String fin_ans=reverseit(ans);
      System.out.println(fin_ans);

  }

public static String reverseit(String temp)
{     int n=temp.length();
    char arr[]= temp.toCharArray();
    for(int i=0,j=n-1;   i<j ;  i++ , j--)
    {
        char var=arr[i];
        arr[i]=arr[j];
        arr[j]=var;


    }

    return String.valueOf(arr);
}








    public static void main(String[] args) {

        System.out.println("This is shivam rai  : ");
        System.out.println("Printing the Longest Common Substring (continous characters)");

        String x="ab";
        String y="babvb";
        int n=x.length(); int m=y.length();

        int len_LCSS = LCSS(x,y,n,m);
        System.out.println("The length of Longest Common Substring is  : " + len_LCSS);

        System.out.println("Now printing the LCSS : ");
         print_lcss(x,y,n,m);
        System.out.println();

        // printing the status of the matrix after the loops  :
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++) {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }

    }













}
