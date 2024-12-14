package com.example.vimass_e_wallet.model.tracuu;

import com.google.gson.Gson;

public class ItemTrans {
    public long tg;
    public double tien;
    public double phi;
    public String tu;
    public String den;
    public String nd;
    public String maQR;
    public String idVM;
    public String idNH;
    public String idKH;
    public int typeTransaction;
    public String maGiaoDichSaoKe;
    public double totalAmountToAcc;
    public double totalAmountFromAcc;
    public String fromAcc;
    public String toAcc;
    public String feeAmount;
    public String note;
    public int typeMoRongClient;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
