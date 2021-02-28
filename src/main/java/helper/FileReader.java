package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static ArrayList<String> readFileIgnoreCatch(String path, String filename) throws FileNotFoundException {
        String filePath = String.format("%s/%s.txt", path, filename);
        LoggerHelper.log(LoggerHelper.Log.DEBUG, filePath);
        return read(filePath);
    }

    public static ArrayList<String> readFile(String path, String filename) {

        String filePath = String.format("%s/%s.txt", path, filename);
        LoggerHelper.log(LoggerHelper.Log.INFO, filePath);

        try {
            return read(filePath);
        } catch (FileNotFoundException e) {
            LoggerHelper.log(LoggerHelper.Log.ERROR, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<String> read(String filePath) throws FileNotFoundException {
        File myObj = new File(filePath);
        ArrayList<String> output = new ArrayList<>();
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            output.add(data);
        }
        myReader.close();
        return output;
    }

    public static void writeFile(String path, String filename, String towrite) {

        String filePath = String.format("%s/%s", path, filename);
        LoggerHelper.log(LoggerHelper.Log.INFO, filePath);
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(towrite);
            myWriter.close();
            LoggerHelper.log(LoggerHelper.Log.INFO, "Successfully wrote to the file.");
        } catch (IOException e) {
            LoggerHelper.log(LoggerHelper.Log.ERROR, e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
