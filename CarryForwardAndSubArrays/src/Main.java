import java.util.*;

public class Main {
    public static int countPairs1(String S){
        int n = S.length();
        int count = 0;
        for(int i = 0; i<n-1; i++){
            if(S.charAt(i) == 'a'){
                for(int j=i+1; j<n; j++){
                    if(S.charAt(j)=='g'){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static int countPairs2(String S){
        int n = S.length();
        int count = 0;
        int count_g = 0;
        for(int i = n-1; i>=0; i--){
            if(S.charAt(i)=='g'){
                count_g++;
            }
            if(S.charAt(i)=='a'){
                count+=count_g;
            }
        }
        return count;
    }
    public  static int countPairs3(String S){
        int n = S.length();
        int count_A = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(S.charAt(i)=='a'){
                count_A++;
            }
            if(S.charAt(i)=='g'){
                count+=count_A;
            }
        }
        return count;
    }
    public static ArrayList<ArrayList<Integer>> totalSubArrays(int[] A) {
        int n = A.length;
        int len = n*(n+1)/2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int s = 0; s <n; s++){
            for(int e = s; e <n; e++){
                ArrayList<Integer> rows = new ArrayList<>();
                for(int i = s; i<= e; i++){
                    rows.add(A[i]);

                }
                ans.add(rows);
            }
        }
        return ans;
    }


    public static int maxMinSubarray1(int[] arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(min+" "+max);
        int ans=Integer.MAX_VALUE;
        for(int s=0; s<n; s++){
            for(int e=s; e<n; e++){
                boolean hasMax=false,hasMin=false;
                for(int i=s; i<=e; i++){
                    if(arr[i]==max) hasMax=true;
                    if(arr[i]==min) hasMin=true;
                }
                if(hasMax && hasMin){
                    ans = Math.min(ans,s-e+1);
                }


            }
        }
        return ans;
    }
    public static int maxMinSubarray2(int[] arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(min+" "+max);
        int ans=Integer.MAX_VALUE;
        for(int s=0; s<n; s++){
            boolean hasMax=false,hasMin=false;
            for(int e=s; e<n; e++){
                if(arr[e]==max) hasMax=true;
                if(arr[e]==min) hasMin=true;
                if(hasMin && hasMax) ans=Math.min(ans,e-s+1);
            }
        }
        return ans;
    }
    public static int maxMinSubarray3(int[] arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(min+" "+max);
        int ans=n;
        int lastMin = -1;
        int lastMax = -1;
        for(int s=n-1; s>=0; s--){
            if(arr[s]==max){
                lastMax = s;
            }
            if(arr[s]==min){
                lastMin = s;
            }
            if(lastMax!=-1 && lastMin!=-1){
                if(lastMax>lastMin) ans = Math.min(ans,lastMax-lastMin+1);
                else ans = Math.min(ans,lastMin-lastMax+1);
            }


        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++){
//            arr[i] = scn.nextInt();
//        }
//        ArrayList<ArrayList<Integer>> totalSubarrays = totalSubArrays(arr);
//        int maxMin = maxMinSubarray3(arr);
//        System.out.println(totalSubarrays);
//        System.out.println(maxMin);
        String S = scn.next();
        int countA_GPAirs = countPairs3(S);
        System.out.println(countA_GPAirs);

    }
}