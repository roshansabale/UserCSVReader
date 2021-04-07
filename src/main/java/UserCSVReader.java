import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UserCSVReader {
    static final String FILE_NAME = "D:\\java work\\BridgeLabzProjectsAssignments\\OpenCSV\\Resource\\User1.csv";
    static final String GSON_FILE_NAME = "D:\\java work\\BridgeLabzProjectsAssignments\\OpenCSV\\Resource\\User.json";

    public static void main(String[] args) throws IOException {
        try {
            Reader bufferedReader = Files.newBufferedReader(Paths.get(FILE_NAME));
            CsvToBean<User> csvToBean = new CsvToBeanBuilder(bufferedReader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<User> users = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(users);
            FileWriter writer = new FileWriter(GSON_FILE_NAME);
            writer.write(json);
            writer.close();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(GSON_FILE_NAME));
            User[] objects = gson.fromJson(bufferedReader1,User[].class);
            List<User> userlist = Arrays.asList(objects);
            for (User user : users) {
                System.out.println("Name -> " + user.getName());
                System.out.println("Email -> " + user.getEmail());
                System.out.println("Phone -> " + user.getPhone());
                System.out.println("Country -> " + user.getCountry());
                System.out.println("=========================");
            }
        }catch (IOException exception) {
            exception.getMessage();
        }
    }
}
