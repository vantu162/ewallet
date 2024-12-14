package com.example.vimass_e_wallet.model.donvi_model;

import com.example.vimass_e_wallet.model.tracuu.ItemTrans;
import com.google.gson.Gson;

import java.util.List;

public class ObjSaoKeGDViDN {

    public String userbalance;
    public double promotionTotal;
    public boolean promotionStatus;
    public int total;
    public int totalThu;
    public int totalChi;
    public double totalFee;
    public int totalThuTuVi;
    public double totalThuTuViMoney;
    public double totalFeeThuTuVi;
    public double totalMoney;
    public int toTalGift;
    public int totalCreateGift;
    public double totalChiMoney;
    public double totalThuMoney;
    public double totalFeeChi;
    public double totalFeeThu;
    public List<ItemTrans> dsHienThi;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
