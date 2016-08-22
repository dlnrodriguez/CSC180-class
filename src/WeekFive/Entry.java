package WeekFive;

/**
 * Created by DLN on 8/3/16.
 */
public class Entry {
    private String string;
    private long value, link;

    public Entry(String string, long value, long link) {
        this.string = string;
        this.value = value;
        this.link = link;
    }

    public String getString() {
        return string;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getLink() {
        return link;
    }

    public void setLink(long link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "string='" + string + '\'' +
                ", value=" + value +
                ", link=" + link +
                '}';
    }
}
