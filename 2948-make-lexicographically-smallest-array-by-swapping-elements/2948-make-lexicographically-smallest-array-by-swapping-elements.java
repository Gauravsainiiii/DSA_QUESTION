import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        
        int[][] sortedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }
        Arrays.sort(sortedNums, (a, b) -> Integer.compare(a[0], b[0]));


        List<Queue<Integer>> groupList = new ArrayList<>();
        Map<Integer, Integer> numToGroup = new HashMap<>();

        int groupIndex = 0;
        groupList.add(new LinkedList<>());
        groupList.get(groupIndex).offer(sortedNums[0][0]);
        numToGroup.put(sortedNums[0][0], groupIndex);

        for (int i = 1; i < n; i++) {
            
            if (sortedNums[i][0] - sortedNums[i - 1][0] > limit) {
                groupIndex++;
                groupList.add(new LinkedList<>());
            }
            groupList.get(groupIndex).offer(sortedNums[i][0]);
            numToGroup.put(sortedNums[i][0], groupIndex);
        }

    
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            result[i] = groupList.get(group).poll();
        }

        return result;
    }
}