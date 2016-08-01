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
    private int max;
    private String startingUrl;

    WebLinkFinder(String startingUrl) {
        this(startingUrl, 100);
    }

    WebLinkFinder(String startingUrl, int maxNofSitesToVisit) {
        this.startingUrl = startingUrl;
        this.max = maxNofSitesToVisit;
        this.toVisit = new ArrayList<>(max);
        this.hasVisited = new ArrayList<>(max);
        try {
            this.iterator = new LinkIterator(new URL(this.startingUrl));
            this.hasVisited.add(startingUrl);
            findLinks();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void findLinks() throws IOException {
        while (this.iterator.hasNext() && max > 0) {
            if (check(this.toVisit, this.iterator.next()))
                check(this.toVisit, this.iterator.next());
        }
        if (!this.iterator.hasNext() && !this.toVisit.isEmpty() || max == 0) {
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
        max--;
        return it.add(st);
    }

    private void visit() throws IOException {
        if (this.toVisit.size() == 1) {
            if (check(this.hasVisited, this.toVisit.get(0))) {
                this.toVisit.clear();
                System.out.println("\n\t++ NO MORE PAGES TO VISIT ++\n");
            }
        } else if (this.toVisit.size() > 0) {
            String s = this.toVisit.get(0);
            this.iterator = new LinkIterator(new URL(this.startingUrl + s));
            this.hasVisited.add(this.toVisit.get(0));
            this.toVisit.remove(0);
        }

        findLinks();
    }

    protected void print() {
        this.hasVisited.forEach(System.out::println);
        System.out.println("\n+++\n");
        this.toVisit.forEach(System.out::println);
    }

    protected boolean hasDuplicates() {
        //this.hasVisited.add("/Horse/Biology.html");
        for (int j = 0; j < this.hasVisited.size(); j++)
            for (int k = j + 1; k < this.hasVisited.size(); k++)
                if (this.hasVisited.get(j).equalsIgnoreCase(this.hasVisited.get(k)))
                    return true;
        return false;
    }

}
