import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Day14 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        System.out.println(subsets(nums));

        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
        int f[][] = new int[2][];
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            switch (tokens[i]){
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    int a = stack.pop();
                    stack.push(stack.pop() - a);
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/" :
                    int b = stack.pop();
                    stack.push(stack.pop() / b);
                    break;
                default :
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length;i++){
            List<List<Integer>> sets = new ArrayList<>();
            for(List<Integer> tem : result){
                List<Integer> set = new ArrayList<>(tem);
                set.add(nums[i]);
                sets.add(set);
            }
            result.addAll(sets);
        }

        return result;
    }
}
