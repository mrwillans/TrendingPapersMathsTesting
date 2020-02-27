import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TestingExtractCount {


    public static void main(String[] args) {

        JSONObject a = new JSONObject();
        JSONObject b = new JSONObject();
        JSONObject c = new JSONObject();

        a.put("count", 2);
        b.put("count", 33);
        c.put("count", 55);

        JSONArray jArray = new JSONArray();


        jArray.put(a);
        jArray.put(b);
        jArray.put(c);

       // for(int i = 0; i < jArray.length(); i++){
//            JSONArray readerStatsByMonthArray = jArray.getJSONObject(i).getJSONArray(DocumentProcessorConstants.ReaderStats.READERS_BY_MONTH_LIST);
//            JSONArray sortedReaderStatsByMonthArray = sortJSONArray(readerStatsByMonthArray, DocumentProcessorConstants.ReaderStats.MONTH_FIELD);
            ArrayList<Integer> readerCount = new ArrayList<>();
            for (int j=0; j < jArray.length(); j++){
                readerCount.add(jArray.getJSONObject(j).getInt("count"));
            }
        System.out.println(readerCount);


        }







}
