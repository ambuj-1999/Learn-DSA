import java.util.*;

public class Main {
    //i_g pairs problem using BRUTE FORCE.
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
    //leaders in array using carry forward.
    public static ArrayList<Integer> leadersInArray(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(arr[i]>max){
                max = arr[i];
                ans.add(arr[i]);
            }
        }
        return ans;
    }
    //I_G pairs using carrybackward.
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
    //I_G pairs using carryforward.
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
    //calculating total no of sub arrays.
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

    //getting maxMinSubarray using BRUTEFORCE.
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
    //getting maxMinSubarray using BRUTEFORCE(OPTIMISED).
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
    //Getting MAXMINSUBARRAY using carryforward/backward.
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
    //Best time to buy and sell stock using carryforward/backward.
    public static int maxProfit(int[] arr){
        int n = arr.length;
        int selling_value = arr[n-1];
        int max_Profit = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(arr[i]>selling_value){
                selling_value = arr[i];
            }
            max_Profit = Math.max(max_Profit, selling_value-arr[i]);

        }
        return max_Profit;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
//        ArrayList<ArrayList<Integer>> totalSubarrays = totalSubArrays(arr);
//        int maxMin = maxMinSubarray3(arr);
//        System.out.println(totalSubarrays);
//        System.out.println(maxMin);
//        String S = scn.next();
//        int countA_GPAirs = countPairs3(S);
//        System.out.println(countA_GPAirs);
//        ArrayList<Integer> leaderInArray = leadersInArray(arr);
//        System.out.println(leaderInArray);
        int max_profit_in_stocks = maxProfit(arr);
        System.out.println(max_profit_in_stocks);

    }
}