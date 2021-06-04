package Test_0601;
//红与黑

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            Character[][] map = new Character[m][n];
            Node start = null;
            for (int i = 0; i < m; i++) {
                String tem = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = tem.charAt(j);
                    if (tem.charAt(j) == '@') {
                        start = new Node(i, j);
                    }
                }
            }
            int[][] direction = {{0, 1},
                    {0, -1},
                    {1, 0},
                    {-1, 0}};
            System.out.println(bfs(map, direction, start));
        }
    }

    public static int bfs(Character[][] map, int[][] direction, Node start) {
        //定义Node节点的队列 把走过的点都放到队列中
        Queue<Node> queue = new LinkedList<>();
        //定义一个用来标记走过的点的数组
        boolean[][] flag = new boolean[map.length][map[0].length];
        queue.add(start);
        //把初始位置设为true
        flag[start.x][start.y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            //取出队列的第一个元素
            Node cur = queue.poll();
            //遍历该元素的上下左右四个方向
            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.x + direction[i][0], cur.y + direction[i][1]);
                //判断该元素是否合法 并且判断是否走过 并且判断该点不是红砖
                if (next.x >= 0 && next.x < map.length
                        && next.y >= 0 && next.y < map[0].length
                        && map[next.x][next.y] != '#'
                        && !flag[next.x][next.y]) {
                    count++;
                    queue.add(next);
                    flag[next.x][next.y] = true;
                }
            }
        }
        return count;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}