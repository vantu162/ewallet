package com.example.vimass_e_wallet.model.taiKhoan;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjTraCuuThongTinVdtRequest {
    public int funcId;
    public String user;
    public String session;
    public Long timeRequest;
    public String pass;
    public String checkSum;

    public String getCheckSum(String key){

        int fun = this.funcId  ;
        if(fun == 10){
            fun = 1;
        }

        String strCks = Func.instance.getMD5(key + this.user + this.session + this.timeRequest + fun + this.pass);
        return strCks;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

}
