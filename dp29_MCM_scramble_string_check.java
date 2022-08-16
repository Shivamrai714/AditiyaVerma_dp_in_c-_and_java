import java.util.HashMap;

public class dp29_MCM_scramble_string_check {

   public static   HashMap<String,Boolean> mp= new HashMap<String, Boolean>();

    public static void main(String[] args) {

        System.out.println("Here we are going to check if given two strings are scramble or not , it string obtained by swapping child other than the leaf nodes");

        //Scramble Strings  :  To scramble the string, we may choose any non-leaf node and swap its two children.
          // eg  gr eat  -->   rg eat      , swapped  g,r childs of gr
               //             -->   rg tae
                 //function to check the scrable strings.

   //   String  a="abcde";   String b="caebd";            : answer : not scramble

        String  a="figma";   String b="gfmia";

        // checking edge conditions
        if(a.length()!=b.length()  || a.length()==0 || b.length()==0 ) System.out.println("Not Scramble");

        boolean check_scramble= solve(a,b);

        if(check_scramble==true)
        System.out.println("yes Scramble");
        else System.out.println("Not scramble strings ");

        //////////////////////////////////////////////////

        //MEMOIZATION APPROCH :
        boolean check_sc_mem=solve_memoized(a,b);
        if(check_scramble==true)
            System.out.println("yes Scramble");
        else System.out.println("Not scramble strings ");


    }

   public static boolean solve(String a , String b)
    {
        boolean chk=false;

        // base condition
        if(a.compareTo(b)==0) return true;  // yes scramble
        if(a.length()<=1 || b.length()<=1) return false;       // single char is left , and not equal so false, not scramble.



        // Now try to partition the a and b at each possible k form 1 to n-1 , such that left and right child are non empty , and check the two cases to be scramble stirng
        int n=a.length();

        for(int k=1;k<=n-1;k++)
        {
             //case 1 when swapping occurs .
            // chk if left substring is equal to right substring of b  , and right of a with left of a


            // case 2 when no swapping
            // chk if left substring of a is equal to left of b , and vice versa.

            //substring funn in java  (start index, end index   )    ...... in C++ t.substr(start index, length )

           if(      //swapped child
                   // left part of a                 //right part of b                                           // right part of a                 // left part of b
                           (
                                   (  solve(    a.substring(0,0+k)   ,       b.substring( n-k, n-k+k  )     ) == true   )    &&   ( solve(a.substring( k , k+n-k ),b.substring(0,0+n-k) ) ==true)
                           )
                           ||
                           (    //not swapped           //left of a       //left of b                                             //right of a           //right of b string
                                   ( solve( a.substring(0,0+k) , b.substring(0,0+k) ) ==true  )  &&   (  solve( a.substring(k, k+ n-k )  , b.substring(k, k+n-k) )   ==true )
                           )
           )
           {
              return true;
           }


        }



        return chk;
    }





    public static boolean solve_memoized(String a, String b)
    {
        boolean chk=false;

        //base coses
        if(a.compareTo(b)==0)  return true;
        if(a.length()<=1 || b.length()<=1) return false;

        // check  in map for the particular key
        String key=a+" "+b;
        if(mp.containsKey(key)) return mp.get(key);



        // check for all k
        int n=a.length();
        for( int k=1;k<=n-1 ;k++)
        {
                    if(
                            (  (solve(a.substring(0,0+k) , b.substring(n-k,n-k+k))==true) && ( solve(a.substring(k,k+n-k),b.substring( 0,0+n-k))==true )
                            )
                            ||
                            (  (solve(a.substring(0,0+k),b.substring(0,0+k) ) ==true)  &&  ( solve(a.substring(k,k+n-k) , b.substring(k,k+n-k))==true )
                            )
                      )
            {
                return true;           // if child are swapped or not swapped then they are scrample , otherwise  any other case is not scramlbe
            }
        }


    mp.put(key,chk);
        return chk;         // false in other cases.
    }




}
