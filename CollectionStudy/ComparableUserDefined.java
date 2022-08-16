package CollectionStudy;

import java.util.Collections;
import java.util.PriorityQueue;

class pair implements Comparable<pair>
{
  public int first;
  public int second;

  public  pair(int first, int second)
  {
      this.first=first;
      this.second=second;
  }

  public int compareTo(pair p)
  {
      if(this.first>p.first )             // ascending order    (1,8 ) (3 , 4)
      {return 1;}
      else if(this.first < p.first)
      {return -1;}
      else if(this.first== p.first)       //then descending order of 2 val  (1 ,8 ) (3,  " 4 " ) (3, " 2 " )
      {
          if(this.second<p.second)  return 1;
          else return -1;
      }

      return 0;    // simple to balance eq.
  }




}



public class ComparableUserDefined {

    public static void main(String[] args) {
        System.out.println("Making the user defined class and its own comparator to sort the value ");
        System.out.println("We sort a pair First in increasing order , if ele same then decreasing order of 2 element ");

        int arr[]= {1,2,3,6,10};
        int k=3 ; int X=4;

        System.out.println("Printing the k elements closest elemets to X");

        // Make a PriorityQueue of max type , to remove ele of larger diff.
//Max Heap
        PriorityQueue<pair> pq= new PriorityQueue<>(Collections.reverseOrder());



        for(int i=0;i<arr.length;i++)
        {
            pq.add( new pair (  Math.abs(X-arr[i]) , arr[i]   ) );
            if(pq.size()>k)
            {
                pq.poll();
            }

        }
        // at last we have remaing the k closest elements with minimum diff

        int ans[]= new int[k];
        int r=0;
        while(pq.size()!=0)
        {
            ans[r++]=pq.poll().second;
        }

        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" . ");


    }
}
