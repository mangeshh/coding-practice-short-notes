package code.course;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SolutionLetterCombination {
    public static List<String> letterCombinations(String digits) {
        String[] dict = new String[]{"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<StringBuilder> queue = new LinkedList<>();
        for(int i=0; i<digits.length(); i++){
            int d = digits.charAt(i) - '0';
            String option = dict[d];
            if(i==0){
                for(int j=0; j<option.length(); j++){
                    queue.offer(new StringBuilder().append(option.charAt(j)));
                }
            }else{
                LinkedList<StringBuilder> temp = new LinkedList<>();
                while(!queue.isEmpty()){
                    StringBuilder sb = queue.poll();
                    for(int j=0; j<option.length(); j++){
                        temp.offer(new StringBuilder(sb).append(option.charAt(j)));
                    }
                }
                queue.addAll(temp);
            }
        }
        List<String> result = new ArrayList<>(); while(!queue.isEmpty()){ result.add(queue.poll().toString());  }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
