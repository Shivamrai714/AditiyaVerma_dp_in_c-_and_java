package CollectionStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Max_and_min_Heap
{

    public static void main(String[] args)
    {
                            System.out.println(" Learning about the use of Heap  : Min Heap  and Max Heap ");
                            System.out.println("Insertion : log n  ," + "Deletion :  log n  ,"  + " Heapify :  log n " );

        PriorityQueue<Integer> pq= new PriorityQueue<>();           // this is min priority queue / or min heap

        PriorityQueue<Integer> max_pq= new PriorityQueue<>(Collections.reverseOrder());


                             ArrayList<Integer>arr= new ArrayList<>();
                              arr.add(5);arr.add(1);arr.add(9);arr.add(6);arr.add(8);arr.add(4);

        // List content
        for(int i=0;i<arr.size();i++) {
            System.out.print( arr.get(i)+"-" );
            //push elements in min heap , to get them in the ascending order.
            pq.add(arr.get(i));

            max_pq.add(arr.get(i));
        }

        //store the elements in the array in the sorted order using priority queue (usually helpfull when pq is made of k size , then polling ele if size exceds k)
        int ans_ascending[]= new int[pq.size()];


        int m=0;
        while(pq.size()>0)
        {
            ans_ascending[m++]=pq.peek();               //top ele is stored
            pq.poll();                //remove top ele.
        }
        System.out.println("\nWork of Min Heap .......... ");

           for(int i=0;i<ans_ascending.length;i++)
               System.out.print(" / " + ans_ascending[i]);
/////////////////////////////////////////////////////////////////////////////////////////


        int ans_descending[]= new int[max_pq.size()];

        int r=0;
        while(max_pq.size() > 0)
        {
         ans_descending[r++] = max_pq.poll();               // it return the top ele , as well as it pop the current ele.
        }

        System.out.println("\nWork of Max Heap .......... ");

        for(int i=0;i<ans_descending.length;i++)
            System.out.print(" / " + ans_descending[i]);


    }


}
