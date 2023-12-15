package com.lmkt.zupeshawar.networkManager;

import com.microsoft.appcenter.Constants;
import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Response;

public class BasicAuthInterceptor implements Interceptor {
    private String credentials;

    public BasicAuthInterceptor(String str, String str2) {
        this.credentials = Credentials.basic(str, str2);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header(Constants.AUTHORIZATION_HEADER, this.credentials).build());
    }
}
