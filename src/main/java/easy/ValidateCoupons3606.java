package easy;

import java.util.*;
import java.util.regex.Pattern;

public class ValidateCoupons3606 {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        final String CUPON_REGEX = "^[a-zA-Z0-9_]+$";
        HashSet<String> BUSINESS_LINES_EXIST = new HashSet<>(Set.of("electronics", "grocery", "pharmacy", "restaurant"));
        List<String[]> ans = new ArrayList<>(code.length);

        for (int i = 0; i < code.length; i++) {
            if (code[i].matches(CUPON_REGEX) && BUSINESS_LINES_EXIST.contains(businessLine[i]) && isActive[i]) {
                ans.add(new String[]{code[i], businessLine[i]});
            }
        }

        return ans.stream().sorted((e1, e2) -> {
            int businessCompare = e1[1].compareTo(e2[1]);

            if (businessCompare == 0) {
                return e1[0].compareTo(e2[0]);
            }

            return businessCompare;
        }).map(e -> e[0]).toList();
    }
}
