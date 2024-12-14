package com.example.vimass_e_wallet.model.tracuu;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjSaoKeNHNNResponse <T> implements Serializable {

    public double promotionTotal;
    public boolean promotionStatus;
    public int total;
    public double totalFee;
    public int toTalGift;
    public int totalCreateGift;
    public ArrayList<ItemTrans> dsHienThi;
    public double totalMoney;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
