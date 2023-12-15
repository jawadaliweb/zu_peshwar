package com.lmkt.zupeshawar.networkManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("response")
    @Expose
    private ApiResponseData data;
    @SerializedName("returnCode")
    @Expose
    private Integer respCode;
    @SerializedName("message")
    @Expose
    private String respMessage;

    public ApiResponseData getData() {
        return this.data;
    }

    public void setData(ApiResponseData apiResponseData) {
        this.data = apiResponseData;
    }

    public Integer getRespCode() {
        return this.respCode;
    }

    public void setRespCode(Integer num) {
        this.respCode = num;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public void setRespMessage(String str) {
        this.respMessage = str;
    }
}
