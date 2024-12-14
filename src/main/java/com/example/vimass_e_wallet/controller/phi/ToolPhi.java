package com.example.vimass_e_wallet.controller.phi;

import com.example.vimass_e_wallet.model.phi.*;
import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

import java.util.Date;

public class ToolPhi {

    public static ToolPhi instance;

    static {
        instance = new ToolPhi();
    }
    public double tongPhiTPB = 0;
    public int tongPhiTPB_1 = 0;
    public double tongPhiVPB = 0;
    public double tongPhiPVCM = 0;
    public double tongPhiBIDV = 0;

    public double tongPhiThuQR = 0;

    public double tongPhiThuThe = 0;

    public double phiHoanTra = 0;

    public ObjBankDTO getValuetbp(String res, int phiNoiBo, int phiLNH, int type){

        ObjPhiChiHoTPB objPhiChiHoTPB = null;

        if(res!=null&&res!="")
        {
            objPhiChiHoTPB = new Gson().fromJson(res, ObjPhiChiHoTPB.class);

        }

        int phi_NoiBo = phiNoiBo *  objPhiChiHoTPB.soGDNoiBo;
        int phi_LNH = phiLNH * objPhiChiHoTPB.soGDLNH;
        int phi = phi_NoiBo + phi_LNH;
        if(type == 0){
            tongPhiTPB = phi;
        }else {
            tongPhiTPB_1 = phi;
        }

        ObjBankDTO obj = new ObjBankDTO();
        try{
            obj.gdNoiBo = Func.instance.getVNDFormatTypeInt(objPhiChiHoTPB.soGDNoiBo);
            obj.phiNoiBo = Func.getVNDFormat(phi_NoiBo);
            obj.soGDLNH = Func.instance.getVNDFormatTypeInt( objPhiChiHoTPB.soGDLNH);
            obj.phiGDLNH = Func.getVNDFormat(phi_LNH);
            obj.soGD = Func.instance.getVNDFormatTypeInt(objPhiChiHoTPB.soGD);
            obj.phiGD = Func.getVNDFormat((phi));
            obj.soGDHoan= Func.instance.getVNDFormatTypeInt(objPhiChiHoTPB.soGDHoan);
            obj.soLanChayThucTe=  Func.instance.getVNDFormatTypeInt(objPhiChiHoTPB.soLanChayThucTe);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return obj;

    }

    public ObjBankDTO getValueVPB(String res, int phiNoiBo, int phiLNH){

        ObjPhiChiHoVPB objPhiChiHoVPB = null;

        if(res!=null&&res!="")
        {
            objPhiChiHoVPB = new Gson().fromJson(res, ObjPhiChiHoVPB.class);

        }

        int phi_NoiBo = phiNoiBo *  objPhiChiHoVPB.soGDNoiBoVP;
        int phi_LNH = phiLNH * objPhiChiHoVPB.soGDLNH;
        int phi = phi_NoiBo + phi_LNH;
        tongPhiVPB = phi;
        ObjBankDTO obj = new ObjBankDTO();
        try{
            obj.gdNoiBo = Func.instance.getVNDFormatTypeInt(objPhiChiHoVPB.soGDNoiBoVP);
            obj.phiNoiBo = Func.getVNDFormat(phi_NoiBo);
            obj.soGDLNH = Func.instance.getVNDFormatTypeInt(objPhiChiHoVPB.soGDLNH);
            obj.phiGDLNH = Func.getVNDFormat(phi_LNH);
            obj.soGD = Func.instance.getVNDFormatTypeInt(objPhiChiHoVPB.soGD);
            obj.phiGD = Func.getVNDFormat((phi));
            obj.soGDHoan= Func.instance.getVNDFormatTypeInt(objPhiChiHoVPB.soGDHoan);
            obj.soLanChayThucTe=  String.valueOf(objPhiChiHoVPB.soLanChayThucTe);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return obj;

    }

    public ObjBankDTO getValueBIDV( String[] results, int phiNoiBo, int phiLNH){
        int phi_NoiBo = phiNoiBo *  Integer.valueOf(results[1]);
        int phi_LNH = phiLNH * Integer.valueOf(results[2]);
        int phi = phi_NoiBo + phi_LNH;
        tongPhiBIDV = phi;
        ObjBankDTO obj = new ObjBankDTO();
        try{
            obj.gdNoiBo =  Func.instance.getVNDFormatTypeInt(Integer.valueOf(results[1]));;
            obj.phiNoiBo = Func.instance.getVNDFormatTypeInt(phi_NoiBo);
            obj.soGDLNH =  Func.instance.getVNDFormatTypeInt(Integer.valueOf(results[2]));
            obj.phiGDLNH = Func.instance.getVNDFormatTypeInt(phi_LNH);
            obj.soGD =  Func.instance.getVNDFormatTypeInt(Integer.valueOf(results[2]));
            obj.phiGD = Func.instance.getVNDFormatTypeInt(phi);
            obj.soGDHoan =  Func.instance.getVNDFormatTypeInt(Integer.valueOf(results[3]));
            int x = (int) Double.parseDouble(results[4]);
            obj.soLanChayThucTe = Func.instance.getVNDFormatTypeInt(x);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return obj;

    }

    public ObjBankDTO getValuePVCB(String[] results, int phiNoiBo, int phiLNH){

        ObjBankDTO obj = new ObjBankDTO();
        try{
            if (results[0] != null) {

//                System.out.println("results[0]: " + results[0] );
                obj.soGD = results[0].split("___")[0];
                obj.phiGD = results[0].split("___")[1];
                tongPhiPVCM = Integer.valueOf(results[0].split("___")[1].replace(".",""));
            }

            if (results[1] != null) {
//                System.out.println("results[1]: " + results[1] );
                obj.gdNoiBo = results[1].split("___")[0];
                obj.phiNoiBo = results[1].split("___")[1];
            }

            if (results[2] != null) {
//                System.out.println("results[2]: " + results[2] );
                obj.soGDLNH = results[2].split("___")[0];
                obj.phiGDLNH = results[2].split("___")[1];
            }

            if (results[3] != null) {
//                System.out.println("results[3]: " + results[3] );
                obj.soGDHoan = results[3].split("___")[0];
            }else {
                obj.soGDHoan = results[3];
            }

            if (results[4] != null) {
//                System.out.println("results[4]: " + results[4] );
                obj.soLanChayThucTe = results[4].split("___")[0];
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return obj;

    }


    public ObjThuQuaQR_Request getValueObjThuQuaQR(String timeFrom, String timeTo){
        ObjThuQuaQR_Request obj = null;
        try{
            obj = new ObjThuQuaQR_Request();
            obj.funcId = 14;
            obj.timeFrom = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.timeTo = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.timeRequest = new Date().getTime();
            obj.checkSum = obj.getCks();
        }catch (Exception e){
            System.out.println("getValueObjThuQuaQR e:" + e.getMessage());
        }
        return obj;
    }

    public ObjThuQuaTheRequest getValueObjThuQuaThe(String user, String timeFrom, String timeTo){
        ObjThuQuaTheRequest obj = null;
        try{
            obj = new ObjThuQuaTheRequest();
            obj.funcId = 38;
            obj.user = user;
            obj.limit = 100;
            obj.offset = 0;
            obj.timeFrom = Func.instance.converFullDateTimeToLongTime(timeFrom);
            obj.timeTo = Func.instance.converFullDateTimeToLongTime(timeTo);
            obj.timeRequest = new Date().getTime();
            obj.cks = obj.getCks();
        }catch (Exception e){
            System.out.println("getValueObjThuQuaQR e:" + e.getMessage());
        }
        return obj;
    }

}
