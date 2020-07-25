public class SolutionLicenseKey {

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? '-' : "");
                sb.append(Character.toUpperCase(S.charAt(i)));
            }
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("abc-asd-cdf-dff", 2));
    }
}
