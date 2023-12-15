package com.lmkt.zupeshawar.networkManager;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.gson.JsonObject;
import com.lmkt.zupeshawar.BuildConfig;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.application.App;
import com.lmkt.zupeshawar.model.CodeMessages;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.TokenDetails;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesRequestModel;
import com.lmkt.zupeshawar.model.zuCardFeatureModel.NFCWriteStatusRequest;
import com.microsoft.appcenter.Constants;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
    private static final String TAG = "APIManager";
    private static final APIManager instance = new APIManager();
    /* access modifiers changed from: private */
    public static boolean updateToken = false;
    private final String headerPassword;
    Call<ApiResponse> requestFalse = null;
    private final Retrofit retrofit;

    public interface Callback {
        void onFailure(int i, String str);

        void onSuccess(int i, ApiResponse apiResponse);
    }

    public interface NetworkResponseCallback<T> {
        void onResult(GenericResponseModel<T> genericResponseModel, Integer num);
    }

    public interface StreamResp {
        void onFailure(int i, String str);

        void onSuccess(int i, InputStream inputStream);
    }

    private APIManager() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).addInterceptor(httpLoggingInterceptor);
        this.retrofit = new Retrofit.Builder().baseUrl("https://brtapp.lmkr.net:5000/api/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(Base64.encodeToString((BuildConfig.userName + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + BuildConfig.userPassword).getBytes(), 2));
        this.headerPassword = sb.toString();
    }

    public static APIManager getInstance() {
        return instance;
    }

    public <T> void getRoutes(NetworkResponseCallback<T> networkResponseCallback, GetRoutesRequestModel getRoutesRequestModel) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).addInterceptor(httpLoggingInterceptor);
        sendRequestMap(networkResponseCallback, ((APIInterface) new Retrofit.Builder().baseUrl(BuildConfig.baseURLLiveNode).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(APIInterface.class)).getRoutes(getRoutesRequestModel));
    }

    public <T> void getRoutesTest(NetworkResponseCallback<T> networkResponseCallback, GetRoutesRequestModel getRoutesRequestModel) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).addInterceptor(httpLoggingInterceptor);
        sendRequestMap(networkResponseCallback, ((APIInterface) new Retrofit.Builder().baseUrl("http://brtapp.lmkr.net/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(APIInterface.class)).getRoutesTest(getRoutesRequestModel));
    }

    public <T> void refreshToken(Callback callback, Call<T> call) {
        this.requestFalse = call;
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(Base64.encodeToString((BuildConfig.userName + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + BuildConfig.userPassword).getBytes(), 2));
        String sb2 = sb.toString();
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(App.getInstance().getApplicationContext());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getRefreshToken("refreshTokenApi", sb2, userObject_Prefrences.getMobileNumber(), userObject_Prefrences.getImei()), true);
    }

    public void getUser(Callback callback, String str) {
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getUser(this.headerPassword, str), false);
    }

    public void registerUser(Callback callback, JsonObject jsonObject) {
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).registerUser(this.headerPassword, jsonObject), false);
    }

    public void getAdvertImages(Callback callback, String str) {
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getAdvertImages(str), false);
    }

    public void getUserAccountBalance(Callback callback, String str, String str2) {
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getUserAccountBalance(str, str2), false);
    }

    public void getTravelHistory(Callback callback, String str, String str2, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getTravelHistory(sb.toString(), str, str2), false);
    }

    public void getBSSTravelHistory(Callback callback, String str, String str2, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getBSSTravelHistory(sb.toString(), str, str2), false);
    }

    public void getRechargeHistory(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getRechargeHistory(sb.toString()), false);
    }

    public void getHTMLStaticContent(Callback callback, String str, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getHTMLStaticContent(sb.toString(), str), false);
    }

    public void getQRCode(Callback callback, boolean z, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getQRCode(sb.toString(), z), false);
    }

    public void getNotifications(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getNotifications(sb.toString()), false);
    }

    public void getFareEstimation(Callback callback, int i, int i2, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getFareEstimation(sb.toString(), i, i2), false);
    }

    public void getBicycleStation(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getBicycleStations(sb.toString()), false);
    }

    public void getLeaderBoard(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getLeaderBoard(sb.toString()), false);
    }

    public void getBicycleStationDetails(Callback callback, int i, double d, double d2, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getBicycleStationDetails(sb.toString(), i, String.valueOf(d), String.valueOf(d2)), false);
    }

    public void getStops(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getStops(sb.toString()), false);
    }

    public void getServiceHours(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getServiceHours(sb.toString()), false);
    }

    public void postUserTicket(Callback callback, RequestBody requestBody, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).postUserTicket(sb.toString(), requestBody), false);
    }

    public void getBusArrivals(Callback callback, int i, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getBusArrivals(sb.toString(), i), false);
    }

    public void getBusSchedule(Callback callback, String str, int i, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getBusSchedule(sb.toString(), str, i), false);
    }

    public void notificationOnOff(Callback callback, JsonObject jsonObject, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).notificationOnOff(sb.toString(), jsonObject), false);
    }

    public void addTopUp(Callback callback, JsonObject jsonObject, String str, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).addTopUp(sb.toString(), str, jsonObject), false);
    }

    public void NFCBalanceWriteRequest(Callback callback, NFCWriteStatusRequest nFCWriteStatusRequest, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).NFCWriteStatus(sb.toString(), nFCWriteStatusRequest), false);
    }

    public void NFCConfirmationReq(Callback callback, String str, String str2, int i, String str3, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).NFCConfirmation(sb.toString(), i, str2, str3, str), false);
    }

    public void getMemberShip(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getBSSMemberShip(sb.toString()), false);
    }

    public void activateMemberShip(Callback callback, int i, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).activateMemberShip(sb.toString(), i), false);
    }

    public void getUserMemberShip(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getUserMemberShip(sb.toString()), false);
    }

    public void cancelUserMemberShip(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).cancelMemberShip(sb.toString()), false);
    }

    public void getDepositedSecurityStatus(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).getDepositedSecurityStatus(sb.toString()), false);
    }

    public void refundSecurity(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).refundSecurity(sb.toString()), false);
    }

    public void depositSecurity(Callback callback, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).depositSecurity(sb.toString()), false);
    }

    public void rentQRCode(Callback callback, String str, Context context) {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(context);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        TokenDetails tokenDetails = userObject_Prefrences.getTokenDetails();
        Objects.requireNonNull(tokenDetails);
        sb.append(tokenDetails.getToken());
        sendRequest(callback, ((APIInterface) this.retrofit.create(APIInterface.class)).rentBicycle(sb.toString(), str), false);
    }

    public void sendOTP(final Callback callback, String str, JsonObject jsonObject) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).addInterceptor(httpLoggingInterceptor).addInterceptor(new BasicAuthInterceptor("admin", "SdQ+r68VHkDyumWKSOOFGg=="));
        ((APIInterface) new Retrofit.Builder().baseUrl("https://brtapp.lmkr.net:5000/api/OTP/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(APIInterface.class)).getOtp(str, jsonObject).enqueue(new retrofit2.Callback<ApiResponse>() {
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.body() != null) {
                    if (response.code() == ReturnCodes.Companion.OK()) {
                        callback.onSuccess(response.code(), response.body());
                    } else {
                        callback.onFailure(response.code(), response.message());
                    }
                } else if (response.errorBody() != null) {
                    callback.onFailure(response.code(), response.message());
                }
            }

            public void onFailure(Call<ApiResponse> call, Throwable th) {
                th.fillInStackTrace();
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) {
                    callback.onFailure(-1, "Fail to Connect to Server\nPlease try again later.");
                } else {
                    callback.onFailure(-1, th.getMessage());
                }
            }
        });
    }

    public void downloadTransactionPDF(final StreamResp streamResp, JsonObject jsonObject, Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).addInterceptor(new BasicAuthInterceptor("admin", "SdQ+r68VHkDyumWKSOOFGg=="));
        ((APIInterface) new Retrofit.Builder().baseUrl("https://brtapp.lmkr.net:5000/api/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(APIInterface.class)).downloadTransactionPDF(jsonObject).enqueue(new retrofit2.Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    if (response.code() == ReturnCodes.Companion.OK()) {
                        streamResp.onSuccess(response.code(), response.body().byteStream());
                    } else {
                        streamResp.onFailure(response.code(), response.message());
                    }
                } else if (response.errorBody() != null) {
                    streamResp.onFailure(response.code(), response.message());
                }
            }

            public void onFailure(Call<ResponseBody> call, Throwable th) {
                th.fillInStackTrace();
                StreamResp streamResp = streamResp;
                if (streamResp == null) {
                    return;
                }
                if ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) {
                    streamResp.onFailure(-1, "Fail to Connect to Server\nPlease try again later.");
                } else {
                    streamResp.onFailure(-1, th.getMessage());
                }
            }
        });
    }

    public void downloadRechargePDF(final StreamResp streamResp, JsonObject jsonObject, Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).addInterceptor(new BasicAuthInterceptor("admin", "SdQ+r68VHkDyumWKSOOFGg=="));
        ((APIInterface) new Retrofit.Builder().baseUrl("https://brtapp.lmkr.net:5000/api/PDF/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(APIInterface.class)).downloadRechargeHistoryPDF(jsonObject).enqueue(new retrofit2.Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    if (response.code() == ReturnCodes.Companion.OK()) {
                        streamResp.onSuccess(response.code(), response.body().byteStream());
                    } else {
                        streamResp.onFailure(response.code(), response.message());
                    }
                } else if (response.errorBody() != null) {
                    streamResp.onFailure(response.code(), response.message());
                }
            }

            public void onFailure(Call<ResponseBody> call, Throwable th) {
                th.fillInStackTrace();
                StreamResp streamResp = streamResp;
                if (streamResp == null) {
                    return;
                }
                if ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) {
                    streamResp.onFailure(-1, "Fail to Connect to Server\nPlease try again later.");
                } else {
                    streamResp.onFailure(-1, th.getMessage());
                }
            }
        });
    }

    private <T> void sendRequestMap(final NetworkResponseCallback<T> networkResponseCallback, Call<T> call) {
        call.enqueue(new retrofit2.Callback<T>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<APIManager> cls = APIManager.class;
            }

            public void onResponse(Call<T> call, Response<T> response) {
                if (response.code() == 200 || response.code() == 201) {
                    GenericResponseModel genericResponseModel = (GenericResponseModel) response.body();
                    if (genericResponseModel.getStatus()) {
                        networkResponseCallback.onResult(genericResponseModel, 1);
                    } else {
                        networkResponseCallback.onResult(genericResponseModel, -1);
                    }
                } else {
                    String message = response.message();
                    networkResponseCallback.onResult(new GenericResponseModel(false, message, null, response.code() + ""), -1);
                }
            }

            public void onFailure(Call<T> call, Throwable th) {
                if ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) {
                    networkResponseCallback.onResult(new GenericResponseModel(false, "Fail to Connect to Server\nPlease try again later.", null, "-1"), -1);
                    return;
                }
                networkResponseCallback.onResult(new GenericResponseModel(false, th.getMessage(), null, "-1"), -1);
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> void sendRequest(final Callback callback, final Call<T> call, Boolean bool) {
        updateToken = bool.booleanValue();
        call.enqueue(new retrofit2.Callback<T>() {
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.body() == null) {
                    if (callback != null) {
                        if (response.code() == ReturnCodes.Companion.UNAUTHORIZED()) {
                            APIManager.this.refreshToken(callback, call);
                        } else {
                            callback.onFailure(response.code(), response.message());
                        }
                    }
                    Log.e("Error", "" + response.errorBody().toString());
                } else if (response.body() instanceof ApiResponse) {
                    ApiResponse apiResponse = (ApiResponse) response.body();
                    try {
                        if (callback == null) {
                            return;
                        }
                        if (APIManager.updateToken) {
                            Log.v("After Refresh Token ::", response.message());
                            if (apiResponse.getData() != null) {
                                User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(App.getInstance().getApplicationContext());
                                if (apiResponse.getData().getUserID() != null) {
                                    userObject_Prefrences.setUserID(apiResponse.getData().getUserID());
                                }
                                if (apiResponse.getData().getToken() != null) {
                                    userObject_Prefrences.getTokenDetails().setToken(apiResponse.getData().getToken());
                                }
                                if (apiResponse.getData().getTokenExpirationTime() != null) {
                                    userObject_Prefrences.getTokenDetails().setTokenExpirationTime(apiResponse.getData().getTokenExpirationTime());
                                }
                                SharedPrefrencesUtil.saveUserObject_Prefrences(userObject_Prefrences, App.getInstance().getApplicationContext());
                            }
                            APIManager aPIManager = APIManager.this;
                            aPIManager.sendRequest(callback, aPIManager.requestFalse.clone(), false);
                            return;
                        }
                        if (response.code() != ReturnCodes.Companion.UNAUTHORIZED()) {
                            if (apiResponse.getRespCode().intValue() != ReturnCodes.Companion.UNAUTHORIZED()) {
                                callback.onSuccess(apiResponse.getRespCode().intValue(), apiResponse);
                                return;
                            }
                        }
                        APIManager.this.refreshToken(callback, call);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onFailure(response.code(), CodeMessages.Companion.INTERNAL_SERVER_ERROR());
                    }
                } else if (response.body() instanceof GenericResponseModel) {
                    GenericResponseModel genericResponseModel = (GenericResponseModel) response.body();
                }
            }

            public void onFailure(Call<T> call, Throwable th) {
                th.fillInStackTrace();
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if ((th instanceof SocketTimeoutException) || (th instanceof ConnectException)) {
                    callback.onFailure(-1, "Fail to Connect to Server\nPlease try again later.");
                } else {
                    callback.onFailure(-1, th.getMessage());
                }
            }
        });
    }
}
