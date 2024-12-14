package com.example.vimass_e_wallet.model.phi;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjThuChiRequest {

    public String session;
    public String user;
    public long fromDate;
    public long toDate;
    public int typeTranfer;
    public int amount;
    public double amountFrom;
    public double amountTo;
    public int limit;
    public int offset;
    public int ver;
    public int VMApp;
    public String checkSum;

    public String getCks(){
        String cks = Func.getMD5("8725834534853" + this.user + this.session);
        return  cks;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
