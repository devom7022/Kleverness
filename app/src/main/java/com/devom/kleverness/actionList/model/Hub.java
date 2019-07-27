
package com.devom.kleverness.actionList.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hub {

    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("isOn")
    @Expose
    private Boolean isOn;
    @SerializedName("aliasHub")
    @Expose
    private String aliasHub;
    @SerializedName("mac")
    @Expose
    private String mac;
    @SerializedName("modelId")
    @Expose
    private Integer modelId;
    @SerializedName("deviceStateId")
    @Expose
    private Integer deviceStateId;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("pubSubIn")
    @Expose
    private String pubSubIn;
    @SerializedName("pubSubOut")
    @Expose
    private String pubSubOut;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("vGrouper")
    @Expose
    private String vGrouper;
    @SerializedName("device")
    @Expose
    private List<Device> device = null;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(Boolean isOn) {
        this.isOn = isOn;
    }

    public String getAliasHub() {
        return aliasHub;
    }

    public void setAliasHub(String aliasHub) {
        this.aliasHub = aliasHub;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getDeviceStateId() {
        return deviceStateId;
    }

    public void setDeviceStateId(Integer deviceStateId) {
        this.deviceStateId = deviceStateId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPubSubIn() {
        return pubSubIn;
    }

    public void setPubSubIn(String pubSubIn) {
        this.pubSubIn = pubSubIn;
    }

    public String getPubSubOut() {
        return pubSubOut;
    }

    public void setPubSubOut(String pubSubOut) {
        this.pubSubOut = pubSubOut;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getVGrouper() {
        return vGrouper;
    }

    public void setVGrouper(String vGrouper) {
        this.vGrouper = vGrouper;
    }

    public List<Device> getDevice() {
        return device;
    }

    public void setDevice(List<Device> device) {
        this.device = device;
    }

}
