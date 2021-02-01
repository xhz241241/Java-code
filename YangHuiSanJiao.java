import java.util.ArrayList;
import java.util.List;

//[1],         第0行
//[1,1],       第1行
//[1,2,1],     第2行
//[1,3,3,1],   第3行
//[1,4,6,4,1]  第4行
public class YangHuiSanJiao {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        //先判空
        if(numRows <= 0){
            return new ArrayList<>();
        }
        //第0第1行单独判断
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zeroLine = new ArrayList<>();
        zeroLine.add(1);
        result.add(zeroLine);
        if(numRows == 1){
            return result;
        }
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 2){
            return result;
        }

        //其余行第一个和最后一个都是1, 中间的元素是上一行同列前一列之和
        for(int row = 2; row < numRows; row++){
            //先把上一行get出来
            List<Integer> preLine = result.get(row-1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            //因为第一个元素已经赋值为1了, 所以从下标为1的元素开始, 到row-1结束
            for(int col = 1; col <= row-1; col++){
                curLine.add(preLine.get(col) + preLine.get(col-1));
            }
            curLine.add(1);
            //把每一行的结果都放到result里面
            result.add(curLine);
        }
        return result;
    }
}
