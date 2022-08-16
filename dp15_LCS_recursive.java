public class dp15_LCS_recursive {

    public static  int t[][]= new int[1001][1001];

    public static  int LCS(String x,String y, int n, int m)
    {
        // base condition :
        if(n==0 || m==0 )                             //   if any of the string is 0 , then the LCS will be 0
            return 0;

        //check the common char of two strings from the last.
        if(x.charAt(n-1)==y.charAt(m-1))              // if the char matches then add it to len , and proceed recursively.
            return 1+ LCS(x,y,n-1,m-1) ;         //now we will search for the rest n-1 elements
        else
            return Math.max(     LCS(x,y,n-1,m  )   ,  LCS(x,y,n,m-1)      )        ;     //choose from shifting 1 char of stirng bacward at one time, and another next time, and takes the maximum form their results.


    }

    public static void main(String[] args) {

        System.out.println(" Hence this is Recursive approch to find the LCS ");

        String x="abbcde";
        String y="arbdtre";
        //ans will be  4 : abde

        int n=x.length();
        int m=y.length();
        int len_LCS=LCS(x,y,n,m);

        System.out.println("The lenght of the LCS is : " + len_LCS);
    }
}
