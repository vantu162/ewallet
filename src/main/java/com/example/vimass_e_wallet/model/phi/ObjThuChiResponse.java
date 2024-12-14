package com.example.vimass_e_wallet.model.phi;

import com.example.vimass_e_wallet.model.tracuu.ItemTrans;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ObjThuChiResponse {

    public int promotionTotal;
    public boolean promotionStatus;
    public int total;
    public double totalFee;
    public double totalMoney;
    public double toTalGift;
    public double totalCreateGift;
    public ArrayList<ItemTrans> dsHienThi;

    public int getPromotionTotal() {
        return promotionTotal;
    }

    public void setPromotionTotal(int promotionTotal) {
        this.promotionTotal = promotionTotal;
    }

    public boolean isPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(boolean promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getToTalGift() {
        return toTalGift;
    }

    public void setToTalGift(double toTalGift) {
        this.toTalGift = toTalGift;
    }

    public double getTotalCreateGift() {
        return totalCreateGift;
    }

    public void setTotalCreateGift(double totalCreateGift) {
        this.totalCreateGift = totalCreateGift;
    }

    public ArrayList<ItemTrans> getDsHienThi() {
        return dsHienThi;
    }

    public void setDsHienThi(ArrayList<ItemTrans> dsHienThi) {
        this.dsHienThi = dsHienThi;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
