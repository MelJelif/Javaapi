package dz2.dz2;

import java.io.FileReader; import java.io.FileWriter; import java.io.IOException; import java.util.logging.FileHandler; import java.util.logging.Level; import java.util.logging.Logger; import org.json.JSONArray; import org.json.JSONException; import org.json.JSONObject;

public class Main {

public static void main(String[] args) {
    try {
        // Читаем исходную строку из файла
        FileReader fileReader = new FileReader("input.txt");
        StringBuilder jsonString = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1) {
            jsonString.append((char) ch);
        }
        fileReader.close();
        
        // Парсим JSON строку
        JSONArray jsonArray = new JSONArray(jsonString.toString());
        
        // Создаем StringBuilder для ответа
        StringBuilder answer = new StringBuilder();
        
        // Перебираем объекты в массиве
        for (Object obj : jsonArray) {
            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;
                
                // Получаем значения полей
                String фамилия = jsonObject.getString("фамилия");
                String оценка = jsonObject.getString("оценка");
                String предмет = jsonObject.getString("предмет");
                
                // Формируем ответ и добавляем его к StringBuilder
                String studentInfo = "Студент " + фамилия + " получил " + оценка + " по предмету " + предмет + ".";
                answer.append(studentInfo).append("\n");
            }
        }
        
        // Записываем результат в файл
        writeToFile("output.txt", answer.toString());
    } catch (IOException | JSONException e) {
        // Логируем ошибки
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("error.log");
            logger.addHandler(fileHandler);
            logger.log(Level.SEVERE, e.getMessage(), e);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

// Метод для записи данных в файл
private static void writeToFile(String filename, String data) throws IOException {
    FileWriter fileWriter = new FileWriter(filename);
    fileWriter.write(data);
    fileWriter.close();
}

// Метод для сортировки массива методом пузырька
public static void bubbleSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Переставляем элементы, если текущий больше следующего
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        
        // Записываем промежуточный результат в лог-файл
        writeLog("iteration.log", array);
    }
}

// Метод для записи данных в лог-файл
private static void writeLog(String filename, int[] array) {
    try {
        FileWriter fileWriter = new FileWriter(filename, true);
        for (int num : array) {
            fileWriter.write(num + " ");
        }
        fileWriter.write("\n");
        fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

// Пример использования алгоритма сортировки пузырьком public class Main { public static void main(String[] args)