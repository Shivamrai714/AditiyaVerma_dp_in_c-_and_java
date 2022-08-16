package sorting;

public class sort4_quicksort {
    public static void main(String[] args) {
        System.out.println("This is quick sort (pivot last ele) ");

        int arr[]={9,4,1,8,2,7,44,8,95,47,741,2,4,8,4,854,654,8654,654,6854,41,54,5,4,54,847,7,3,6,6,6,4,4,64,67,897,54,87};
        int n=arr.length;

          quicksort(arr,0,n-1);

        System.out.println("After the quick sort ... ");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"-");
        }


    }

    public static  void quicksort(int arr[], int low, int high)
    {
        if(low==high) return ;                                 //single element left, already sorted
        if(low<high)
        {
            int p_index=find_partition_index(arr,low,high);      //find the index of pivot ele.
            quicksort(arr,low,p_index-1);                         //recursive call to left part.
            quicksort(arr,p_index+1,high);                        //recursive call to right part.
        }
    }
    public  static  int find_partition_index(int arr[],int low, int high)
    {
        int pivot=arr[high];                                //last ele is piovt .

        int i=low-1;                                         // assign the pointer i at -1 of current , it i=l-1;
        for(int j=low;j<high;j++)                            //    if(smaller ele found ,  by moving i , then swap)
        {
            if(arr[j]<pivot)
            {
              i++;
              swap(arr,i,j);            //made a user defined function.
            }
                                                              //  else greter ele, ignore them, as pivot finally will be placed on left ot them.
        }
        // pivot got its original position after this, not return this index next recursive call be made to left and right parts.
        swap(arr,i+1,high);            //high -> its index of the pivot

        // return  this index of pivot ele  . next recursive call be made to left and right parts.
        return i+1;

    }

    public static void swap(int arr[], int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }




}
