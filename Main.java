import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(RequestHandler.detectCityId("Moscow"));
        String cityCode = RequestHandler.detectCityId("Moscow");
        System.out.println(cityCode);
        String forecast = RequestHandler.getForecast(cityCode);
        System.out.println(forecast);
    }
}
