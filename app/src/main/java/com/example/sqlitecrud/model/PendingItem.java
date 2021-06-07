package com.example.sqlitecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;

public class PendingItem {

    @SerializedName("id_qr_mob")
    @Expose
    private BigInteger idqrmob;

    @SerializedName("barcode")
    @Expose
    private String barcode;

    @SerializedName("staff_name")
    @Expose
    private String staffName;

    @SerializedName("staff_code")
    @Expose
    private String staffCode;

    @SerializedName("asset_code")
    @Expose
    private String assetCode;

    @SerializedName("asset_name")
    @Expose
    private String assetName;

    @SerializedName("merk_type")
    @Expose
    private String merkType;

    @SerializedName("condition")
    @Expose
    private String condition;

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("register_branch")
    @Expose
    private String registerBranch;

    @SerializedName("current_branch")
    @Expose
    private String currentBranch;

    @SerializedName("purchase_date")
    @Expose
    private String purchaseDate;

    @SerializedName("asset_value")
    @Expose
    private Double assetValue;

    @SerializedName("chassis_no")
    @Expose
    private String chassisNo;

    @SerializedName("engine_no")
    @Expose
    private String engineNo;

    @SerializedName("plat_no")
    @Expose
    private String platNo;

    @SerializedName("remarks")
    @Expose
    private String remarks;

    @SerializedName("asset_status")
    @Expose
    private String assetStatus;

    @SerializedName("status_mob")
    @Expose
    private String statusMob;

    public BigInteger getIdqrmob() {
        return idqrmob;
    }

    public void setIdqrmob(BigInteger idqrmob) {
        this.idqrmob = idqrmob;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getMerkType() {
        return merkType;
    }

    public void setMerkType(String merkType) {
        this.merkType = merkType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRegisterBranch() {
        return registerBranch;
    }

    public void setRegisterBranch(String registerBranch) {
        this.registerBranch = registerBranch;
    }

    public String getCurrentBranch() {
        return currentBranch;
    }

    public void setCurrentBranch(String currentBranch) {
        this.currentBranch = currentBranch;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(Double assetValue) {
        this.assetValue = assetValue;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getStatusMob() {
        return statusMob;
    }

    public void setStatusMob(String statusMob) {
        this.statusMob = statusMob;
    }

    @Override
    public String toString() {

        JSONObject json = new JSONObject();

        try {

            json.put("idqrmob", idqrmob);
            json.put("barcode", barcode);
            json.put("staff_name", staffName);
            json.put("staff_code", staffCode);
            json.put("asset_code", assetCode);
            json.put("asset_name", assetName);
            json.put("merk_type", merkType);
            json.put("condition", condition);
            json.put("unit", unit);
            json.put("register_branch", registerBranch);
            json.put("current_branch", currentBranch);
            json.put("purchase_date", purchaseDate);
            json.put("asset_value", assetValue);
            json.put("chassis_no", chassisNo);
            json.put("engine_no", engineNo);
            json.put("plat_no", platNo);
            json.put("remarks", remarks);
            json.put("asset_status", assetStatus);
            json.put("status_mob", statusMob);
//            json.put("staff", staff);
//            json.put("p_cre_date", creDate);
//            json.put("p_cre_by", creBy);
//            json.put("p_cre_ip_address", creIpAddress);
//            json.put("p_mod_date", modDate);
//            json.put("p_mod_by", modBy);
//            json.put("p_mod_ip_address", modIpAddress);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();

    }


}
