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
    private int max = 100;
    private String startingUrl;

    WebLinkFinder(String startingUrl) {
        this.toVisit = new ArrayList<>();
        this.hasVisited = new ArrayList<>(max);
        this.startingUrl = startingUrl;
        try {
            this.iterator = new LinkIterator(new URL(this.startingUrl));
            findLinks();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    WebLinkFinder(String startingUrl, int maxNofSitesToVisit) {
        this(startingUrl);
        this.max = maxNofSitesToVisit;
        this.hasVisited = new ArrayList<>(max);
    }

    private void findLinks() throws IOException {
        while (this.iterator.hasNext() && max > 0) {
            if (check(this.toVisit, this.iterator.next()))
                check(this.toVisit, this.iterator.next());
            //else System.err.println(this.iterator.next());
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
                if (s.contentEquals(st))
                    return false;
        }
        --max;
        return it.add(st);
    }

    private void visit() throws IOException {
        if (this.toVisit.size() == 1) {
            if (check(this.hasVisited, this.toVisit.get(0))) {
                System.out.println("\n\t++ NO MORE PAGES TO VISIT ++\n");
                print();
                System.exit('E');
            }
        } else if (this.toVisit.size() > 0) {
            String s = this.toVisit.get(0);
            this.iterator = new LinkIterator(new URL(this.startingUrl + s));
            this.hasVisited.add(this.toVisit.get(0));
            this.toVisit.remove(0);
        }

        findLinks();
    }

    private void print() {
        this.hasVisited.forEach(System.out::println);
        System.out.println(max);
        this.toVisit.forEach(System.out::println);
    }

}
