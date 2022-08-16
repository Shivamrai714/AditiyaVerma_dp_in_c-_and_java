package sorting;

public class sort2_insertionsort {

    public static void main(String[] args) {
        System.out.println("This is insertion Sort (IAS ) ");

        // int arr[]={1,9,3,6,2,8};
        int arr[]={9,4,1,8,2,7,44,8,95,47,741,2,4,8,4,854,654,8654,654,6854,41,54,5,4,54,847,7,3,6,6,6,4,4,64,67,897,54,87};
        int n=arr.length;

        insertionsort(arr,n);

        System.out.println("Array after the insertion sort is ");

        for(int i=0;i<n;i++)
            System.out.print(arr[i] + "-");
    }

    // idea is to start from 1 index and repeat same for n ele , and store curr ele in temp, then from its prev index move till elements are found greater then temp or j>=0 ,
    // after loop pointer will be at  1 less pos, so put the temp at arr[i+1], currect pos of that eleement.

    public  static void insertionsort(int arr[],int n )
    {
        for(int i=1;i<n;i++)
        {
            int temp=arr[i];                        //store the curr ele, and then check prev ele , if any greater ele is present or not.
            int j=i-1;
            while(j>=0 && arr[j]>temp)
            {
                arr[j+1]=arr[j];                    //if any greater ele is found , swap it in forward adjacent index.
                j--;
            }
            arr[j+1]=temp;                          // now put the temp at its suitable found position.
        }

    }


}
