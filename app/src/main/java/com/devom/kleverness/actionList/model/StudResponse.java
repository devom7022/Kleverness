
package com.devom.kleverness.actionList.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudResponse {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errorId")
    @Expose
    private String errorId;
    @SerializedName("hub")
    @Expose
    private Hub hub;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public Hub getHub() {
        return hub;
    }

    public void setHub(Hub hub) {
        this.hub = hub;
    }

}
