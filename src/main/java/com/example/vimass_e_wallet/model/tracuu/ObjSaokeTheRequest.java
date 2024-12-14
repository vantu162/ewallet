package com.example.vimass_e_wallet.model.tracuu;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjSaokeTheRequest {
    public int funcId;
    public String user;
    public int typeTranfer;
    public int offset;
    public int limit;
    public long timeFrom;
    public long timeTo;
    public long timeRequest;
    public String cks;

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTypeTranfer() {
        return typeTranfer;
    }

    public void setTypeTranfer(int typeTranfer) {
        this.typeTranfer = typeTranfer;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(long timeFrom) {
        this.timeFrom = timeFrom;
    }

    public long getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(long timeTo) {
        this.timeTo = timeTo;
    }

    public long getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(long timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getCks() {
        return cks;
    }

    public void setCks(String cks) {
        this.cks = cks;
    }

    public String checkSume(){
        System.out.println("befor: " +(this.timeRequest + this.user + this.offset  +this.limit));
        String strCKS = Func.instance.getMD5(this.user + this.timeRequest + this.offset  +this.limit);
        System.out.println("after: " +strCKS);
        return strCKS;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
