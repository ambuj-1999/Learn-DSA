import java.util.*;
public class Main {
    public static boolean isPalindrome(String x){
        int flag = 0;
        for(int i=0; i<x.length(); i++){
            if(x.charAt(i) == x.charAt(x.length()-1-i)){
                continue;
            }
            else{
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            return false;
        }
        else {
            return true;
        }
    }
    public static String reverseString(String x){
        String ans = "";
        for(int i=x.length()-1; i>=0; i--){
            ans += x.charAt(i);
        }
        return ans;
    }
    public static int printSpecialCharactersCount(String X){
        int cnt = 0;
        for(int i=0; i<X.length(); i++){
            char ch = X.charAt(i);
            if(ch>='A' && ch<='Z') continue;
            if(ch>='a' && ch<='z') continue;
            if(ch>='0' && ch<='9') continue;

            cnt++;

        }
        return cnt;
    }
    public static int printUpperCaseCount(String x){
        int cnt = 0;
        for(int i=0; i<x.length(); i++){
            char ch = x.charAt(i);
            if(ch>='A' && ch<='Z'){
                cnt++;
            }

        }
        return cnt;

    }
    public static void printASCIIValues(String x){
        //method 1
        for(int i=0; i<x.length(); i++){
            int ascii = x.charAt(i);
            System.out.println(ascii);
        }

        //method 2:
        for (int i=0; i<x.length(); i++){
            System.out.println((int)x.charAt(i));

        }
    }
    public static void printStringCharacters(String x){
        int n = x.length();
        for(int i=0; i<n; i++){
            System.out.println(x.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String x = scn.nextLine();
        //printStringCharacters(x);
        //printASCIIValues(x);
//
//        char y = 4949;
//        System.out.println(y);

        System.out.println(isPalindrome(x));



    }
}