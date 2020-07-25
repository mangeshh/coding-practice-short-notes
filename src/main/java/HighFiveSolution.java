import java.util.*;

class HighFiveSolution {
    Map<Integer, List<Integer>> students = new HashMap();

    public int[][] highFive(int[][] items) {
        for (int i = 0; i < items.length; i++) {
            List<Integer> ans = students.get(items[i][0]);

            if (ans != null) {
                ans.add(items[i][1]);
                students.put(items[i][0], ans);
            } else {
                List<Integer> list = new ArrayList(5);
                list.add(items[i][1]);
                students.put(items[i][0], list);
            }
        }

        int[][] ansArray = new int[students.size()][2];
        int ansCnt = 0;
        for (Map.Entry<Integer, List<Integer>> en : students.entrySet()) {
            ansArray[ansCnt][0] = en.getKey();
            List<Integer> nums = en.getValue();
            Collections.sort(nums);
            int limit = Math.min(nums.size() - 5, nums.size());
            int tempAns = 0;
            for (int j = limit; j < nums.size() ; j++) {
                tempAns = tempAns + nums.get(j);
            }

            ansArray[ansCnt][1] = tempAns /Math.min(5, nums.size());
            ansCnt++;
        }

        return ansArray;
    }

    public static void main(String[] args) {
        HighFiveSolution s = new HighFiveSolution();
        int[][] a = s.highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}});
        System.out.println(a.toString());

    }
}