public class Day3 {
    public static void main(String[] args) {
//        int i = 7;
//        do{
//            System.out.println(--i);
//            --i;
//        }while(i != 0);
//        System.out.println(i);//无限
//
        int result = 0;
        int i = 2;
        switch(i){
            case 1:
                result = result + i * 1;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        System.out.println(result);//10
        
        String str1 = "abb";
        String str2 = "ab";
        System.out.println(canConstruct(str1, str2));

        int x = 10;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        char[] ch = str.toCharArray();
        int mid = str.length() / 2;
        int j = str.length()-1;
        for(int i = 0; i < mid && j >= mid; i++, j--){
            if(ch[i] != ch[j]){
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct(String str1, String str2) {
        if(str1 == null || str2 == null){
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i = 0; i < str1.length(); i++){
            int j = 0;
            for(; j < str2.length(); ){
                if(ch1[i] == ch2[j]){
                    ch2[j] = '\0';
                    break;
                }else{
                    j++;
                }
            }
            if(j == str2.length()){
                return false;
            }
        }
        return true;
    }
}
