package WeekTwo;

import java.io.InputStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/28/16.
 */
public class LinkFinder {
    private static final String pattern = "(.*)(\".*\")(.*)";
    private static final String testInput = "Hey \"girl\", hey!";

    private Iterator<String> links;

    public void processPage(InputStream in) {
        Pattern p = Pattern.compile("(.*)(\".*\")(.*)");
        Matcher m = p.matcher(in.toString());
        boolean matches = m.matches();

        System.out.println(in);

        if (matches) {

        }
    }

    public Iterator<String> getLinks() {
        return links;
    }

    public static void main(String[] args) {
        Pattern testing = Pattern.compile(pattern);
        Matcher matcher = testing.matcher(testInput);

        if (matcher.matches()) {
            System.out.println(matcher.group(2));
        } else {
            System.out.println("Try again.");
        }
    }
}
