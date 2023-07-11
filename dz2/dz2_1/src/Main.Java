import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
  
  private static Logger logger = Logger.getLogger(Main.class.getName());
  
  public static void main(String[] args) {
    String inputFilePath = "input.txt";
    String resultFilePath = "result.txt";
    String logFilePath = "log.log";

    // Get the JSON string from the input file
    String jsonString = readJsonFromFile(inputFilePath);
    
    // Parse the string and print the result to the console
    String parsedJson = parseJson(jsonString);
    System.out.println(parsedJson);
    
    // Write the parsed JSON to the result file
    writeToFile(resultFilePath, parsedJson);
    
    // Bubble sort a numeric array
    int[] arr = {5, 3, 1, 4, 2};
    bubbleSort(arr);
  }
  
  private static String readJsonFromFile(String filename) {
    StringBuilder json = new StringBuilder();
    try (FileReader fileReader = new FileReader(filename)) {
      int ch;
      while ((ch = fileReader.read()) != -1) {
        json.append((char)ch);
      }
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error reading json file", e);
    }
    return json.toString();
  }
  
  private static void writeToFile(String filename, String content) {
    try (FileWriter fileWriter = new FileWriter(filename)) {
      fileWriter.write(content);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error writing to file", e);
    }
  }
  
  private static String parseJson(String jsonString) {
    StringBuilder result = new StringBuilder();
    try {
      JSONArray jsonArray = new JSONArray(jsonString);
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject object = jsonArray.getJSONObject(i);
        String surname = object.getString("фамилия");
        String grade = object.getString("оценка");
        String subject = object.getString("предмет");
        result.append("Студент ").append(surname)
            .append(" получил ").append(grade)
            .append(" по предмету ").append(subject).append(".\n");
      }
    } catch (JSONException e) {
      logger.log(Level.SEVERE, "Error parsing json", e);
    }
    return result.toString();
  }
  
  private static void bubbleSort(int[] arr) {
    try {
      FileHandler fileHandler = new FileHandler(logFilePath);
      logger.addHandler(fileHandler);
      SimpleFormatter formatter = new SimpleFormatter();
      fileHandler.setFormatter(formatter);
      
      for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i -
 1; j++) {
          if (arr[j] > arr[j + 1]) {
            // Обмен элементов
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
        logger.log(Level.INFO, Arrays.toString(arr));
      }
      
      logger.removeHandler(fileHandler);
      fileHandler.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error writing to log file", e);
    }
  }
}
