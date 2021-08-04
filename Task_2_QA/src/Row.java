import java.util.HashMap;

public class Row {
    String textNode;
    HashMap<String, String> valuesByHeader;

    Row(String textNode, HashMap<String, String> valuesByHeader) {
        this.textNode = textNode;
        this.valuesByHeader = valuesByHeader;
    }
}