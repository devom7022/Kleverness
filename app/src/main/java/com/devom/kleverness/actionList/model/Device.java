
package com.devom.kleverness.actionList.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device {

    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("isOn")
    @Expose
    private Boolean isOn;
    @SerializedName("aliasDevice")
    @Expose
    private String aliasDevice;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("modelId")
    @Expose
    private Integer modelId;
    @SerializedName("deviceStateId")
    @Expose
    private Integer deviceStateId;
    @SerializedName("deviceViewId")
    @Expose
    private String deviceViewId;
    @SerializedName("control")
    @Expose
    private List<Object> control = null;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(Boolean isOn) {
        this.isOn = isOn;
    }

    public String getAliasDevice() {
        return aliasDevice;
    }

    public void setAliasDevice(String aliasDevice) {
        this.aliasDevice = aliasDevice;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public String getDeviceViewId() {
        return deviceViewId;
    }

    public void setDeviceViewId(String deviceViewId) {
        this.deviceViewId = deviceViewId;
    }

    public List<Object> getControl() {
        return control;
    }

    public void setControl(List<Object> control) {
        this.control = control;
    }

}
