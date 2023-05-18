package sh4k4w4t.github.io.logictask.Services.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
    static String urlForFetchData = "http://59.152.60.149:3362/platform_erp/logic-api/index.php/";
    public static Retrofit retrofit;
    public static RetrofitInterface retrofitInterface;

    public static RetrofitInterface getRetrofitInterface() {
        if (retrofitInterface == null) {
            if (retrofit == null) {
                Gson gson = new GsonBuilder().setLenient().create();

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(7000, TimeUnit.SECONDS)
                        .readTimeout(7000, TimeUnit.SECONDS)
                        .build();

                retrofit = new Retrofit.Builder()
                        .baseUrl(urlForFetchData)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            retrofitInterface = retrofit.create(RetrofitInterface.class);
            return retrofitInterface;
        }
        return retrofitInterface;
    }
}
