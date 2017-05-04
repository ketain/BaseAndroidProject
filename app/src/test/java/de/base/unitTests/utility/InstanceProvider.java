package de.base.unitTests.utility;

import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.robolectric.RuntimeEnvironment;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import de.base.utility.customized_classes.CheckableCookieJar;

/**
 * Created by Sebastian Müller on 27.01.2017.
 */

public class InstanceProvider {

    private static OkHttpClient provideOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpLoggingInterceptor networkInterceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addNetworkInterceptor(networkInterceptor)
                .addInterceptor(interceptor)
                .cookieJar(provideCookieJar()) // catches cookies and appends them to outgoing requests
                .followRedirects(false);

        return builder.build();
    }

    public static Retrofit provideRetrofitInstance(String hostname){
        // create retrofit instance after receiving host address
        return new Retrofit.Builder()
                .baseUrl(hostname+"/")
                .client(provideOkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static CheckableCookieJar provideCookieJar(){
        return new CheckableCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(RuntimeEnvironment.application.getApplicationContext()));
    }
}
