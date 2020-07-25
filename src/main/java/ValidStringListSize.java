import java.util.*;

@SuppressWarnings("unused")
//leetcode - Valid Word Square
class ValidStringListSize {

    public static boolean validWordSquare(List<String> words) {
        if (words.size() == 0) {
            return false;
        }

        ArrayDeque<String> queue = new ArrayDeque<>();
        int cnt = 0;
        String stStr = words.get(0);

        if (stStr.length() != words.size()) {
            return false;
        }

        String startStr = words.get(0);

        for(int s=0; s<startStr.length(); s++){
            queue.addLast(startStr.charAt(s)+"");
        }
        queue.addLast("NULL");

        System.out.println("start of the queue" + queue);

        for (int w = 1; w < words.size(); w++) {
            String str = words.get(w);

            if(queue.size()-1 < str.length()) {
                return false;
            }

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(!queue.isEmpty()){
                    if(!queue.peek().equals("NULL")){
                        queue.addLast(queue.pollFirst()+c);
                    }
                }
            }

            while (!queue.isEmpty() && !queue.peek().equals("NULL")){
                queue.addLast(queue.pollFirst());
            }

            if(queue.peek().equals("NULL")){
                queue.removeFirst();
                queue.addLast("NULL");
            }
            System.out.println(queue);
        }
        int index = 0;
        while(!"NULL".equals(queue.peek())){
           if(!words.get(index++).equals(queue.pollFirst())){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("abcd");
        l.add("bnrt");
        l.add("crm");
        l.add("dt");

        validWordSquare(l);
    }
}