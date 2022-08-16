package sorting;

public class sort3_selectionsort {
    public static void main(String[] args) {
        System.out.println("This is selection sort (select min and place on front sorted)");

          int arr[]={9,4,1,8,2,7,44,8,95,47,741,2,4,8,4,854,654,8654,654,6854,41,54,5,4,54,847,7,3,6,6,6,4,4,64,67,897,54,87};
         int n=arr.length;

         selectionsort(arr,n);

        System.out.println("After using the selection sort ");

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"-");
        }

    }
//For each index starting from the start , find the minimum from remaining set of elements on the right and put then in correct position on left.
       public static void selectionsort(int arr[] , int n)
        {

            //simplest algo , suppose the ele as min for each index, then find the mininm form remaining ele on right , then swap minimun ele with the current ele.

              for(int i=0;i<n-1;i++)
              {
                   int  mini=arr[i]; int index=i;                                  // start with index=i, ie self as minimum, then find minimum from remaining and then swap
                   for(int j=i+1;j<n;j++)
                   {
                         if(arr[j]<mini){index=j; mini=arr[j];}                      //storing the index of min ele .

                   }
                   //swap  logic
                   int temp=arr[i];
                   arr[i]=arr[index];
                   arr[index]=temp;

                /*  for(int j=0;j<n;j++)
                  {
                      System.out.print(arr[j]+".");
                  }
                  System.out.println();
                 */

              }

        }

}
