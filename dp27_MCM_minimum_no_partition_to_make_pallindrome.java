public class dp27_MCM_minimum_no_partition_to_make_pallindrome {
    public static void main(String[] args) {

        System.out.println("Here we need to partition the string , and find the min no partition such that all subparts are pallindrome");


        String x="madamnitikmam";      // ans: madam | n | iti | k | mam   4 partitions
int n=x.length();

 int min_partition= solve(x,0,n-1) ;          // solve( i , j )  step 1 range of i to j
        System.out.println("The minimum partition to make it as pallindromic "+ min_partition);

        //////////////////////////////////////////////

        //Now the Memoization / storing the results in the matrix
        for(int i=0;i<1001;i++)
        {for(int j=0;j<1001;j++ )  {t[i][j]=-1; } }

  int min_memoized=solve_memoized(x,0,n-1);
        System.out.println("After memoization parition are same : "+ min_memoized);


    }

public  static int solve(String x, int i, int j)
{
    //base condition :
    if(i>=j) return 0;            // i==j means single ele, which itself if pallindromic , hence 0 partition needed.

    if(ispallindrome(x,i,j))
    {return  0 ;}

    //Now loop though the possible way to partition the string

    int mini=Integer.MAX_VALUE;

    for(int k=i;k<j;k++)       // k from i(0)  to k<j  ,as call need to made to solve(k+1,j)
    {

        int temp_ans= 1+ solve(x, i,k) + solve(x, k+1, j) ;

         mini=Math.min(mini,temp_ans);

    }

return   mini;
}

public static boolean ispallindrome(String x, int a, int b)
{
    for(int i=a, j=b ; i<j ; i++, j-- )
    {
        if(x.charAt(i)!=x.charAt(j))  return false;
    }
    return true;
}

public static  int t[][]= new int[1001][1001];

public static int solve_memoized(String x, int i,int j)
{
    // base condition
    if(i==j)  return 0;
    if(ispallindrome(x,i,j)) return 0;

    //check in storage
    if(t[i][j]!=-1) return t[i][j];

    // calculate the ans and store them for the future use.

    int mini_par=Integer.MAX_VALUE;

    for(int k=i; k< j ;k++)
    {
        // omit the internal recursive calls also
        int left,right;

        if(t[i][k]!=-1) { left=t[i][k]; }     else {   left= solve_memoized(x,i,k) ;   t[i][k]= left; }
        if(t[k+1][j]!=-1) {right=t[k+1][j];}  else {right= solve_memoized(x,k+1,j) ;      t[k+1][j]=right;  }


        int temp_ans=1+ left+ right;         // +1 for current partition ,and add partition form the internal left and right recursive calls.

        //store the min partions from all possible chekcing for k positions
        mini_par=Math.min(mini_par,temp_ans);

    }

    return t[i][j]=mini_par;
}




//end of the class.
}
