import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    //Calculating sum of all possible sub-array using brute force.(T.C=O(N^3),S.C=O(1))
    public static int sumOfAllSubArrays(int[] arr){
        int n = arr.length;
        int total_sum = 0;
        for(int s=0; s<n; s++){
            for(int e=s; e<n; e++){
                int sum=0;
                for(int i=s; i<=e; i++){
                    sum+=arr[i];
                }
                total_sum+=sum;
            }
        }
        return total_sum;
    }
    //creating prefix sum of array.(T.C=O(N),S.C=O(N))
    public static int[] prefixSum(int[] arr){
        int n = arr.length;
        int[] pf  = new int[n];
        pf[0] = arr[0];
        for(int i=1; i<n; i++){
            pf[i] = pf[i-1]+arr[i];
        }
        return pf;
    }
    //calculating sum of all possible subarray using prefix sum.(T.C=O(N^2),S.C=O(N))
    public static int sumOfAllSubArrays1(int[]  arr){
        int n = arr.length;
        int[] pf = prefixSum(arr);
        int total_sum = 0;
        for(int s=0; s<n; s++){
            for(int e=s; e<n; e++){
                int sum=0;
                if(s==0) {
                    sum = pf[e];
                }
                else{
                    sum = pf[e]-pf[s-1];
                }
                total_sum+=sum;
            }
        }
        return total_sum;
    }
    //calculating sum of all possible subarray using carry forward.(T.C=O(N^2),S.C=O(1))
    public static int sumOfAllSubArrays2(int[] arr){
        int n=arr.length;
        int total_sum = 0;
        for(int s=0; s<n; s++){
            int sum=0;
            for(int e=s; e<n; e++){
                sum = sum + arr[e];
                total_sum += sum;
            }
        }
        return total_sum;
    }



    //calculating sum of all possible subarray using contribution technique.(T.C=O(N),S.C=O(1))
    public static int sumOfAllSubArrays3(int[] arr){
        //we'll have to calculate the presence of ith element in no. of subarrays.
        //Let's say i=1 and no. of elements is 5.
        /*
        presence of i-->    startingIndex   endingIndex     total
                                0               1             1
                                0               2             2
                                0               3             3
                                0               4             4
                                1               1             5
                                1               2             6
                                1               3             7
                                1               4             8
            generalising      (i+1)           (n-i)      (i+1)*(n-i)
            contribution of ith element = arr[i]*(i+1)*(n-i).
         */
        int n = arr.length;
        int total_sum = 0;
        for(int i=0; i<n; i++){
            int count = (i+1)*(n-i);
            int contribution = arr[i]*count;
            total_sum+=contribution;
        }
        return total_sum;


    }


    //calculating starting and ending index of each subarray with length k. (T.C=O(N-K+1),S.C=O(1))
    public static void printStartingEndingIndex(int[] arr, int K){
        int n = arr.length;
        int s = 0, e = K-1;
        while(e<n){
            System.out.println(s+" "+e);
            s++;
            e++;
        }
    }

    //calculating maxSum of all the elements of all the subarrays of length k using brute force. (T.C=O(N^2),S.C=O(1))

    public static int maxSumOfSubArraysOfLengthK(int[] arr, int K){
        int n=arr.length;
        int s=0, e=K-1;
        int maxSum = Integer.MIN_VALUE;
        while(e<n){
            int sum = 0;
            for(int i=s; i<=e; i++){
                sum+=arr[i];
            }
            maxSum = Math.max(maxSum,sum);
            s++;
            e++;
        }
        return maxSum;

        //Time complexity analysis.
        // T.C = O((N-K+1)*K)---->when k=N,O(1*N)=O(N)
        //                   ---->when k=1,O(N*1)=O(N)
        //                   ---->when k=N/2,O((N/2+1)*N/2)=O(N^2/2+N/2)=O(N^2)
    }


    //calculating maxSum of all the elements of all the subarrays of length k using prefix sum. (T.C=O(N-K), S.C=O(N))
    public static int maxSumOfSubArraysOfLengthK1(int[] arr, int K){
        int n = arr.length;
        int[] pf = prefixSum(arr);
        int s=0, e=K-1;
        int maxSum = Integer.MIN_VALUE;
        while(e<n){
            int sum=0;
            if(s==0) sum+=pf[e];
            else sum+=pf[e]-pf[s-1];
            maxSum = Math.max(maxSum,sum);
            e++;
            s++;

        }
        return maxSum;
    }

    //calculating maxSum of all the elements of all the subarrays of length k using sliding window.(T.C=O(N-K), S.C=O(1))
    public static int maxSumOfSubArraysOfLengthK2(int[] arr, int K){
        int n = arr.length;
        int s=0, e=K-1;
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for(int i=s; i<=e; i++){
            sum+=arr[i];
        }
        maxSum = Math.max(maxSum,sum);
        s++;
        e++;
        while(e<n){
            sum+=arr[e]-arr[s-1];
            maxSum = Math.max(maxSum,sum);
            s++;
            e++;
        }
        return maxSum;
    }
    //maximum of all possible subarray sum not greater than B. (T.C=O(N^2), S.C=O(1))
    public static int maxSum(int[] arr,int B){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        boolean flag = false;
        for(int s=0; s<n; s++){
            int sum=0;
            for(int e=s; e<n; e++){
                sum+=arr[e];
                if(sum<=B){
                    maxSum = Math.max(maxSum,sum);
                    flag = true;
                }
            }
        }
        if(flag) return maxSum;
        return 0;
    }

    //check whether there exist an array with length B and sum C.
    public static int[] arrayOfLengthBandSumC(int[] arr, int B, int C){
        int n = arr.length;
        int s=0, e=B-1;
        int sum = 0;
        for(int i=s; i<=e; i++){
            sum+=arr[i];
        }
        if(sum==C){
            int[] arr1 = new int[e-s+1];
            int j = 0;
            for(int i=s; i<=e; i++){
                arr1[j] = arr[i];
                j++;
            }
            return arr1;
        };
        s++;
        e++;
        while(e<n){
            sum+=arr[e]-arr[s-1];
            if(sum==C) {
                int j=0;
                int[] arr1 = new int[e-s+1];
                for(int i=s; i<=e;i++){
                    arr1[j] = arr[i];
                    j++;
                }
                return arr1;
            }
            e++;
            s++;
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
//        int sum_of_all_subarrays = sumOfAllSubArrays3(arr);
//        System.out.println(sum_of_all_subarrays);
        int K = scn.nextInt();
        int C = scn.nextInt();
//        printStartingEndingIndex(arr,K);
//        int max_sum_of_subarrays = maxSumOfSubArraysOfLengthK2(arr,K);
//        System.out.println(max_sum_of_subarrays);
//        int max_sum_less_than_B = maxSum(arr,K);
//        System.out.println(max_sum_less_than_B);
        int[] present_or_not = arrayOfLengthBandSumC(arr,K,C);

        if(present_or_not!=null) {
            for (int i : present_or_not) {
                System.out.print(i + " ");
            }
        }
        else{
            System.out.println("No such Sub-Array found!!");
        }

    }
}