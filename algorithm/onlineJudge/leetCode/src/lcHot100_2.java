import java.util.ArrayList;
import java.util.List;

public class lcHot100_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rets=new ArrayList<>();
        rets.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int rets_len=rets.size();
            for(int j=0;j<rets_len;j++){
                List<Integer> temp=new ArrayList<>(rets.get(j));
                temp.add(nums[i]);
                rets.add(temp);
            }
        }
        return rets;
    }
    public static void main(String[] args) {
        int[] nums_in = {1,2,3};
        List<List<Integer>> out=new lcHot100_2().subsets(nums_in);
        for(int i=0;i<out.size();i++){
            for(int j=0;j<out.get(i).size();j++){
                if(out.get(i).isEmpty()) System.out.print(' ');
                else System.out.print(Integer.toString(out.get(i).get(j))+' ');
            }
            System.out.println();
        }
    }
}
