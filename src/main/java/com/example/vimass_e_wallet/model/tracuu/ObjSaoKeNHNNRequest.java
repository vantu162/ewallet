package com.example.vimass_e_wallet.model.tracuu;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjSaoKeNHNNRequest {

    public int VMApp;
    public String session;
    public String user;
    public int limit;
    public int offset;
    public long fromDate;
    public long toDate;
    public double amount;
    public double amountFrom;
    public double amountTo;
    public int typeTranfer;
    public int ver;
//    "8725834534853" + user + session

    public String getCKS(){
        String strCKS = Func.instance.getMD5("8725834534853" + this.user + this.session);
        return strCKS;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
