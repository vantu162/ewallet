package com.example.vimass_e_wallet.model.tracuu;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjQrAmThanhRequest {
    public int funcId;
    public String secssionLogin;
    public String viVimassSDT;
    public int limit;
    public int offset;
    public long timeFrom;
    public long timeTo;
    public int amountFrom;
    public int amountTo;
    public int typeSaoKe;
    public long timeRequest;
    public String cks;

    public String getCheckSum(){

        String strCks = Func.instance.getMD5("74963568969fsgsf" +
                this.funcId + this.timeRequest + this.secssionLogin + this.viVimassSDT + this.timeFrom
                + this.timeTo + this.amountFrom + this.amountTo + this.offset + this.limit + this.typeSaoKe);
        System.out.println("getCheckSum =======> " + strCks);
        return strCks;

    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

}
