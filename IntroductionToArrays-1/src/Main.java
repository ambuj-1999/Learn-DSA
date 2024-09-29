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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int B = scn.nextInt();
        int C = scn.nextInt();
//        int has_good_pair = goodPair(arr,B);
//        System.out.println(has_good_pair);
        int[] reversed_array_in_range = reverseArrrayInARange(arr,B,C);
        for(int i:reversed_array_in_range){
            System.out.print(i+" ");
        }

    }
}