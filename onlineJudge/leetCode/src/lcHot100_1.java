import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;
public class lcHot100_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(h.containsKey(target-nums[i])) return new int[]{h.get(target-nums[i]),i};
            h.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums_in={2,7,11,15};
        int target=9;
        lcHot100_1 l=new lcHot100_1();
        int[] out=l.twoSum(nums_in, target);
        for(int i=0;i<out.length;i++) System.out.print(Integer.toString(out[i])+' ');
    }
    
}
