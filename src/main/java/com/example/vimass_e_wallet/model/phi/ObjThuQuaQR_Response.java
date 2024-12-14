package com.example.vimass_e_wallet.model.phi;

import com.example.vimass_e_wallet.html.GenHTML;
import com.google.gson.Gson;

import java.io.Serializable;

public class ObjThuQuaQR_Response <T> implements Serializable {

    public int msgCode;
    public String msgContent;
    public T result;
    public double total;
    public int adminLevel;
    public double tongDiem;
    public double tienQuyDoiDiem;

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    public double getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(double tongDiem) {
        this.tongDiem = tongDiem;
    }

    public double getTienQuyDoiDiem() {
        return tienQuyDoiDiem;
    }

    public void setTienQuyDoiDiem(double tienQuyDoiDiem) {
        this.tienQuyDoiDiem = tienQuyDoiDiem;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
