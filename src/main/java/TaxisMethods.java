import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxisMethods {

    HttpClient newHttpClient = new HttpClient();

    String numOfTaxis(String city) throws IOException {
        JSONArray taxis = newHttpClient.GetTaxisCall("http://130.211.103.134:4000/api/v1/taxis/"+city);
        Integer numberOfTaxis = taxis.length();
        return numberOfTaxis.toString();

    }

    String taxisNameList() throws IOException {
        List<String> taxiNames = new ArrayList<>();
        JSONArray taxis = newHttpClient.GetTaxisCall("http://130.211.103.134:4000/api/v1/taxis/");


        for (int i = 0; i < taxis.length(); i++) {
            taxiNames.add(taxis.getJSONObject(i).getString("name"));

        }

        return taxiNames.toString();
    }

    String hireTaxi()throws IOException{
       JSONObject hire = newHttpClient.PostHiredTaxi("http://130.211.103.134:4000/api/v1/taxis/Madrid/Skoda4");
       String taxiStatus = hire.get("state").toString();

        return taxiStatus;
    }


}
