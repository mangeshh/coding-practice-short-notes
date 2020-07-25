import java.util.*;


class IntervalComp implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2){
        return i1.start - i2.start;
    }
}

class SolutionMerge {

    public  static List<Interval> getList(Stack<Interval> stack){
        List<Interval> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        Stack<Interval> stack = new Stack();
        stack.push(intervals.get(0));

        for(int i =1; i < intervals.size(); i++){

            Interval iTemp = intervals.get(i);
            Interval sTemp = stack.peek();
            if(sTemp.end < iTemp.start){
                stack.push(iTemp);
            }else if (iTemp.start < sTemp.end){
                Interval stackPop = stack.pop();
                stackPop.end = Math.max(sTemp.end, iTemp.end);
                stack.push(stackPop);
            }

        }
        return getList(stack);
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        System.out.println(merge(list));


    }
}
