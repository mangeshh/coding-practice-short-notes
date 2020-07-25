package code.course;

@SuppressWarnings("unused")
public class PossibleUpperLowerCases {

    public static String modifyString(String str, int index){
        if(index == str.length()-1){
            return str;
        }
        int i;
        for(i = index; i< str.length(); i++){
            char c = str.charAt(index);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                index = i;
                break;
            }
        }

        String s1;
        String s2;

        if(i == 0){
            s1 = str.charAt(i)+"".toLowerCase() + str.substring(i+1, str.length());
            s2 = str.charAt(i)+"".toUpperCase() + str.substring(i+1, str.length());
        }else{
            s1 = str.substring(0, i-1) + str.charAt(i)+"".toLowerCase() + str.substring(i+1, str.length()-1);
            s2 = str.substring(0, i-1) + str.charAt(i)+"".toUpperCase() + str.substring(i+1, str.length()-1);
        }

        return modifyString(s1, i+1 ) + modifyString(s2, i+1 );
    }

    public static void main(String[] args) {

        String s = "ab12c";
        System.out.println(modifyString(s, 0));


    }
}
