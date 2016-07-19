package WeekThree;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

    LinkIterator(URL url) throws IOException {
        this(url.openStream());
    }

    @Override
    public boolean hasNext() {
        this.linkFound = null;
        String line;
        while (this.linkFound == null && this.in.hasNext()) {
            line = this.in.nextLine();
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
