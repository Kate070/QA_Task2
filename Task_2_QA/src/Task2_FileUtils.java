import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.*;

public class Task2_FileUtils {
    private static final String ABSOLUTE_PATH = Task2_FileUtils.class.getResource("").getPath();
    private static final String ADDRESSES_PATH = ABSOLUTE_PATH.concat("/task_2_addresses.txt");
    private static final String TASK_ADDRESSES = "task_%s_addresses_result_%s.txt";

    public static void main(String[] args) {
        createNewFile("Радищева");
        sortByResidents();
        List<String> list1 = new LinkedList<>(){{add("Oleg");add("Dima");add("Masha");add("Mira");add("Olga");}};
        List<String> list2 = new LinkedList<>(){{add("Mira");add("Oleg");add("Olga");}};

        compareCollections(list1,list2);

    }


    public static void compareCollections(Collection<String> col1 , Collection<String> col2){
        ArrayList<String> result = new ArrayList<>();
        for (String s : col1) {
            if(!col2.contains(s)){
                result.add(s);
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void createNewFile(String streetToDelete) {
        String resultString = "";
        String scannedString = "";
        if (streetToDelete == null || streetToDelete.isBlank()) {
            Scanner userInput = new Scanner(System.in);
            streetToDelete = userInput.nextLine();
        }
        try (Scanner scanner = new Scanner(Path.of(ADDRESSES_PATH))) {
            while (scanner.hasNextLine()) {
                scannedString = scanner.nextLine();
                if (!scannedString.contains(streetToDelete)) {
                    resultString += scannedString.concat("\n");
                } else {
                    scanner.nextLine();
                }
            }
            writeToFile(createFile(1).getPath(), resultString);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sortByResidents() {
        List<String> headerValues = new ArrayList<>();
        List<Row> rows = new ArrayList<>();
        String header = "";
        String scannedString = "";
        boolean isHeaderBeenRead = false;
        try {
            Scanner scanner = new Scanner(Path.of(ADDRESSES_PATH));
            while (scanner.hasNextLine()) {
                scannedString = scanner.nextLine();
                String textNode = scannedString.concat("\n");
                if (!isHeaderBeenRead) {
                    header += textNode;
                    if (!isBlankContent(scannedString)) {
                        isHeaderBeenRead = true;
                        for (String value : getSplittedValues(scannedString)) {
                            headerValues.add(value.strip());
                        }
                        header += scanner.nextLine().concat("\n");
                    }
                } else {
                    if (!isBlankContent(scannedString)) {
                        HashMap<String, String> valuesByHeader = new HashMap<>();
                        String[] values = getSplittedValues(scannedString);
                        for (int i = 0; i < values.length; i++) {
                            valuesByHeader.put(headerValues.get(i), values[i].strip());
                        }
                        rows.add(new Row(textNode.concat(scanner.nextLine() + "\n"), valuesByHeader));
                    }
                }
            }

            String resultString = header + getSortedRowsString(rows);
            writeToFile(createFile(2).getPath(), resultString);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static String getSortedRowsString(List<Row> rows) {
        rows.sort(new RowComparator("Количество жителей"));
        String sortedRows = "";
        for (Row row : rows) {
            sortedRows += row.textNode;
        }
        return sortedRows;
    }

    private static File createFile(int taskNumber) {
        String newFilePath = ABSOLUTE_PATH.concat(String.format(TASK_ADDRESSES, taskNumber, getCurrentDate()));
        return new File(newFilePath);
    }

    private static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        return formatter.format(new Date());
    }

    private static void writeToFile(String path, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(text);
        fileWriter.close();
    }

    private static boolean isBlankContent(String content) {
        return content.replaceAll("[\\s|_]", "").isBlank();
    }

    private static String[] getSplittedValues(String content) {
        return content.split("\\|");
    }
}

class Row {
    String textNode;
    HashMap<String, String> valuesByHeader;

    Row(String textNode, HashMap<String, String> valuesByHeader) {
        this.textNode = textNode;
        this.valuesByHeader = valuesByHeader;
    }
}

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
