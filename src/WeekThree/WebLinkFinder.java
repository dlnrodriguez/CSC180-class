package WeekThree;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by DLN on 7/25/16.
 */
class WebLinkFinder {
    private LinkIterator iterator;
    private ArrayList<String> toVisit, hasVisited;
    private int max = 50;
    private String startingUrl;

    WebLinkFinder() {
        this.toVisit = new ArrayList<>();
        this.hasVisited = new ArrayList<>(max);
        this.startingUrl = "http://shalladay-iis1.student.neumont.edu";
        try {
            this.iterator = new LinkIterator(new URL(this.startingUrl));
            findLinks();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        print();
    }

    private void findLinks() throws IOException {
        while (this.iterator.hasNext() && max > 0) {
            if (this.toVisit.size() > 0
                    && !this.toVisit.get(0).isEmpty()) {
                this.hasVisited.add(this.toVisit.get(0));
                this.toVisit.remove(0);
            }
            if (check(this.toVisit, this.iterator.next()))
                check(this.toVisit, this.iterator.next());
        }
        while (!this.iterator.hasNext()) {
            visit();
        }
    }

    private boolean check(ArrayList<String> it, String st) {
        if (it.iterator().hasNext()) {
            for (String s : it)
                if (s.equalsIgnoreCase(st))
                    return false;
            for (String s : this.hasVisited)
                if (s.equalsIgnoreCase(st))
                    return false;
        }
        --max;
        return it.add(st);
    }

    private void visit() throws IOException {
        String s = this.toVisit.get(0);
        this.iterator = new LinkIterator(new URL(this.startingUrl + s));
        findLinks();
    }

    void print() {
        this.hasVisited.forEach(System.out::println);
        System.out.println(max);
        this.toVisit.forEach(System.out::println);
    }
}
