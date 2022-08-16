public class dp30_MCM_egg_dropping_find_worst_case_critical_floor {

    public static int t[][]=new int[1001][1001];

    public static void main(String[] args) {
        System.out.println("Here we need to find the minimum no of attempts required to find the critical floor in worst case .");

     // intialize t with -1
        for(int i=0;i<1001;i++){for(int j=0;j<1001;j++) { t[i][j]=-1; }  }

        int egg=2;
        int floor=10;              //Answer when e, f =>  3 ,5  op:3          // 2 , 10    o/p: 4

        int ans=solve(egg,floor);
        System.out.println("Minimun no of attempts to find the critial floor in worst intrnal cases possible :  " + ans);
         int ans_mem=solve_memoized(egg,floor);
        System.out.println("Memeoized answer  "+ ans_mem);

    }

    public static  int solve(int e , int f)
    {
        // base condition :
        // base condition : when floor is 1 or 0 , then attemts will be equal floor (1)
         // when 1 egg is given , then need to check it from the very first floor and keep on checking till we reach critical floor, hence  answer is floor itself.

        if(e==1  || f==0 || f==1 )  return f;           // when 1 egg is given we need to try all floors from base till f floors to fing it.


        //Now we will try to break egg from every possible pos of floor and recursiely finding the minimum attempts using the eggs available.

        // to avoid the internal recursive call we store the val in left , right  and save value in matrix



        int min_attempt=Integer.MAX_VALUE;

        for(int k=1;k<=f;k++)              // now we try from all floors and find the worst case possibility of critcal floor in recursive calls (ie max(upper, down ) calls )
        {
                                       // lower half   // upper half
            int temp_ans= 1 + Math.max(  solve(e-1 , k-1)  , solve( e, f-k)) ;                   //+1 for current attempt , in recursive call in k floor is not critical then two calls internally
                                                     // 1 when the egg broken at k , so lower call on k-1 floors , and egg no is e-1
                                                     //2 when egg is still not broken,  so upper call on f-k floor left , and egg no same e


             min_attempt=Math.min(min_attempt,temp_ans);
              //Now after trying from all possible position of k , we save the minimum attempts position of k , to find critical floor in worst case  (ie if upper recursive call has 4 floor to process and lower recursive call has 2 floor to process, so we go with upper recursive call , and  ** Not sure also in it preferrable the case when top floor is critical one )
        }




return  min_attempt;
    }


    public static int solve_memoized(int e ,int f )
    {
         int mini=Integer.MAX_VALUE;
        if(e==1  || f==0 || f==1 )  return f;

        // check memoization : present in matrix or not.
        if(t[e][f] != -1 ) return t[e][f];

        int high,low;

        for(int k=1;k<=f ; k++)
        {
        // lower call check in matrix
        if(t[e-1][k-1] !=-1 ) { low = t[e-1][k-1];}
        else {low=solve(e-1,k-1) ;      t[e-1][k-1]=low;  }
        // check upper
        if(t[e][f-k]!=-1){ high=t[e][f-k];}
        else { high=solve(e, f-k);  t[e][f-k]=high; }


        int temp_ans=  1+ Math.max(low,high);

        mini=Math.min(mini,temp_ans);

        }


        return t[e][f]= mini;
    }




}
