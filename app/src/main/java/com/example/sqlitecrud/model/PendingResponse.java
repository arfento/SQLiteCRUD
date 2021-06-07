package com.example.sqlitecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PendingResponse {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("getData")
    @Expose
    private List<PendingItem> getGetData = null;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PendingItem> getGetData() {
        return getGetData;
    }

    public void setGetData(List<PendingItem> getGetData) {
        this.getGetData = getGetData;
    }

    @Override
    public String toString(){

        JSONObject json = new JSONObject();

        try {
            json.put("result", result);
            json.put("message", message);
            json.put("getData", getGetData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();

    }

}
