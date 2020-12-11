//打印 1 - 100 之间所有的素数
public class Work3 {
    public static void main(String[] args) {
        int j = 2;
        for (int i = 1; i <= 100 ; i++) {
            for(j = 2; j <= i; j++){
                if(i % j == 0) {
                    break;
                }
            }
            if(i == j){
                System.out.print(i + " ");
            }
        }
    }
}
