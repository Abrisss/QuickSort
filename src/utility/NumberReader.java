package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Abraham on 2015. 09. 23..
 */
public class NumberReader {

    JSONParser parser;

    public NumberReader() {
        parser = new JSONParser();
    }

    public MyArrayList<Integer> parseNumbers(String fileName) {
        MyArrayList<Integer> returnThings = null;
        try {
            File file = loadFile(fileName);
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            returnThings = new MyArrayList<>();

            JSONArray thingsArray = (JSONArray) jsonObject.get("numbers");
            Iterator<Long> thingsIterator = thingsArray.iterator();
            while (thingsIterator.hasNext()) {
                returnThings.add(thingsIterator.next().intValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnThings;
    }

    private File loadFile(String fileName) {
        return new File(NumberReader.class.getClassLoader().getResource("resources/" + fileName).getPath());
    }
}
