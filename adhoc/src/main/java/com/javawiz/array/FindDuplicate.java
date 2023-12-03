package com.javawiz.array;

public class FindDuplicate {
    public static void main(String[] args) {
        //System.out.println(isPrime(11));
    	int[] array = {1, 3, 3, 4, 5, 5, 6, 7, 17};
        duplicate(array);
        //printRepeating(array);
    }

    public static boolean isPrime(int x){
        if(x<2) return false;

        if(x!=2 && x%2==0) return false;

        for(int i=3;i*i<x;i+=2) {
            System.out.println(i);
            if(x%i == 0) return false;
        }
        return true;
    }

    public static void printRepeating(int[] arr) {
        int count[] = new int[arr.length];
        int i;

        System.out.println("Repeated elements are : ");
        for (i = 0; i < arr.length; i++)
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }

        System.out.println();
        for (i = 0; i < count.length; i++)
        {
            System.out.print(count[i] + " ");
        }
    }

    public static void duplicate(int[] array){
        for(int i = 0; i<array.length-1; i++){
            for(int j = i+1; j<array.length; j++){
                if(array[i]==array[j])
                    System.out.println(array[j]+"");
            }
        }
    }
}
