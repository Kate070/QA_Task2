import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    private static final String ABSOLUTE_PATH = FileUtils.class.getResource("").getPath().concat(File.separator);
    private static final String ADDRESSES_PATH = FileUtils.class.getResource("task_2_addresses.txt").getPath();
    private static final String TASK_ADDRESSES = "task_%d_addresses_result_%s.txt";

    public static void writeToFile(int taskNumber, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(createFile(taskNumber).getPath());
        fileWriter.write(text);
        fileWriter.close();
    }
    public static Path getAddressesPath(){
        return Path.of(ADDRESSES_PATH);
    }
    private static File createFile(int taskNumber) {
        String newFilePath = ABSOLUTE_PATH.concat(String.format(TASK_ADDRESSES, taskNumber, getCurrentDate()));
        return new File(newFilePath);
    }

    private static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        return formatter.format(new Date());
    }


}

