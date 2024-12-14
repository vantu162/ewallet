package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class ObjPhiThuQuaQR {
    public double total;
    public double totalMoney;
    public double totalFee;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
