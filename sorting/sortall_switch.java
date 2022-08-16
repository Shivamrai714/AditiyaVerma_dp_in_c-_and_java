package sorting;

import java.io.IOException;
import java.util.Scanner;

public class sortall_switch {

    public static void main(String[] args) throws IOException {



        int arr[] = {9, 4, 1, 8, 2, 7, 44, 8, 95, 47, 741, 2, 4, 8, 4, 854, 654, 8654, 654, 6854, 41, 54, 5, 4, 54, 847, 7, 3, 6, 6, 6, 4, 4, 64, 67, 897, 54, 87};
        int n = arr.length;
        int ch=1;
        Scanner sc = new Scanner(System.in);


        do {

            System.out.println("HELLO EVERYONE , WELCOME TO TYPES OF SORTING ALGO : ");
            System.out.println(" Press 1 for bubble sort ");
            System.out.println(" Press 2 for insertion sort ");
            System.out.println(" Press 3 for selection sort ");
            System.out.println(" Press 4 for quicksort sort ");
            System.out.println(" Press 5 for merge sort sort ");

            System.out.println("\nEnter your choice  .  ");
            ch = sc.nextInt();


            switch (ch) {

                case 1: {
                    bubblesort(arr, n);
                    System.out.println("Bubble sort : on array ");
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + "-");ch=1;
                    break;

                }

                case 2: {
                    insertionsort(arr, n);
                    System.out.println("Insertion sort : on array ");
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + "-");ch=1;
                    break;
                }

                case 3: {
                    System.out.println(" selection sort : on array ");
                    selectionsort(arr, n);
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + "-");ch=1;
                    break;
                }


                case 4: {
                    System.out.println(" quick sort : on array ");
                    quicksort(arr, 0, n - 1);
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + "-");ch=1;
                    break;
                }

                case 5: {
                    System.out.println(" merge sort : on array ");
                    mergesort(arr, 0, n - 1);
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + "-");ch=1;
                    break;
                }

            }

            System.out.println("\nPress 0 to exit , else other number key to continue");
            // int opt=sc.nextInt();
            char opt= (char) System.in.read();    //for reading the character, also add the IOExveption in the method signature.
            if(opt=='0') { System.out.println("Good bye ..."); ch=0; }
             else {ch=1;}

        }while(ch==1);


    }







    //bubble sort
    public static  void bubblesort(int arr[], int n)
    {
        //external loop for number of times loop runs.
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])  swap(arr, j, j+1);
            }
        }


    }

    public static  void swap(int arr[], int i ,int j)
    {
        int temp=arr[i];
         arr[i]=arr[j];
        arr[j]=temp;
    }



    //insertion sort
    public static  void insertionsort(int arr[], int n)
    {
        System.out.println("Inside Insertion Sort");
        for(int i=1;i<n;i++)
        {
            int temp=arr[i];
            int j=i-1;
            while( j >=0 && arr[j] >temp)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;

        }

    }



    //selection sort
    public static  void selectionsort(int arr[], int n)
    {
            for(int i=0;i<n;i++)
            {
                int mini=arr[i]; int index=i;
                for(int j=i+1;j<n;j++)
                {
                    if(arr[j]<mini)  {  mini=arr[j]; index=j; }
                }
                 swap(arr,i,index);
            }

    }


    //quick sort
    public static  void quicksort(int arr[], int l, int r)
    {
        if(l==r) return ;           //single element left.
        if(l<r)
        {
            int ind=find_partition_index(arr,l,r);
            quicksort(arr,l,ind-1);
            quicksort(arr,ind+1,r);
        }

    }

    public static int find_partition_index(int arr[], int l , int r)
    {
        int pivot=arr[r];
        int i=l-1;
        for(int j=l;j<r;j++)
        {
            if(arr[j]< pivot) {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r) ;                //swapping the pivot ele to its correct position.
        return i+1;                     //returning the pivot index. so that next recursive cally can be made at left and right parts respectively.

    }





    // merge sort
    public  static  void mergesort(int arr[],int l, int r)
    {
        if(l==r)       return ;               //single element
        if(l<r)
        {
            int mid=(l+r)/2;

            mergesort(arr, l,mid);
            mergesort(arr, mid+1, r);

            mergetwo(arr, l, mid, r);
        }
    }
    public static  void mergetwo(int arr[], int l, int mid, int r)
    {
        int l_sz=mid-l+1;          int r_sz=r-mid;
        int left[]= new int[l_sz];
        int right[]=new int[r_sz];

        //copy data in fake array.

        for(int i=0;i<l_sz;i++)
        {
         left[i]=arr[l+i];
        }
        for (int j=0;j<r_sz;j++)
        {
            right[j]=arr[mid+1+j];
        }


        //now megre them in sorted order.
        int i=0, j=0, k=l;            //**********

        while(i<l_sz  && j<r_sz)
        {
            if(left[i]<right[j]) {arr[k++]=left[i++];}
            else arr[k++]=right[j++];

        }

        while (i<l_sz){
            arr[k++]=left[i++];
        }
        while(j<r_sz) {
            arr[k++]=right[j++];
        }

    }


}
