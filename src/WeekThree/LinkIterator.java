package WeekThree;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 7/8/16.
 */
public class LinkIterator implements Iterator<String> {
    private Scanner in;
    private String linkFound;
    private Pattern pattern = Pattern.compile("(.*?)(a\\s+href\\s*=\\s*)\"(\\S*)\"(.*)", Pattern.CASE_INSENSITIVE);

    LinkIterator(InputStream in) {
        this.in = new Scanner(in);
    }

    @Override
    public boolean hasNext() {
        this.linkFound = null;
        while (this.linkFound == null) {
            String line = in.nextLine();
            Matcher link = pattern.matcher(line);
            boolean matches = link.matches();
            if (matches) {
                this.linkFound = link.group(3);
            }
        }
        return this.linkFound != null;
    }

    @Override
    public String next() {
        return this.linkFound;
    }
}
