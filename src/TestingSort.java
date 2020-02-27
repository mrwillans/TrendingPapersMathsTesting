import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestingSort {

    public static JSONArray sortJSONArray(JSONArray inputArray, String key) {
        List<JSONObject> inputArrayAsList = new ArrayList<JSONObject>();
        for (int i = 0; i < inputArray.length(); i++)
            inputArrayAsList.add(inputArray.getJSONObject(i));

        Collections.sort(inputArrayAsList, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject jsonObjectA, JSONObject jsonObjectB) {
                int compare = 0;

                int A = jsonObjectA.getInt(key);
                int B = jsonObjectB.getInt(key);
                compare = Integer.compare(A, B);

                return compare;
            }
        });
        inputArray = new JSONArray();
        for (int i = 0; i < inputArrayAsList.size(); i++) {
            inputArray.put(inputArrayAsList.get(i));
        }
        return inputArray;
    }

    public static void main(String[] args) {


        JSONObject a = new JSONObject();
        JSONObject b = new JSONObject();
        JSONObject c = new JSONObject();

        a.put("year", 2020);
        b.put("year", 2012);
        c.put("year", 2019);

        JSONArray jArray = new JSONArray();


        jArray.put(c);
        jArray.put(b);
        jArray.put(a);

        jArray = sortJSONArray(jArray, "year");
        //sort years (do not rely the source to have the data sorted)


        System.out.println(jArray.toString());

    }

}
