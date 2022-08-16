package sorting;

public class sort6_heapsort {

    public static void main(String[] args) {
        System.out.println("This is Heap Sort : ");
        System.out.println("First build the max heap , then from last node parent node (size-2/2) start to heapify till the 0 index done ");

       int []arr={8,4,55,8,13,56,45,55,1};
       int n=arr.length;

       heapsort(arr,n);


        System.out.println("Sorted Array is : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(" "+arr[i]);
        }
    }

    public static  void heapsort(int []arr, int n)
    {
        //build the max heap :
        buildheap(arr,n);

       // Now just the process of Selection sort , pick the ele and put it at last ,and readjust the max heap of size--

        for(int i=n-1;i>=0;i--)
        {
            swap(arr,i,0);               //0 index will be max ele, so put it a last of array
            //readjust the remaining , excluding the last one.
            heapify(arr, i , 0);     //no heapify on i left ele, and starting from root 0 node.
        }


    }

    public  static void heapify(int []arr, int n , int i)
    {
        // heapify means to adjust the disturebed heap , here max heap , by choosing the largest ele from three node availble  (ie  left, right , parent )
       int largest=i;

       int left=2*i+1;
       int right=2*i+2;

        if(left < n && arr[left]> arr[largest])
        {
            largest=left;
        }
        if(right < n && arr[right] > arr[largest])
        {
            largest=right;
        }


        // if parent itself is not the largest , then swap them and recursively
       if(largest != i)
       {
           swap(arr,i,largest);
          heapify(arr, n,largest);          //call the heapify to child index (ie largest) to futher most adjust the ele.
       }

    }


    public static void buildheap(int arr[],int n )
    {
        // to build the max heap ,
        for(int i=(n-2)/2 ; i>=0 ;i--)
        {
            heapify(arr,n,i);          //heapify from the current node to its downward tree.
        }
    }

    public static void swap(int []arr, int i , int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
