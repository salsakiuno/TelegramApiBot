import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClient {

    OkHttpClient client = new OkHttpClient();
    Response responses = null;

    JSONArray GetTaxisCall(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try{
            responses = client.newCall(request).execute();
        }catch (IOException e) {
            e.printStackTrace();
        }

        String resStr = responses.body().string();
        JSONArray json = new JSONArray(resStr);


        return json;
    }

    JSONObject PostHiredTaxi(String url) throws IOException {
        Response responses = null;

        RequestBody formBody = new FormBody.Builder()
                .add("state", "hired")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        try{
            responses = client.newCall(request).execute();
        }catch (IOException e) {
            e.printStackTrace();
        }

        String resStr = responses.body().string();
        JSONObject json = new JSONObject(resStr);;

        return json;

    }
}
