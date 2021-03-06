package WeekThree;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by DLN on 7/25/16.
 */
class WebLinkFinder implements VisitAction {
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
            visit(this.toVisit.get(0));
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

    public void visit(String s) {
        if (this.toVisit.size() == 1) {
            if (check(this.hasVisited, this.toVisit.get(0))) {
                this.toVisit.clear();
            }
        } else {
            String slash;

            if (s.startsWith("/")) slash = this.startingUrl;
            else slash = "";

            try {
                this.iterator = new LinkIterator(new URL(slash + s));
                this.hasVisited.add(s);
                this.toVisit.remove(0);
                findLinks();
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    protected boolean hasDuplicates() {
        for (int j = 0; j < this.hasVisited.size(); j++)
            for (int k = j + 1; k < this.hasVisited.size(); k++)
                if (this.hasVisited.get(j).equalsIgnoreCase(this.hasVisited.get(k)))
                    return true;
        return false;
    }
}