public class Day11 {
    public static void main(String[] args) {
        int num = 10;
//        System.out.println(test(num));
        String str = "0P";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
       str =  str.toLowerCase();
       char[] ch = str.toCharArray();
       int left = 0;
       int right = ch.length-1;
       while(left < right){
           while(!Character.isLetterOrDigit(ch[left]) && left < right){
               left++;
           }
           while(!Character.isLetterOrDigit(ch[right]) && left < right){
               right--;
           }

           if(ch[left] == ch[right]){
               left++;
               right--;
           }else{
               return false;
           }
       }
       return true;
    }

    public static int test(int b){
        try{
            b += 10;
            return b;
        }catch(RuntimeException e){

        }finally{
            b += 10;
            return b;
        }

    }
}
