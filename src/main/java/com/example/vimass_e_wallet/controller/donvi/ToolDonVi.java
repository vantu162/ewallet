package com.example.vimass_e_wallet.controller.donvi;

import com.example.vimass_e_wallet.controller.phi.ToolPhi;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeViRequest;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeViRequest_v1;
import com.example.vimass_e_wallet.model.phi.ObjThuQuaTheRequest;
import com.example.vimass_e_wallet.tool.Func;

import java.util.Date;

public class ToolDonVi {
    public static ToolDonVi instance;

    static {
        instance = new ToolDonVi();
    }

    public ObjSaoKeViRequest getValueObjSaoKeViRequest(AccountInfo acc, String idVi,
                                                       int limit, int offset,int type,
                                                       String content,
                                                       String timeFrom, String timeTo){
        ObjSaoKeViRequest obj = null;
        try{
            obj = new ObjSaoKeViRequest();
            obj.phone = idVi;
            obj.fromDate = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.toDate = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.start = offset;
            obj.limit = limit;
            obj.type = type;
            obj.idVimass = content;
            obj.session = acc.secssion;
            obj.VMApp = 4;
            obj.appId = 5;
            obj.checkSum = obj.getCks();
            obj.userLogin = acc.walletLogin;
            obj.VimassMH = 1;
            obj.ver = 1;

        }catch (Exception e){
            System.out.println("getValueObjSaoKeViRequest e:" + e.getMessage());
        }
        return obj;
    }

    public ObjSaoKeViRequest_v1 getValueObjSaoKeViRequest_v1(AccountInfo acc, String idVi, int limit, int offset, int type,
                                                             String content,
                                                             String timeFrom, String timeTo){
        ObjSaoKeViRequest_v1 obj = null;
        try{
            obj = new ObjSaoKeViRequest_v1();
            obj.phone = idVi;
            obj.fromDate = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.toDate = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.start = offset;
            obj.limit = limit;
            obj.type = type;
            obj.idVimass = content;
            obj.session = acc.secssion;
            obj.VMApp = 4;
            obj.checkSum = obj.getCks();
            obj.userLogin = acc.walletLogin;
            obj.VimassMH = 1;
            obj.ver = 1;

        }catch (Exception e){
            System.out.println("getValueObjSaoKeViRequest_v1 e:" + e.getMessage());
        }
        return obj;
    }
}
