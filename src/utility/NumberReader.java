package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Abraham on 2015. 09. 23..
 */
public class NumberReader {

    JSONParser parser;

    public NumberReader() {
        parser = new JSONParser();
    }

    public List<Integer> parseNumbers(String fileName) {
        List<Integer> returnThings = null;
        try {
            File file = loadFile(fileName);
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            returnThings = new ArrayList<>();

            JSONArray thingsArray = (JSONArray) jsonObject.get("numbers");
            Iterator<Integer> thingsIterator = thingsArray.iterator();
            while (thingsIterator.hasNext()) {
                returnThings.add(thingsIterator.next());
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
        return new File(NumberReader.class.getClassLoader().getResource("resources/" + fileName + ".json").getPath());
    }
}
