package Test_0424;
//二进制插入

public class Main {
    public class BinInsert {
        public int binInsert(int n, int m, int j, int i) {
            //右移 j 位是保证 m 能够对齐在i和j之间
            m = m << j;
            //然后之间把 n 和 m 进行或操作
            return n | m;
        }
    }
}
