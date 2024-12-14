package com.example.vimass_e_wallet.model.phi;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjThuQuaTheRequest {

    public int funcId;
    public String user;
    public long timeFrom;
    public long timeTo;

    public int limit;
    public int offset;
    public long timeRequest;
    public String cks;

    public String getCks(){
        String cks = Func.getMD5(this.user + this.timeRequest + this.offset + this.limit );
        return  cks;
    }
//"http://" + DucNT_Service.urlBackUp + "/vmNoiBo/services/quanTriVID/requestCommand"
    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}