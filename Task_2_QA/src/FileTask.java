import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileTask {

    public static void createFiltredFile() {
        String resultString = "";
        String scannedString = "";
        String streetToDelete =  getUserInput();
        try (Scanner scanner = new Scanner(FileUtils.getAddressesPath())) {
            while (scanner.hasNextLine()) {
                scannedString = scanner.nextLine();
                if (!scannedString.contains(streetToDelete)) {
                    resultString += scannedString.concat("\n");
                } else {
                    scanner.nextLine();
                }
            }
            FileUtils.writeToFile( 1, resultString);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void createSortedFile() {
        List<String> headerValues = new ArrayList<>();
        List<Row> rows = new ArrayList<>();
        String scannedString = "";
        String resultString = "";
        boolean isHeaderBeenRead = false;
        try {
            Scanner scanner = new Scanner(FileUtils.getAddressesPath());
            while (scanner.hasNextLine()) {
                scannedString = scanner.nextLine();
                if (!isHeaderBeenRead) {
                    resultString += scannedString.concat("\n");
                    if (!isBlankContent(scannedString)) {
                        for (String value : getSplittedValues(scannedString)) {
                            headerValues.add(value.strip());
                        }
                        resultString += scanner.nextLine().concat("\n");
                        isHeaderBeenRead = true;
                    }
                } else {
                    HashMap<String, String> valuesByHeader = new HashMap<>();
                    String[] values = getSplittedValues(scannedString);
                    for (int i = 0; i < values.length; i++) {
                        valuesByHeader.put(headerValues.get(i), values[i].strip());
                    }
                    rows.add(new Row(scannedString.concat("\n" + scanner.nextLine() + "\n"), valuesByHeader));
                }
            }
            FileUtils.writeToFile(2, resultString.concat(getSortedRowsString(rows)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private static String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        String streetToDelete = userInput.nextLine() ;
        return streetToDelete.isBlank() ? "Радищева" : streetToDelete;
    }
    private static boolean isBlankContent(String content) {
        return content.replaceAll("[\\s|_]", "").isBlank();
    }

    private static String[] getSplittedValues(String content) {
        return content.split("\\|");
    }

    private static String getSortedRowsString(List<Row> rows) {
        rows.sort(new RowComparator("Количество жителей"));
        String sortedRows = "";
        for (Row row : rows) {
            sortedRows += row.textNode;
        }
        return sortedRows;
    }
}
