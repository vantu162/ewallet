package com.example.vimass_e_wallet.model.phi;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjThuQuaQR_Request {

    public int funcId;
    public long timeFrom;
    public long timeTo;
    public long timeRequest;
    public String checkSum;

    public String getCks(){
        String cks = Func.getMD5("jdqpowrifioefiqo3289r79f" + 14 + this.timeFrom + this.timeTo + this.timeRequest);
        return  cks;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
