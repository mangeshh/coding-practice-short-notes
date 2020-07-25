import java.util.*;

@SuppressWarnings("unused")
public class GroupAnagram {

    public static void main(String[] args) {
        String [] strs = new String [] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String s : strs) {
            char[] tempSortArray = s.toCharArray();
            Arrays.sort(tempSortArray);
            String sortedStr = String.valueOf(tempSortArray);
            Integer currentIndex = map.get(sortedStr);
            if (currentIndex == null) {
                map.put(sortedStr, index);
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                ans.add(index, tempList);
                index++;
            } else {
                ans.get(currentIndex).add(s);
            }
        }

        return ans;
    }
}
