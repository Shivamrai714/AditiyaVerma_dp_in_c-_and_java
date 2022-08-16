package CollectionStudy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Maps {

    // Declare the pair as user Defined Class

    static class  pair  implements  Comparable<pair>    // logic to make min heap
    {
        public int first;
        public int second;

        public pair(int first, int second)
        {
            this.first=first;
            this.second=second;
        }

        // min heap / ascending order login
        public  int compareTo(pair p)
        {
            if(this.first>p.first) return 1;
            else return -1;
        }

    }




    public static void main(String[] args) {

        System.out.println("Maps used to store the key value pair : ");
        System.out.println("Hash Map :  unordered - storage");
        System.out.println("Tree Map :  sorted-ascending - storage");

        System.out.println(".................................................");

        System.out.println("LinkedHashMap Map :  insertion_order - storage");


        // Take eg of problem to store the frequecy of the words

        String test="hi this is shivam rai . I study in this school of lnct of ashok rai ";

        LinkedHashMap<String,Integer> mp1= new LinkedHashMap<>();


        //Method 2 : to use the substring concept :
        int j=0;
        for(int i=1;i<test.length();i++)
        {
            if( test.charAt(i)==' ')
            {
             String temp= test.substring(j,i);         //i excluded ' '

             // store frequency in map
                if(mp1.containsKey(temp))
                {
                    mp1.put(temp  ,  mp1.get(temp)+1 ) ;
                }
                else {
                    mp1.put(temp, 1);
                }

             j=i+1;
            }

        }


        for(Map.Entry i : mp1.entrySet())
        {
            String key= (String)i.getKey();
            Integer val= (Integer) i.getValue();
            System.out.println( key +" -> "+ val);
        }


        //Now Making the String after removing the duplicaties repetation

        System.out.println("Final Modified String is : ");

        String finnally="";
        for(Map.Entry i: mp1.entrySet())
        {
            String key= (String) i.getKey();
            finnally+=key+" ";
        }

        System.out.println(finnally);


        System.out.println();

        System.out.println(".................................................");

        System.out.println("HashMap  - storage");

        System.out.println("Basically Solving Quest : To find the k most frequent elements :  ");

        int nums[]={1,1,1,2,2,3,3,3,3}; int k=2;      //op : [1,2]

        //Storing the frequency in the HashMap, then applying the Min Heap of size k , so smaller frequecy ele will be removed.

        PriorityQueue<pair> pq= new PriorityQueue<pair>(); //by default its min Heap

        // store the count of frequcy in HashMap
        HashMap<Integer,Integer> mp2= new HashMap<>();
        for(int i:nums)
       {
                mp2.put(i, mp2.getOrDefault(i,0)+1 );
       }




        // Now Store the frequencies and the element in the priority_queue
        for(Map.Entry i : mp2.entrySet())
        {
            int key= (Integer) i.getKey();
            int val=(Integer) i.getValue();

            pq.add( new pair(val,key ) );
            if(pq.size() > k)
            {
                pq.poll();
            }

        }
        int []final_ans=new int[k];
        int q=0;
        while(k-- > 0){
            final_ans[q++] = pq.poll().second;
        }
        System.out.println();
       for(int i=0;i<final_ans.length;i++)
           System.out.print(final_ans[i]+" ; ");

    }








}
