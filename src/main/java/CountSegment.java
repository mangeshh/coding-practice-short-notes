class CountSegment {
    public static int countSegments(String s) {
        if (s.trim().equals("")) return 0;
        int cnt = 0;

        char[] chs = s.toCharArray();
        int length = chs.length;
        int start = 0;
        int lastSpace = 0;

        while (start < length) {
            if (chs[start++] == ' ') {
                if(start != 1) {
                    cnt++;
                }
                lastSpace = start;
                while (start < length && chs[start++] == ' ') {
                    continue;
                }
            }
        }

        while (lastSpace < length) {
            if (chs[lastSpace++] != ' ') {
                cnt = cnt + 1;
                break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int ans = countSegments("    foo    bar");
        System.out.println(ans);
    }
}