import java.util.*;
public class Main {
    //creating hashmap from array.
    public static HashMap<Integer,Integer> arrayTOHashMap(int[] arr){
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(arr[i],i);
        }
        return hm;
    }
    //solving good pair problem using brute force.
    public static int goodPair(int[] A, int B){
         for(int i=0; i<A.length-1; i++){
             int x = A[i];
             int j = A.length-1;
             while(j>i && j!=i){
                 if(x+A[j]==B) return 1;
                 j--;
             }
         }
         return 0;
    }
    //solving good pair using hashmap optimised version.
    public static int goodPair1(int[] arr, int B){
        int n = arr.length;
        HashMap<Integer,Integer> hm = arrayTOHashMap(arr);
        for(int i=0; i<n; i++){
            int x = B-arr[i];
            if(hm.containsKey(x)){
                if(hm.get(x)!=i) return 1;
            }
        }
        return 0;
    }
    //reverse array in a given range.
    public static int[] reverseArrrayInARange(int[] arr, int B, int C){
        while(B<=C){
            int temp=arr[C];
            arr[C] = arr[B];
            arr[B] = temp;
            B++;
            C--;
        }
        return arr;
    }
    //rotate array k times using brute force.
    public static int[] rotateArrayKTimes(int[] arr, int k){
        int n = arr.length;
        for(int i=0; i<k; i++){
            int temp = arr[n-1];
            for(int j=n-2; j>=0; j--){
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }
        return arr;
    }
    //rotate array k times using optimisation.
    public static int[] rotateArrayKTimes1(int[] arr, int k){
        int n = arr.length;
        reverseArrrayInARange(arr,0,n-1);
        reverseArrrayInARange(arr,0,k-1);
        reverseArrrayInARange(arr,k,n-1);
        return arr;
    }
    //finding sum of maximum and minimum element.
    public static int findMaxMinSum(int[] A){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = A.length;
        int max_min_sum=0;
        for(int i=0; i<n; i++){
            if(A[i]>max){
                max = A[i];
            }
            if(A[i]<min){
                min = A[i];
            }
            max_min_sum = max+min;
        }
        return max_min_sum;
    }
    //number of occurences of b in array.
    public static int findNumberOfOccurenceOfB(int[] arr, int B){
        int n = arr.length;
        int count=0;
        for(int i:arr){
            if(i==B) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int B = scn.nextInt();
//        int C = scn.nextInt();
//        int has_good_pair = goodPair(arr,B);
//        System.out.println(has_good_pair);
//        int[] reversed_array_in_range = reverseArrrayInARange(arr,B,C);
//        for(int i:reversed_array_in_range){
//            System.out.print(i+" ");
//        }

//        int k = scn.nextInt();
//        int[] rotate_k_times = rotateArrayKTimes1(arr,k);
//        for(int i:rotate_k_times){
//            System.out.print(i+" ");
//        }

//        int max_min_sum = findMaxMinSum(arr);
//        System.out.println(max_min_sum);

        int frequency_of_b = findNumberOfOccurenceOfB(arr,B);
        System.out.println(frequency_of_b);


    }
}