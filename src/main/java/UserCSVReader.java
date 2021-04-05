import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class UserCSVReader {
    static final String FILE_NAME = "D:\\java work\\BridgeLabzProjectsAssignments\\OpenCSV\\Resource\\User.csv";
    public static void main(String[] args) throws IOException {
        Reader bufferedReader = Files.newBufferedReader(Paths.get(FILE_NAME));
        CsvToBean<User> csvToBean = new CsvToBeanBuilder(bufferedReader).withType(User.class).withIgnoreLeadingWhiteSpace(true).build();
        List<User> iterator = csvToBean.parse();
        System.out.println(iterator);
       /* while(iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user);
        }*/
    }
}
