public class Test {

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(0, 3));
        System.exit(1);
        StringBuilder sb = new StringBuilder();
        sb.insert(0, "a ");
        sb.insert(0, "b ");
        sb.insert(0, "c ");
        sb.insert(0, "d ");
        sb.insert(0, "e ");
        System.out.println(sb.toString());
        sb = new StringBuilder();
        sb.append("a ");
        sb.append("b ");        sb.append("c ");
        sb.append("d ");
        sb.append("e ");
        System.out.println(sb.toString());
    }
}
