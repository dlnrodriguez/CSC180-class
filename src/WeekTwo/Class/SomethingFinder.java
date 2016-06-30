package WeekTwo.Class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/27/16.
 */
public class SomethingFinder {
    public boolean isStartXXOrEndYY(String s) {
        Pattern p = Pattern.compile("(XX.+)|(.+YY)");
        Matcher m = p.matcher(s);

        boolean matches = m.matches();

        return matches;
    }
}
