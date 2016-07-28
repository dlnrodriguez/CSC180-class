package WeekThree;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by DLN on 7/25/16.
 */
class WebLinkFinder {
    private boolean hasLink = false;
    private LinkIterator iterator;
    private ArrayList<String> toVisit, hasVisited;
    private int max = 20;
    private String startingUrl;

    WebLinkFinder() {
        this.toVisit = new ArrayList<>(max);
        this.hasVisited = new ArrayList<>(max);
        this.startingUrl = "http://shalladay-iis1.student.neumont.edu";
        try {
            this.iterator = new LinkIterator(new URL(this.startingUrl));
            findLinks();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void findLinks() throws IOException {
        while (this.iterator.hasNext() && max > 0) {
            if (check(this.toVisit, this.iterator.next())) {
                check(this.toVisit, this.iterator.next());
            }
        }
        while (!this.iterator.hasNext() && max > 0) {
            visit();
        }
    }

    private boolean check(ArrayList<String> it, String st) {
        if (it.iterator().hasNext())
            for (String s : it)
                if (s.equalsIgnoreCase(st))
                    return false;
        max--;
        return it.add(st);
    }

    private void visit() throws IOException {
        for (String s : this.toVisit) {
            this.iterator = new LinkIterator(new URL(this.startingUrl + s));
            if (this.iterator.hasNext()) findLinks();
            else this.hasVisited.add(s);
        }
    }

    private void print() {
        this.toVisit.forEach(System.out::println);
        System.out.println(max);
    }
}
