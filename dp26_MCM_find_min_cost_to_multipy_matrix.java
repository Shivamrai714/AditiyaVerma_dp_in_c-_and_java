import java.util.Arrays;

public class dp26_MCM_find_min_cost_to_multipy_matrix {
    /*
int arr[]={40,20,30,10,30};
int n=sizeof(arr)/sizeof(arr[0]);

// eg    matrices are A= 40 X 20 , B= 20 X 30 , C= 30 X 10 , D= 10 X 30
// here minimum cost will come when :  (A(BC))D = ie 26000 will be ans.
// The cost if defined as
   //       A = 40 X 20  ,      B=20 X 30
     //cost :           40 * 20 * 30


 //STEPS TO BE followed to solve MCM problem.

  // 1. search for the pos of i and j    , so that it wont go out of the range. ans make call to recursive function ,with range of i to j
  // 2. find base condition , where the recursion end .    find smallest valid input/ smallest invalid input. , here when only  1 ele let return 0 as its not valid dimension of any  Matrix
  // 3. Now use k loops to break string at various pos
              // find the index of loops of k   k=i , k<j so that call be made to solve(ar,i ,k )  & solve(ar, k+1 ,j)
  //4. Now at each recursion call find the temp and , and then final answer.


    * */












    public static void main(String[] args) {
        System.out.println("Matrix Chain Multiplication Problem : ");

        //  {40,20,30,10,30};  // answer : 26000  // eg    matrices are A= 40 X 20 , B= 20 X 30 , C= 30 X 10 , D= 10 X 30   (A(BC))D = ie 26000 will be ans.

        int arr[]= {10, 20, 30, 40, 30};         // (((AB)C)D)
        int  n=arr.length;

        int min_cost=MCM(arr, 1 , n-1 );        //MCM (  i , j)   i=1 start with matrix dimen :  as 40 X 20  , a[0] and a[1] , so start from 1 and till n-1

        System.out.println("The minimum cost to multiply  all the matrices is   : " + min_cost);


        System.out.println("The Memoization version helps in store the results and avoid the unnecessary recursive calls.");
         // prefill the 2D matrix with -1 sum
        for(int i=0;i<1001;i++) {for(int j=0;j<1001;j++) {t[i][j]=-1;}}

        int min_memoized=MCM_memoization(arr,1,n-1);
        System.out.println("Answer from MCM _ memoization is : " + min_memoized);
    }

    // Approch 1:  Recursive
   public static int MCM(int arr[], int i  , int j )
    {
        int mini=Integer.MAX_VALUE;
        // Now we will run the loop of k to try the partition on all possible position :

        //base condition
        if(i >= j) return 0;            // not a valid dimension

        // try to put brackets over all position , to multiply matrices differently and obtain the minimum cost sol
        for(int k=i; k<j;k++)
        {                  // solve left part of k   // solve right part         // cost of mutilpy the current two matrices after the recusive calls
        int temp_ans=           MCM(arr, i ,k )    +   MCM(arr , k+1, j ) +        (arr[i-1]*arr[k]*arr[j]);

        if(temp_ans<mini)
            mini=temp_ans;

        }

return mini;
    }


// Approch 1:  Memoized

    public static int t[][]= new int[1001][1001];

    public static int MCM_memoization(int arr[], int i, int j)
    {
        int mini=Integer.MAX_VALUE;

        //base condition
        if(i>=j)  return 0;

        // check in matrix
        if(t[i][j]!=-1)  return  t[i][j];

        //Now loop over all possible position to put brackets and mutiply brackets
        for(int k=i;k<j;k++)
        {
            int left, right;

            //avoid internal recursive calls also
            if(t[i][k]!=-1) { left=t[i][k];}
            else{
                left=MCM_memoization(arr,i,k);
                //store it for future use
                t[i][k]=left;
            }

            // similarly for right part
            if(t[k+1][j]!=-1) {right=t[k+1][j] ;}
            else {
                right=MCM_memoization(arr,k+1,j);
                t[k+1][j]=right;
            }

       //calculate the temp ans                            //current cost
            int temp_ans=   left + right +  (arr[i-1]*arr[k]*arr[j]);


            // Now need to find the minimum cost out of all possible try at  variious pos of k
        mini=Math.min(temp_ans,mini);
        }


        //store in , and return
        return t[i][j]=mini;
    }




}
