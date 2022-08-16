public class dp11_rod_cutting {

    public static  int t[][]=new int[1001][1001];




    public static void main(String[] args) {
        System.out.println("The Rod cutting problem : it is same as unbound kanpsack  we need to cut the rod in pieces and sell them to get profit .Find max profit.");

     int L=8;
     int price[]={1,5,8,9,10,17,17,20};       //ans =22 (    1 length unit ,7 lenght unit ) --> profit (5 + 17)=22
      int n=price.length;

      // total length of rod is L , we can cut it in numerous pars like {1,2, . . . n }
      int length[]=new int[L];
      for(int i=0;i<L;i++)
          length[i]=i+1;


      // now we have lenght array and the price array and total lenght L .
        // this is exaclty same as unbound knapsack. , each piece can be cut more than 1 no of times.


        // initialization
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<L+1;j++)
            {
                if(i==0 || j==0 ) t[i][j]=0;       // i==0 no ele in array so profit=0 , j==0 means rod is not even touched to cut , hence profit=0
            }
        }
      // condition of the loops

      for(int i=1;i<n+1;i++) {
          for (int j = 1; j < L+1; j++)
          {
              if(length[i-1]<= j)
              {             // included and can be reincluded               //excluded
                  t[i][j]= Math.max( price[i-1]+ t[i][j- length[i-1]]   , t[i-1][j] );
              }
              else t[i][j]=t[i-1][j];  // excluded
          }
      }


        System.out.println("Net profit from the Unbound knapsack is : "+ t[n][L]);


    }




}
