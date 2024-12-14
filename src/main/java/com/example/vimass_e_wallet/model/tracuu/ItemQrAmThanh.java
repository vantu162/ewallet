package com.example.vimass_e_wallet.model.tracuu;

import com.google.gson.Gson;

public class ItemQrAmThanh {

    public String subId;
    public String transId;
    public double amount;
    public String content;
    public double realAmount;
    public long transTime;
    public String idRequestMc;
    public long timeCreate;
    public int typeQR;
    public int fee;
    public int trangThaiXuLy;
    public int hToan;
    public int bak;
    public int trangThaiVNP;
    public String cks;
    public double phi;
    public long timeDaChi;
    public long timeChoHoan;
    public long timeDaHoan;
    public int typeTrans;
    public String ops;
    public String fromV;
    public String toV;
    public double totalA;
    public double totalF;
    public int maGiaoDichCuoi;
    public int funcId;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
