import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RequestHandler {

    final ststic OkHttpClient okHttpClient = new OkHttpClient();
    final static ObjectMapper objectMapper = new ObjectMapper();
    final static String host = "dataservice.accuweather.com";

    public static String detectCityId(String cityName) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter( name: "apikey", value: "FUavpRYxM48QPoBrfra7NsbMWGXkA79P")
                .addQueryParameter( name: "q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader( name: "Accept", value: "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        
        String json = response.body().string();

        String city = objectMapper.readTree(json).get(0).at("/LocalizedName");.asText();
        System.out.println(city);
        String code = objectMapper.readTree(json).get(0).at("/Key");.asText();

        return code;

    }
    public static String getForecast(String cityCode) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservise.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegments(cityCode)
                .addQueryParameter( name: "apikey", value: "FUavpRYxM48QPoBrfra7NsbMWGXkA79P")
                .addQueryParameter( name: "metric", value: "trye")
                .build();

        Request request = new Request.Builder()
                .addHeader( name: "Accept", value: "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String city = objectMapper.readTree(json).get(0).at("/LocalizedName");.asText();
        System.out.println(city);
        String code = objectMapper.readTree(json).get(0).at("/Key");.asText();

        return json;

    }
    public static String getForecast(String cityCode) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservise.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegments(cityCode)
                .addQueryParameter( name: "apikey", value: "FUavpRYxM48QPoBrfra7NsbMWGXkA79P")
                .addQueryParameter( name: "metric", value: "trye")
                .build();

        Request request = new Request.Builder()
                .addHeader( name: "Accept", value: "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String city = objectMapper.readTree(json).get(0).at("/LocalizedName");.asText();
        System.out.println(city);
        String code = objectMapper.readTree(json).get(0).at("/Key");.asText();

        return json;

    }
}
