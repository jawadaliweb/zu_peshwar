package com.lmkt.zupeshawar.networkManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lmkt.zupeshawar.model.AdvertImages;
import com.lmkt.zupeshawar.model.BicycleStandModel;
import com.lmkt.zupeshawar.model.BusArrival;
import com.lmkt.zupeshawar.model.Distance;
import com.lmkt.zupeshawar.model.EstimatedFare;
import com.lmkt.zupeshawar.model.LeaderBoardModel;
import com.lmkt.zupeshawar.model.MemberShips;
import com.lmkt.zupeshawar.model.Notifications;
import com.lmkt.zupeshawar.model.PackageDetail;
import com.lmkt.zupeshawar.model.QRCode;
import com.lmkt.zupeshawar.model.RechargeHistory;
import com.lmkt.zupeshawar.model.ServiceHours;
import com.lmkt.zupeshawar.model.TokenDetails;
import com.lmkt.zupeshawar.model.TopUpDetails;
import com.lmkt.zupeshawar.model.TravelHistory;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.model.dataModels.Stations;
import com.lmkt.zupeshawar.model.zuCardFeatureModel.NFCWriteStatusResponse;
import java.util.ArrayList;

public class ApiResponseData {
    @SerializedName("accountBalance")
    @Expose
    private String accountBalance;
    @SerializedName("advtImages")
    @Expose
    private ArrayList<AdvertImages> advertImages;
    @SerializedName("arrivals")
    @Expose
    private ArrayList<BusArrival> arrivals;
    @SerializedName("sites")
    @Expose
    private ArrayList<BicycleStandModel> bicycleStands;
    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;
    @SerializedName("cardUpdatedBalance")
    @Expose
    private int cardUpdatedBalance;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("depositDate")
    @Expose
    private String depositDate;
    @SerializedName("distance")
    @Expose
    private Distance distance;
    @SerializedName("estimatedFares")
    @Expose
    private ArrayList<EstimatedFare> estimatedFares;
    @SerializedName("isVerified")
    @Expose
    private boolean isMemberShipVerified;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("lastUpdatedOn")
    @Expose
    private String lastUpdatedOn;
    @SerializedName("LeaderBoard")
    @Expose
    private ArrayList<LeaderBoardModel> leaderBoards;
    @SerializedName("maC2")
    @Expose
    private String macAdd;
    @SerializedName("membershipPolicy")
    @Expose
    private ArrayList<MemberShips> memberShips;
    @SerializedName("notifications")
    @Expose
    private ArrayList<Notifications> notifications;
    @SerializedName("pkgdetails")
    @Expose
    private PackageDetail packageDetail;
    @SerializedName("qrCode")
    @Expose
    private QRCode qrCode;
    @SerializedName("rechargehistory")
    @Expose
    private ArrayList<RechargeHistory> rechargeHistoryList;
    @SerializedName("response")
    @Expose
    public NFCWriteStatusResponse response;
    @SerializedName("schedule")
    @Expose
    private ArrayList<ServiceHours> serviceHours;
    @SerializedName("site")
    @Expose
    private BicycleStandModel station;
    @SerializedName("stops")
    @Expose
    private ArrayList<Stations> stations;
    @SerializedName("amount")
    @Expose
    private int subscriptionAmount;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("tokendetails")
    @Expose
    private TokenDetails tokenDetails;
    @SerializedName("tokenExpirationTime")
    @Expose
    private String tokenExpirationTime;
    @SerializedName("topupdetails")
    @Expose
    private TopUpDetails topUpDetails;
    @SerializedName("transactionID")
    @Expose
    private int transactionID;
    @SerializedName("travelHistory")
    @Expose
    private ArrayList<TravelHistory> travelHistories;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("userdetails")
    @Expose
    private User userDetails;
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("userStatus")
    @Expose
    private int userStatus = -1;
    @SerializedName("verificationCode")
    @Expose
    private String verificationCode;
    @SerializedName("walletUpdatedBalance")
    @Expose
    private int walletUpdatedBalance;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public int getSubscriptionAmount() {
        return this.subscriptionAmount;
    }

    public String getDepositDate() {
        return this.depositDate;
    }

    public PackageDetail getPackageDetail() {
        return this.packageDetail;
    }

    public boolean getMemberShipVerifiedStatus() {
        return this.isMemberShipVerified;
    }

    public BicycleStandModel getStationDetail() {
        return this.station;
    }

    public Distance getDistance() {
        return this.distance;
    }

    public ArrayList<MemberShips> getMemberShips() {
        return this.memberShips;
    }

    public ArrayList<BicycleStandModel> getBicycleStations() {
        return this.bicycleStands;
    }

    public ArrayList<LeaderBoardModel> getLeaderBoards() {
        return this.leaderBoards;
    }

    public User getUserDetails() {
        return this.userDetails;
    }

    public void setUserDetails(User user2) {
        this.userDetails = user2;
    }

    public TokenDetails getTokenDetails() {
        return this.tokenDetails;
    }

    public void setTokenDetails(TokenDetails tokenDetails2) {
        this.tokenDetails = tokenDetails2;
    }

    public int getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(int i) {
        this.userStatus = i;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    public QRCode getQrCode() {
        return this.qrCode;
    }

    public NFCWriteStatusResponse getResponse() {
        return this.response;
    }

    public ArrayList<RechargeHistory> getRechargeHistoryList() {
        return this.rechargeHistoryList;
    }

    public void setRechargeHistoryList(ArrayList<RechargeHistory> arrayList) {
        this.rechargeHistoryList = arrayList;
    }

    public ArrayList<Notifications> getNotifications() {
        return this.notifications;
    }

    public ArrayList<TravelHistory> getTravelHistories() {
        return this.travelHistories;
    }

    public ArrayList<EstimatedFare> getEstimatedFares() {
        return this.estimatedFares;
    }

    public ArrayList<AdvertImages> getAdvertImages() {
        return this.advertImages;
    }

    public String getKey() {
        return this.key;
    }

    public String getData() {
        return this.data;
    }

    public ArrayList<Stations> getStations() {
        return this.stations;
    }

    public ArrayList<BusArrival> getBusArrivals() {
        return this.arrivals;
    }

    public ArrayList<ServiceHours> getServiceHours() {
        return this.serviceHours;
    }

    public TopUpDetails getTopUpDetails() {
        return this.topUpDetails;
    }

    public void setTopUpDetails(TopUpDetails topUpDetails2) {
        this.topUpDetails = topUpDetails2;
    }

    public String getAccountBalance() {
        return this.accountBalance;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getLastUpdatedOn() {
        return this.lastUpdatedOn;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenExpirationTime() {
        return this.tokenExpirationTime;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getWalletUpdatedBalance() {
        return this.walletUpdatedBalance;
    }

    public int getCardUpdatedBalance() {
        return this.cardUpdatedBalance;
    }

    public int getTransactionID() {
        return this.transactionID;
    }

    public String getMacAdd() {
        return this.macAdd;
    }
}
