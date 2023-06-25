import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		List<List<Integer>> l = new ArrayList<>();
		int nums[] = {1,2,3};
		permuteHelp(nums,0,l);
		System.out.println(l);
	}
	
	private static void permuteHelp(int[] nums,int index,List<List<Integer>> l) {
    if(index == nums.length) {
			ArrayList<Integer> list =new ArrayList<>();
			for(int i =0;i<nums.length;i++)
			list.add(nums[i]);
			l.add(list);
			return;
	}
	for(int i =index;i<nums.length;i++){
		int ele = nums[index];
		nums[index] = nums[i];
    nums[i] = ele;
		permuteHelp(nums,index+1,l);
		ele = nums[index];
		nums[index]=nums[i];
    nums[i] = ele;
		System.out.println();
	}
 }

}
