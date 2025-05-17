package com.example.EmployeeSpringBoot;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        int[] arr={1,3,4,5,6,7};

//        Arrays.stream(arr).filter(e->e%2==0).forEach(System.out::println);



        int start=0;
        int end=arr.length-1;

        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        Arrays.stream(arr).forEach(System.out::println);


    }
}
