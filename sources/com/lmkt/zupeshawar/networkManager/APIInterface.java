package com.lmkt.zupeshawar.networkManager;

import com.google.gson.JsonObject;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModel;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModelTest;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesRequestModel;
import com.lmkt.zupeshawar.model.zuCardFeatureModel.NFCWriteStatusRequest;
import java.util.List;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;

interface APIInterface {
    @GET("NFC/NFCWriteConfirmation")
    Call<ApiResponse> NFCConfirmation(@Header("Authorization") String str, @Query("transactionID") int i, @Query("TAC") String str2, @Query("RechargeTime") String str3, @Query("CardNumber") String str4);

    @POST("NFC/AddNFCTopup")
    Call<ApiResponse> NFCWriteStatus(@Header("Authorization") String str, @Body NFCWriteStatusRequest nFCWriteStatusRequest);

    @GET("BSS/ActivateMemebership")
    Call<ApiResponse> activateMemberShip(@Header("Authorization") String str, @Query("MembershipType") int i);

    @POST("Wallet/RechargeAccount")
    Call<ApiResponse> addTopUp(@Header("Authorization") String str, @Header("Signature") String str2, @Body JsonObject jsonObject);

    @GET("BSS/CancelMembership")
    Call<ApiResponse> cancelMemberShip(@Header("Authorization") String str);

    @GET("BSS/DepositSecurity")
    Call<ApiResponse> depositSecurity(@Header("Authorization") String str);

    @Streaming
    @POST("getRechargeHistory")
    Call<ResponseBody> downloadRechargeHistoryPDF(@Body JsonObject jsonObject);

    @Streaming
    @POST("PDF/getTransactionHistory")
    Call<ResponseBody> downloadTransactionPDF(@Body JsonObject jsonObject);

    @GET("Common/GetAdvtImages")
    Call<ApiResponse> getAdvertImages(@Header("Authorization") String str);

    @GET("BSS/MembershipPolicy")
    Call<ApiResponse> getBSSMemberShip(@Header("Authorization") String str);

    @GET("BSS/TravelHistory")
    Call<ApiResponse> getBSSTravelHistory(@Header("Authorization") String str, @Query("startdate") String str2, @Query("endate") String str3);

    @GET("BSS/GetSiteByID")
    Call<ApiResponse> getBicycleStationDetails(@Header("Authorization") String str, @Query("siteid") int i, @Query("lat") String str2, @Query("lon") String str3);

    @GET("BSS/GetSites")
    Call<ApiResponse> getBicycleStations(@Header("Authorization") String str);

    @GET("Travel/BusArrivals")
    Call<ApiResponse> getBusArrivals(@Header("Authorization") String str, @Query("stationID") int i);

    @GET("Travel/BusScheduledArrivals")
    Call<ApiResponse> getBusSchedule(@Header("Authorization") String str, @Query("queryDate") String str2, @Query("stationID") int i);

    @GET("BSS/ViewDeposit")
    Call<ApiResponse> getDepositedSecurityStatus(@Header("Authorization") String str);

    @GET("Travel/FareEstimation")
    Call<ApiResponse> getFareEstimation(@Header("Authorization") String str, @Query("source") int i, @Query("destination") int i2);

    @GET("Common/GetStaticContent")
    Call<ApiResponse> getHTMLStaticContent(@Header("Authorization") String str, @Query("key") String str2);

    @GET("BSS/ViewLeaderboard")
    Call<ApiResponse> getLeaderBoard(@Header("Authorization") String str);

    @GET("Zuuser/GetUserNotifications")
    Call<ApiResponse> getNotifications(@Header("Authorization") String str);

    @POST("{url}")
    Call<ApiResponse> getOtp(@Path("url") String str, @Body JsonObject jsonObject);

    @GET("Zuuser/GetQRCode")
    Call<ApiResponse> getQRCode(@Header("Authorization") String str, @Query("IsRefresh") boolean z);

    @GET("Wallet/RechargeHistory")
    Call<ApiResponse> getRechargeHistory(@Header("Authorization") String str);

    @GET("Zuuser/RefreshUserToken")
    Call<ApiResponse> getRefreshToken(@Tag String str, @Header("Authorization") String str2, @Query("mobilenumber") String str3, @Query("imei") String str4);

    @POST("getRoutes")
    Call<GenericResponseModel<List<GetRoutesMainModel>>> getRoutes(@Body GetRoutesRequestModel getRoutesRequestModel);

    @POST("getjourneydetails")
    Call<GenericResponseModel<List<GetRoutesMainModelTest>>> getRoutesTest(@Body GetRoutesRequestModel getRoutesRequestModel);

    @GET("Common/GetScheduleImages")
    Call<ApiResponse> getServiceHours(@Header("Authorization") String str);

    @GET("ITS/GetStops")
    Call<ApiResponse> getStops(@Header("Authorization") String str);

    @GET("Travel/TravelHistory")
    Call<ApiResponse> getTravelHistory(@Header("Authorization") String str, @Query("startdate") String str2, @Query("endate") String str3);

    @GET("Zuuser/GetUser")
    Call<ApiResponse> getUser(@Header("Authorization") String str, @Query("MobileNumber") String str2);

    @GET("Wallet/GetAccountBalance")
    Call<ApiResponse> getUserAccountBalance(@Header("Authorization") String str, @Query("userid") String str2);

    @GET("BSS/UserMembership")
    Call<ApiResponse> getUserMemberShip(@Header("Authorization") String str);

    @POST("Zuuser/NotificationSettings")
    Call<ApiResponse> notificationOnOff(@Header("Authorization") String str, @Body JsonObject jsonObject);

    @POST("Zuuser/CreateUserTicket")
    Call<ApiResponse> postUserTicket(@Header("Authorization") String str, @Body RequestBody requestBody);

    @GET("BSS/RefundSecurity")
    Call<ApiResponse> refundSecurity(@Header("Authorization") String str);

    @POST("Zuuser/Register")
    Call<ApiResponse> registerUser(@Header("Authorization") String str, @Body JsonObject jsonObject);

    @GET("BSS/RentBike")
    Call<ApiResponse> rentBicycle(@Header("Authorization") String str, @Query("QRCode") String str2);
}
