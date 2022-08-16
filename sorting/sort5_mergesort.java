package sorting;

public class sort5_mergesort {
    public static void main(String[] args) {
        System.out.println("This is the Merge Sort :  ");

        int arr[]={5,8,1,7,9,6};
        int n=arr.length;

        mergesort(arr,0,n-1);

        System.out.println("Array after the merge sort is  : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+".");
        }


    }

    public  static  void mergesort(int arr[], int l, int r)
    {
        if(l==r)  return ;                //single element , already sorted.
       if(l<r) {
        int mid=(l+r)/2;
           mergesort(arr,l,mid);                 // following divide and conqueer strategy.         (left part)
           mergesort(arr,mid+1,r);                                                               //   (right part)

           mergetwo(arr,l,mid,r);

       }
    }

    public static void mergetwo(int arr[], int l, int mid, int r)
    {
                                    // now to merge the two subparts , we are putting them in auxillay arrays,
        int l_sz=mid-l+1;           // left aaaru size
        int r_sz=r-mid;             //right array size

        int left[]= new int[l_sz];
        int right[]= new int[r_sz];

        //fill the data in fake arrays

        for(int i=0;i<l_sz;i++)
        {
            left[i]=arr[l+i];
        }

        for(int i=0;i<r_sz;i++)
        {
            right[i]=arr[mid+1+i];                      //copied data        , from main array
        }
        //////////////////      each time k will be the current low(left element) , as changes are refleted in main array
        int i=0,j=0,k=l;

        while(i<l_sz && j < r_sz)
        {
            if(left[i]<right[j])  arr[k++]=left[i++];                     //store in mmain array. at k pos
            else arr[k++]=right[j++];
        }

        //if any array left with remaining elements :
        while(i<l_sz) { arr[k++]=left[i++]; }                                     // if comparision with right is finsined due to less ele in right[] , so just copy the rest ele of left in main array.
        while (j<r_sz) { arr[k++]=right[j++]; }



    }


}
