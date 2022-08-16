package sorting;

import java.util.Collection;
import java.util.Collections;

public class sort1_bubblesort {
    public static void main(String[] args) {
        System.out.println("Bubble Sort in O(n^2)");

     //bubble sort :
        int arr[]={9,4,1,8,2,7,44,8,95,47,741,2,4,8,4,854,654,8654,654,6854,41,54,5,4,54,847,7,3,6,6,6,4,4,64,67,897,54,87};
        int n=arr.length;

        bubblesort(arr,n);

        System.out.println("Array after sorting is  : ");

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"-");

        //end of main
    }


    public static  void bubblesort(int arr[], int n)
    {
        for(int i=0;i<n;i++)               //loop for n no to times.
        {
         for(int j=0;j<n-i-1;j++)           //loop for comparing the adjacent elements.
         {
             if(arr[j]>arr[j+1] )
             {
                 //swap login, no inbuit fun in java
                 int temp=arr[j]; arr[j]=arr[j+1]; arr[j+1]=temp;
             }
         }

        }

    }




    //end of class
}
