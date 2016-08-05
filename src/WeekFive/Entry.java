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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (value != entry.value) return false;
        if (link != entry.link) return false;
        return string != null ? string.equals(entry.string) : entry.string == null;

    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        result = 31 * result + (int) (value ^ (value >>> 32));
        result = 31 * result + (int) (link ^ (link >>> 32));
        return result;
    }
}
