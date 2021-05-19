package Test_0515;
//迷宫问题
import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] arr = new int[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            ArrayList<Node> path = new ArrayList<>();
            ArrayList<Node> minPath = new ArrayList<>();
            int[][] flag = new int[row][col];
            getMinPath(arr, row, col, 0, 0, flag, path, minPath);
            //打印最短路径
            for(Node n : minPath){
                System.out.println("(" + n.x + "," + n.y + ")");
            }
        }
    }
    //arr 表示迷宫的二维数组
    //row表示迷宫的行
    //col表示迷宫的列
    //x,y表示当前位置的行和列
    //flag 二维数组表示该位置是否被走过
    //path表示当前路径的每个点
    //minPath表示最短路径走过的所有点
    public static void getMinPath(int[][] arr, int row, int col,
                                  int x, int y, int [][] flag, ArrayList<Node> path, ArrayList<Node> minPath){
        // 1. 首先判断该节点是否越界 是否走过 是否有障碍
        //flag[][] 为 1 表示该点已经走过
        //arr[][] 为 1 表示该点有障碍
        if(x < 0 || x >= row || y < 0 || y >= col
                || flag[x][y] == 1 || arr[x][y] == 1){
            return;
        }
        // 2. 如果当前位置合法就把当前位置存入当前路径中
        path.add(new Node(x, y));
        // 3. 把当前位置标记为走过
        flag[x][y] = 1;
        // 4. 判断当前位置是否为出口
        if(x == row-1 && y == col-1){
            //如果是出口 那么就说明新的一条路径已产生
            //拿当前路径和最短路径做比较
            if(minPath.isEmpty() || path.size() < minPath.size()){
                //更新最短路径
                minPath.clear();
                for(Node n : path){
                    minPath.add(n);
                }
            }
        }
        // 5. 如果不是出口 继续搜索x, y 的上下左右四个方向
        getMinPath(arr, row, col, x + 1, y, flag, path, minPath);//上
        getMinPath(arr, row, col, x - 1, y, flag, path, minPath);//下
        getMinPath(arr, row, col, x, y - 1, flag, path, minPath);//左
        getMinPath(arr, row, col, x, y + 1, flag, path, minPath);//右
        //如果该点被回退了 就是该点的四个方向都判断过了不合法
        //那么就要把该点从当前路径中删除
        path.remove(path.size()-1);
        flag[x][y] = 0;
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}