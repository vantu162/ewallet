package com.example.vimass_e_wallet.tool;

import com.example.vimass_e_wallet.model.phi.BankDTORequest;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.phi.ObjThuChiRequest;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTraCuuThongTinVdtRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjQrAmThanhRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjSaoKeNHNNRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjSaokeTheRequest;
import com.example.vimass_e_wallet.services.DataSystem;

import java.util.Date;

public class GetValue {
    public static GetValue instance;
    static { instance = new GetValue();}

    public ObjSaoKeNHNNRequest getValueObjSaoKeNHNNRequest(AccountInfo acc, int offset, int limit,
                                                           String timeFrom, String timeTo, double amountFrom,
                                                           double amountTo, int typeTran, int typeE){

        ObjSaoKeNHNNRequest obj = null;
        try{
            obj = new ObjSaoKeNHNNRequest();
            obj.VMApp = 4;
            obj.session = acc.secssion;
            obj.user= acc.phone;
            obj.offset = offset;
            obj.limit = limit;
            obj.fromDate = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.toDate = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.amount = 0;
            obj.amountFrom = amountFrom;
            obj.amountTo = amountTo;
            obj.typeTranfer = typeTran;
            obj.ver = typeE;
        }catch (Exception e){
            System.out.println("getValueObjSaoKeNHNNRequest e: " + e.getMessage());
        }

        return obj;
    }
    public ObjSaoKeNHNNRequest getValueObjSaoKeNHNNRequest_V1(){
        AccountInfo acc = new AccountInfo();
        if(DataSystem.instance.accountInfo != null) {
            acc = DataSystem.instance.accountInfo;
        }
        ObjSaoKeNHNNRequest obj = null;
        try{
            obj = new ObjSaoKeNHNNRequest();
            obj.VMApp = 4;
            obj.session = acc.secssion;
            obj.user= acc.phone;
            obj.offset = 0;
            obj.limit = 100;
            obj.fromDate = Func.instance.timeCurrentMillis(00,00,59);
            obj.toDate = Func.instance.timeCurrentMillis(23,59,59);
            obj.amount = 0;
            obj.amountFrom = 0;
            obj.amountTo = 15999999999L;
            obj.typeTranfer = 1;
            obj.ver = 1;
        }catch (Exception e){
            System.out.println("getValueObjSaoKeNHNNRequest_V1 e: "+ e.getMessage());
        }
        return obj;
    }
    public ObjSaokeTheRequest getValueObjSaokeTheRequest(AccountInfo acc, int offset, int limit,
                                                         String timeFrom, String timeTo, int typeTran){
        ObjSaokeTheRequest obj = null;
        try{
            obj = new ObjSaokeTheRequest();
            obj.funcId = 37;
            obj.user = acc.phone;
            obj.typeTranfer = typeTran;
            obj.offset = offset;
            obj.limit = limit;
            obj.timeFrom = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.timeTo = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.timeRequest = new Date().getTime();
            obj.cks = obj.checkSume();

        }catch (Exception e){
            System.out.println("getValueObjSaokeTheRequest e: " + e.getMessage());
        }

        return obj;

    }

    public ObjQrAmThanhRequest getValueObjQrAmThanhRequest(String secssion, String viVimassSDT, int limit, int offset,
                                                            String timeFrom, String timeTo, int typeSaoKe){

        ObjQrAmThanhRequest obj = null;
        try {
            obj = new ObjQrAmThanhRequest();
            obj.funcId = 3;
            obj.secssionLogin = secssion;
            obj.viVimassSDT = viVimassSDT;
            obj.limit = limit;
            obj.offset = offset;
            obj.timeFrom = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.timeTo = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.amountFrom = 0;
            obj.amountTo = 10000000;
            obj.typeSaoKe = typeSaoKe;
            obj.timeRequest =  new Date().getTime();
            obj.cks = obj.getCheckSum();

        }catch (Exception e){
            System.out.println("getValueObjQrAmThanhRequest e: " + e.getMessage());
        }
        return obj;
    }

    public ObjTraCuuThongTinVdtRequest getObjTraCuuThongTinVdtRequest(int funcId,String user, String session, String key){
        ObjTraCuuThongTinVdtRequest obj = null;
        try {

            obj = new ObjTraCuuThongTinVdtRequest();
            obj.funcId = funcId;
            obj.user = user;
            obj.session = session;
            obj.timeRequest = new Date().getTime();
            obj.pass = "jfhsjkdgda908rkgjakfdkjeghjr";
            obj.checkSum = obj.getCheckSum(key);// "fkjskldfadafa"


        }catch (Exception e){
            System.out.println("getObjTraCuuThongTinVdtRequest e: " + e.getMessage());
        }
        return obj;

    }

    public BankDTORequest getObjBankDTORequest(int func, String timeFrom, String timeTo, int type){
        BankDTORequest obj = null;
        try {

            obj = new BankDTORequest();
            obj.funcId = func;
            obj.timeFrom = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.timeTo = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.type = type;

        }catch (Exception e){
            System.out.println("getObjTraCuuThongTinVdtRequest e: " + e.getMessage());
        }
        return obj;

    }

    public ObjThuChiRequest getObjThuChiRequest(String session, String user, String timeFrom, String timeTo, int type){
        ObjThuChiRequest obj = null;
        try {

            obj = new ObjThuChiRequest();
            obj.session = session;
            obj.user = user;
            obj.fromDate = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.toDate =Func.instance.converFullDateTimeToLongTime(timeTo);;
            obj.typeTranfer = type;
            obj.amount = 0;
            obj.amountFrom = 0;
            obj.amountTo = 15999999999L;
            obj.limit = 100;
            obj.offset = 0;
            obj.ver = 1;
            obj.VMApp = 4;
            obj.checkSum = obj.getCks();

        }catch (Exception e){
            System.out.println("getObjTraCuuThongTinVdtRequest e: " + e.getMessage());
        }
        return obj;

    }

    public BankDTORequest getObjThuHoQuaQRRequest(int func, String timeFrom, String timeTo, int type){
        BankDTORequest obj = null;
        try {

            obj = new BankDTORequest();
            obj.funcId = func;
            obj.timeFrom = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.timeTo = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.type = type;

        }catch (Exception e){
            System.out.println("getObjTraCuuThongTinVdtRequest e: " + e.getMessage());
        }
        return obj;

    }
}


