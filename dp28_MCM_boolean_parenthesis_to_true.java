public class dp28_MCM_boolean_parenthesis_to_true {



    public static void main(String[] args) {

        System.out.println("Here we need to Find the no of ways to make the expression as true  ::   ");

        //Here we have operators like ^ , | ,&  Hence to find the no of ways to make the expression as true, we need to check when they give true
        // eg  ^ give true  , when one part is false and other is true; , vice versa  . and gives false whenn both are same T T , or F F

    //So at each recursive call we need to also calulate the case in childs when the expression becomes false, as it may become a condition for true in parent call.

String s="T|T&F^T";              // s="T|T&F^T" ans : 4  GFG   ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T and (T|((T&F)^T)).

        int n=s.length();

int no_of_ways_TRUE= solve(s,0,n-1,true);    // passed 1 as last parameter as we need to find the cases when true comes as final ans.

        System.out.println("No of ways to make it TRUE : " + no_of_ways_TRUE);



        ///////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////

        System.out.println("Now trying the optimization approch : But could not succedd ");



    }

    public static  int solve(String s, int i, int j , boolean var)
    {
        // base condition
      if(i>j) return 0;

      if(i==j)
      {
          //single ele present , check what we requrie , if true needed , we check val stored  at s[i] , if its 'T'  we return 1 otherwise 0;

         if(var==true)
         {
             if(s.charAt(i)=='T') return 1;
             else return  0;

         }
         if(var==false)   //if we need to find no of ways to get false in subcalls
         {
             if(s.charAt(i)=='F') return 1;       // inc the cnt for false ,otherwise return  0 ,
            else return  0;
         }

      }



      //Now loop over the various possiblity to check the boolen parentheses as true , by makiung the reucrsive calls


        int temp=0;      //no of ways



        // loops for the operator present, and make recursive calls on left and right part.
      for(int k=i+1; k<j ; k=k+2 )
      {
          // now true can be evaluated out of all possible reuslts of child  recursive calls

          int lT= solve( s, i,k-1 ,true);   //left part is from  i to k-1  , as k position is operator
          int lF= solve(s,i,k-1,false);
          int rT=solve(s,k+1,j,true);      //right child part is k+1 to j
          int rF=solve(s,k+1,j,false);

//Now evaluate how we can get true when s[k] is inform of different characters


//For each operator we need to calculate the true as well as false possible no of ways


if(s.charAt(k)=='|')
{
    if(var==true) {
        temp += (lT * rF) + (lF * rT) + (lT * rT);
    }

    if(var==false) {temp+= (rF*lF); }

}

if(s.charAt(k)=='&')
{
    if(var==true) {
     temp+=(lT*rT);
    }

    if(var==false) {
        temp+=  (lT * rF) + (lF * rT) + (lF * rF);
    }

}
if(s.charAt(k)=='^')
{
    if(var==true) {
        temp+=(lT*rF)+(lF*rT);
    }

    if(var==false) {
        temp+= (lT*rT)+(lF * rF);
    }

}
// after all the recursive call we have , ans no of times its evaluates as true
      }
return temp;
    }








    ///////////////////////////////////////////////////////////////////    ///////////////////////////////////////////////////////////////////    ///////////////////////////////////////////////////////////////////    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////








}
