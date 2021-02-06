import java.util.ArrayList;
import java.util.List;

public class Day14 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
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
