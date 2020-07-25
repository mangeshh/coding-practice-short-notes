package code.course.extra;

import javax.script.Compilable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateXOR {


    public static void main(String[] args)  {
        String x= "[(aaa1,211,s1ss121),(bbb1,411,sss12)]";
        Matcher m = Pattern.compile("(.*?\\w+){3}").matcher(x);

        while(m.find()) {
            System.out.println(m.group(1).replace(",","" ));
        }
    }

    public static void main1(String[] args) {
        int array[] = {1, 1, 2, 2, 6};
        int ans = array[0];

        for (int i = 1; i < array.length; i++) {
            ans ^= array[i] ^ (i + 1);
        }

        System.out.println(ans);
    }
}
