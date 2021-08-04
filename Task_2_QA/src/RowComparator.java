import java.util.Comparator;

class RowComparator implements Comparator<Row> {
    private String compareKey;

    RowComparator(String compareKey) {
        this.compareKey = compareKey;
    }

    @Override
    public int compare(Row o1, Row o2) {
        return Integer.parseInt(o2.valuesByHeader.get(compareKey)) - Integer.parseInt(o1.valuesByHeader.get(compareKey));
    }
}