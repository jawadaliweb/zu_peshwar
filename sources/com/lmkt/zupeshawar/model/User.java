package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BÅ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0014HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003J\t\u0010T\u001a\u00020\u0006HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003JÉ\u0001\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010\\\u001a\u00020\u00042\b\u0010]\u001a\u0004\u0018\u00010^HÖ\u0003J\t\u0010_\u001a\u00020\u0014HÖ\u0001J\t\u0010`\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001e\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001e\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001e\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u00101\"\u0004\b2\u00103R\u001e\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR\u001e\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010$\"\u0004\b?\u0010&R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001eR\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00101\"\u0004\bG\u00103¨\u0006a"}, d2 = {"Lcom/lmkt/zupeshawar/model/User;", "Ljava/io/Serializable;", "()V", "isLogged_In", "", "userID", "", "name", "dob", "cnic", "password", "mobileNumber", "email", "gender", "accountBalance", "accountBalanceasOn", "memberSince", "zuBicylce", "packageExpiry", "refundableSecurity", "", "deviceType", "fcmToken", "imei", "tokenDetails", "Lcom/lmkt/zupeshawar/model/TokenDetails;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Lcom/lmkt/zupeshawar/model/TokenDetails;)V", "getAccountBalance", "()Ljava/lang/String;", "setAccountBalance", "(Ljava/lang/String;)V", "getAccountBalanceasOn", "setAccountBalanceasOn", "getCnic", "setCnic", "getDeviceType", "()I", "setDeviceType", "(I)V", "getDob", "setDob", "getEmail", "setEmail", "getFcmToken", "setFcmToken", "getGender", "setGender", "getImei", "setImei", "()Z", "setLogged_In", "(Z)V", "getMemberSince", "setMemberSince", "getMobileNumber", "setMobileNumber", "getName", "setName", "getPackageExpiry", "setPackageExpiry", "getPassword", "setPassword", "getRefundableSecurity", "setRefundableSecurity", "getTokenDetails", "()Lcom/lmkt/zupeshawar/model/TokenDetails;", "setTokenDetails", "(Lcom/lmkt/zupeshawar/model/TokenDetails;)V", "getUserID", "setUserID", "getZuBicylce", "setZuBicylce", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: User.kt */
public final class User implements Serializable {
    @SerializedName("accountBalance")
    private String accountBalance;
    @SerializedName("accountBalanceasOn")
    private String accountBalanceasOn;
    @SerializedName("cnic")
    private String cnic;
    @SerializedName("deviceType")
    private int deviceType;
    @SerializedName("dob")
    private String dob;
    @SerializedName("email")
    private String email;
    @SerializedName("fcmToken")
    private String fcmToken;
    @SerializedName("gender")
    private String gender;
    @SerializedName("imei")
    private String imei;
    private boolean isLogged_In;
    @SerializedName("memberSince")
    private String memberSince;
    @SerializedName("mobileNumber")
    private String mobileNumber;
    @SerializedName("name")
    private String name;
    @SerializedName("packageExpiry")
    private String packageExpiry;
    @SerializedName("password")
    private String password;
    @SerializedName("refundableSecurity")
    private int refundableSecurity;
    @SerializedName("tokendetails")
    private TokenDetails tokenDetails;
    @SerializedName("userID")
    private String userID;
    @SerializedName("zuBicylce")
    private boolean zuBicylce;

    public static /* synthetic */ User copy$default(User user, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z2, String str12, int i, int i2, String str13, String str14, TokenDetails tokenDetails2, int i3, Object obj) {
        User user2 = user;
        int i4 = i3;
        return user.copy((i4 & 1) != 0 ? user2.isLogged_In : z, (i4 & 2) != 0 ? user2.userID : str, (i4 & 4) != 0 ? user2.name : str2, (i4 & 8) != 0 ? user2.dob : str3, (i4 & 16) != 0 ? user2.cnic : str4, (i4 & 32) != 0 ? user2.password : str5, (i4 & 64) != 0 ? user2.mobileNumber : str6, (i4 & 128) != 0 ? user2.email : str7, (i4 & 256) != 0 ? user2.gender : str8, (i4 & 512) != 0 ? user2.accountBalance : str9, (i4 & 1024) != 0 ? user2.accountBalanceasOn : str10, (i4 & 2048) != 0 ? user2.memberSince : str11, (i4 & 4096) != 0 ? user2.zuBicylce : z2, (i4 & 8192) != 0 ? user2.packageExpiry : str12, (i4 & 16384) != 0 ? user2.refundableSecurity : i, (i4 & 32768) != 0 ? user2.deviceType : i2, (i4 & 65536) != 0 ? user2.fcmToken : str13, (i4 & 131072) != 0 ? user2.imei : str14, (i4 & 262144) != 0 ? user2.tokenDetails : tokenDetails2);
    }

    public final boolean component1() {
        return this.isLogged_In;
    }

    public final String component10() {
        return this.accountBalance;
    }

    public final String component11() {
        return this.accountBalanceasOn;
    }

    public final String component12() {
        return this.memberSince;
    }

    public final boolean component13() {
        return this.zuBicylce;
    }

    public final String component14() {
        return this.packageExpiry;
    }

    public final int component15() {
        return this.refundableSecurity;
    }

    public final int component16() {
        return this.deviceType;
    }

    public final String component17() {
        return this.fcmToken;
    }

    public final String component18() {
        return this.imei;
    }

    public final TokenDetails component19() {
        return this.tokenDetails;
    }

    public final String component2() {
        return this.userID;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.dob;
    }

    public final String component5() {
        return this.cnic;
    }

    public final String component6() {
        return this.password;
    }

    public final String component7() {
        return this.mobileNumber;
    }

    public final String component8() {
        return this.email;
    }

    public final String component9() {
        return this.gender;
    }

    public final User copy(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z2, String str12, int i, int i2, String str13, String str14, TokenDetails tokenDetails2) {
        boolean z3 = z;
        Intrinsics.checkNotNullParameter(str, "userID");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "dob");
        Intrinsics.checkNotNullParameter(str4, "cnic");
        Intrinsics.checkNotNullParameter(str5, "password");
        Intrinsics.checkNotNullParameter(str6, "mobileNumber");
        Intrinsics.checkNotNullParameter(str7, "email");
        Intrinsics.checkNotNullParameter(str8, "gender");
        Intrinsics.checkNotNullParameter(str9, "accountBalance");
        Intrinsics.checkNotNullParameter(str10, "accountBalanceasOn");
        Intrinsics.checkNotNullParameter(str11, "memberSince");
        Intrinsics.checkNotNullParameter(str12, "packageExpiry");
        Intrinsics.checkNotNullParameter(str13, "fcmToken");
        Intrinsics.checkNotNullParameter(str14, "imei");
        return new User(z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, z2, str12, i, i2, str13, str14, tokenDetails2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return this.isLogged_In == user.isLogged_In && Intrinsics.areEqual((Object) this.userID, (Object) user.userID) && Intrinsics.areEqual((Object) this.name, (Object) user.name) && Intrinsics.areEqual((Object) this.dob, (Object) user.dob) && Intrinsics.areEqual((Object) this.cnic, (Object) user.cnic) && Intrinsics.areEqual((Object) this.password, (Object) user.password) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) user.mobileNumber) && Intrinsics.areEqual((Object) this.email, (Object) user.email) && Intrinsics.areEqual((Object) this.gender, (Object) user.gender) && Intrinsics.areEqual((Object) this.accountBalance, (Object) user.accountBalance) && Intrinsics.areEqual((Object) this.accountBalanceasOn, (Object) user.accountBalanceasOn) && Intrinsics.areEqual((Object) this.memberSince, (Object) user.memberSince) && this.zuBicylce == user.zuBicylce && Intrinsics.areEqual((Object) this.packageExpiry, (Object) user.packageExpiry) && this.refundableSecurity == user.refundableSecurity && this.deviceType == user.deviceType && Intrinsics.areEqual((Object) this.fcmToken, (Object) user.fcmToken) && Intrinsics.areEqual((Object) this.imei, (Object) user.imei) && Intrinsics.areEqual((Object) this.tokenDetails, (Object) user.tokenDetails);
    }

    public int hashCode() {
        boolean z = this.isLogged_In;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode = (((((((((((((((((((((((z ? 1 : 0) * true) + this.userID.hashCode()) * 31) + this.name.hashCode()) * 31) + this.dob.hashCode()) * 31) + this.cnic.hashCode()) * 31) + this.password.hashCode()) * 31) + this.mobileNumber.hashCode()) * 31) + this.email.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.accountBalance.hashCode()) * 31) + this.accountBalanceasOn.hashCode()) * 31) + this.memberSince.hashCode()) * 31;
        boolean z3 = this.zuBicylce;
        if (!z3) {
            z2 = z3;
        }
        int hashCode2 = (((((((((((hashCode + (z2 ? 1 : 0)) * 31) + this.packageExpiry.hashCode()) * 31) + this.refundableSecurity) * 31) + this.deviceType) * 31) + this.fcmToken.hashCode()) * 31) + this.imei.hashCode()) * 31;
        TokenDetails tokenDetails2 = this.tokenDetails;
        return hashCode2 + (tokenDetails2 == null ? 0 : tokenDetails2.hashCode());
    }

    public String toString() {
        return "User(isLogged_In=" + this.isLogged_In + ", userID=" + this.userID + ", name=" + this.name + ", dob=" + this.dob + ", cnic=" + this.cnic + ", password=" + this.password + ", mobileNumber=" + this.mobileNumber + ", email=" + this.email + ", gender=" + this.gender + ", accountBalance=" + this.accountBalance + ", accountBalanceasOn=" + this.accountBalanceasOn + ", memberSince=" + this.memberSince + ", zuBicylce=" + this.zuBicylce + ", packageExpiry=" + this.packageExpiry + ", refundableSecurity=" + this.refundableSecurity + ", deviceType=" + this.deviceType + ", fcmToken=" + this.fcmToken + ", imei=" + this.imei + ", tokenDetails=" + this.tokenDetails + ')';
    }

    public User(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z2, String str12, int i, int i2, String str13, String str14, TokenDetails tokenDetails2) {
        String str15 = str;
        String str16 = str2;
        String str17 = str3;
        String str18 = str4;
        String str19 = str5;
        String str20 = str6;
        String str21 = str7;
        String str22 = str8;
        String str23 = str9;
        String str24 = str10;
        String str25 = str11;
        String str26 = str12;
        String str27 = str13;
        String str28 = str14;
        Intrinsics.checkNotNullParameter(str15, "userID");
        Intrinsics.checkNotNullParameter(str16, "name");
        Intrinsics.checkNotNullParameter(str17, "dob");
        Intrinsics.checkNotNullParameter(str18, "cnic");
        Intrinsics.checkNotNullParameter(str19, "password");
        Intrinsics.checkNotNullParameter(str20, "mobileNumber");
        Intrinsics.checkNotNullParameter(str21, "email");
        Intrinsics.checkNotNullParameter(str22, "gender");
        Intrinsics.checkNotNullParameter(str23, "accountBalance");
        Intrinsics.checkNotNullParameter(str24, "accountBalanceasOn");
        Intrinsics.checkNotNullParameter(str25, "memberSince");
        Intrinsics.checkNotNullParameter(str26, "packageExpiry");
        Intrinsics.checkNotNullParameter(str27, "fcmToken");
        Intrinsics.checkNotNullParameter(str28, "imei");
        this.isLogged_In = z;
        this.userID = str15;
        this.name = str16;
        this.dob = str17;
        this.cnic = str18;
        this.password = str19;
        this.mobileNumber = str20;
        this.email = str21;
        this.gender = str22;
        this.accountBalance = str23;
        this.accountBalanceasOn = str24;
        this.memberSince = str25;
        this.zuBicylce = z2;
        this.packageExpiry = str26;
        this.refundableSecurity = i;
        this.deviceType = i2;
        this.fcmToken = str27;
        this.imei = str28;
        this.tokenDetails = tokenDetails2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(boolean r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, boolean r33, java.lang.String r34, int r35, int r36, java.lang.String r37, java.lang.String r38, com.lmkt.zupeshawar.model.TokenDetails r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r22
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r4
            goto L_0x001c
        L_0x001a:
            r5 = r23
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r4
            goto L_0x0024
        L_0x0022:
            r6 = r24
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r4
            goto L_0x002c
        L_0x002a:
            r7 = r25
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r4
            goto L_0x0034
        L_0x0032:
            r8 = r26
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r4
            goto L_0x003c
        L_0x003a:
            r9 = r27
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r4
            goto L_0x0044
        L_0x0042:
            r10 = r28
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r4
            goto L_0x004c
        L_0x004a:
            r11 = r29
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r4
            goto L_0x0054
        L_0x0052:
            r12 = r30
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r4
            goto L_0x005c
        L_0x005a:
            r13 = r31
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = r4
            goto L_0x0064
        L_0x0062:
            r14 = r32
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            r15 = 0
            goto L_0x006c
        L_0x006a:
            r15 = r33
        L_0x006c:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0072
            r2 = r4
            goto L_0x0074
        L_0x0072:
            r2 = r34
        L_0x0074:
            r21 = r4
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007c
            r4 = 0
            goto L_0x007e
        L_0x007c:
            r4 = r35
        L_0x007e:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0088
            r16 = 0
            goto L_0x008a
        L_0x0088:
            r16 = r36
        L_0x008a:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0093
            r17 = r21
            goto L_0x0095
        L_0x0093:
            r17 = r37
        L_0x0095:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009e
            r18 = r21
            goto L_0x00a0
        L_0x009e:
            r18 = r38
        L_0x00a0:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00a8
            r0 = 0
            goto L_0x00aa
        L_0x00a8:
            r0 = r39
        L_0x00aa:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r4
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.User.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, int, int, java.lang.String, java.lang.String, com.lmkt.zupeshawar.model.TokenDetails, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean isLogged_In() {
        return this.isLogged_In;
    }

    public final void setLogged_In(boolean z) {
        this.isLogged_In = z;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userID = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getDob() {
        return this.dob;
    }

    public final void setDob(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dob = str;
    }

    public final String getCnic() {
        return this.cnic;
    }

    public final void setCnic(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cnic = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.password = str;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final void setMobileNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mobileNumber = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gender = str;
    }

    public final String getAccountBalance() {
        return this.accountBalance;
    }

    public final void setAccountBalance(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountBalance = str;
    }

    public final String getAccountBalanceasOn() {
        return this.accountBalanceasOn;
    }

    public final void setAccountBalanceasOn(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountBalanceasOn = str;
    }

    public final String getMemberSince() {
        return this.memberSince;
    }

    public final void setMemberSince(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.memberSince = str;
    }

    public final boolean getZuBicylce() {
        return this.zuBicylce;
    }

    public final void setZuBicylce(boolean z) {
        this.zuBicylce = z;
    }

    public final String getPackageExpiry() {
        return this.packageExpiry;
    }

    public final void setPackageExpiry(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageExpiry = str;
    }

    public final int getRefundableSecurity() {
        return this.refundableSecurity;
    }

    public final void setRefundableSecurity(int i) {
        this.refundableSecurity = i;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(int i) {
        this.deviceType = i;
    }

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public final void setFcmToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fcmToken = str;
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imei = str;
    }

    public final TokenDetails getTokenDetails() {
        return this.tokenDetails;
    }

    public final void setTokenDetails(TokenDetails tokenDetails2) {
        this.tokenDetails = tokenDetails2;
    }

    public User() {
        this(false, (String) null, "", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, 0, 0, (String) null, (String) null, (TokenDetails) null, 524283, (DefaultConstructorMarker) null);
    }
}
