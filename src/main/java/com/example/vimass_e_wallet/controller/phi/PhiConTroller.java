package com.example.vimass_e_wallet.controller.phi;

import com.example.vimass_e_wallet.html.GenHTMN_Phi;
import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.phi.*;
import com.example.vimass_e_wallet.services.CallServices_Phi;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.example.vimass_e_wallet.tool.GetValue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PhiConTroller {

    @GetMapping ("/bank/doanhthu")
    @ResponseBody
    public String resDoanhThu(@RequestParam String timeFrom, @RequestParam String timeTo) {
        String result = "";
        try{
            AccountInfo acc = new AccountInfo();
            if(DataSystem.instance.accountInfo != null) {
                acc = DataSystem.instance.accountInfo;
            }
//-------------------------- phi thu, phi chi -----------------------------------------------------------
            Response [] arr = PhiDTO.instance.getDataThuChi(acc.secssion, acc.phone,timeFrom, timeTo);

            ObjThuChiResponse objThu = new Gson().fromJson(new Gson().toJson(arr[0].getResult()), ObjThuChiResponse.class);
            ObjThuChiResponse objChi = new Gson().fromJson(new Gson().toJson(arr[1].getResult()), ObjThuChiResponse.class);

            ObjThuChi objThuChi = new ObjThuChi();
            objThuChi.tongThu = Func.getVNDFormat(objThu.total);
            objThuChi.tongChi = Func.getVNDFormat(objChi.total);

            double a = Math.round(objThu.totalFee/1.1);
            double b = Math.round(objChi.totalFee/1.1);
            double c = (a + b + ToolPhi.instance.tongPhiThuQR+ ToolPhi.instance.tongPhiThuThe) - ToolPhi.instance.phiHoanTra ;

            objThuChi.tongTienThu = Func.getVNDFormat(a);
            objThuChi.tongTienChi = Func.getVNDFormat(b);

            double tatolFee = (ToolPhi.instance.tongPhiTPB + ToolPhi.instance.tongPhiTPB_1 +
                    ToolPhi.instance.tongPhiVPB + ToolPhi.instance.tongPhiPVCM+ ToolPhi.instance.tongPhiBIDV);
            objThuChi.chiNganHang = Func.instance.getVNDFormat(tatolFee);
            objThuChi.tongDoanhThu = Func.getVNDFormat(c);

            double net = (int)c - tatolFee;

            objThuChi.thuNet = Func.instance.getVNDFormat(net);

            result = objThuChi.toString();

        }catch (Exception e){
            System.out.println("resDoanhThu e:"+ e.getMessage());
        }

        return result;
    }

    @PostMapping ("/bank/tbp")
    @ResponseBody
    public String resTBP(@RequestParam String timeFrom, @RequestParam String timeTo) {

        BankDTORequest obj = GetValue.instance.getObjBankDTORequest(16,timeFrom, timeTo, 1);
        String res = CallServices_Phi.instance.postBankDTO(obj);
        System.out.println("resTBP: " +res);
        ObjBankDTO objBankDTO = ToolPhi.instance.getValuetbp(res,50,150,0);
        // Trả về JSON cho jQuery
        return objBankDTO.toString();
    }

    @PostMapping ("/bank/tbp1")
    @ResponseBody
    public String resTBP_1(@RequestParam String timeFrom, @RequestParam String timeTo) {
        String result = "";
        try{
            BankDTORequest obj = GetValue.instance.getObjBankDTORequest(20,timeFrom, timeTo, 1);
            String res = CallServices_Phi.instance.postBankDTO(obj);
            System.out.println("resTBP1: " +res);
            ObjBankDTO objBankDTO = ToolPhi.instance.getValuetbp(res,50,150,1);

            result = objBankDTO.toString();

        }catch (Exception e){
            System.out.println("resTBP_1 e:" +e.getMessage());
        }

        return result;
    }

    @GetMapping("/bank/pvcb")
    @ResponseBody
    public String resPVCB(@RequestParam String timeFrom, @RequestParam String timeTo) {
        ObjBankDTO obj = null;
        try{
            obj = new ObjBankDTO();
            String[] results =  PhiDTO.instance.getDataChiPVCB(timeFrom,timeTo);
            obj = ToolPhi.instance.getValuePVCB(results,0,2000);
//            System.out.println("resPVCB obj: " +obj.toString());

        }catch (Exception e){
            System.out.println("resPVCB: " +e.getMessage());
        }
        // Trả về JSON cho jQuery
        return obj.toString();
    }

    @PostMapping ("/bank/vpb")
    @ResponseBody
    public String resVBP(@RequestParam String timeFrom, @RequestParam String timeTo) {

        String result = "";
        try{
            BankDTORequest obj = GetValue.instance.getObjBankDTORequest(18,timeFrom, timeTo, 1);
//            System.out.println("inputVBP obj: " +obj.toString());
            String res = CallServices_Phi.instance.postBankDTO(obj);
            ObjBankDTO objBankDTO = ToolPhi.instance.getValueVPB(res,0,2000);
//            System.out.println("resVBP obj: " +objBankDTO.toString());
            result = objBankDTO.toString();
        }catch (Exception e){
            System.out.println("resVBP e:" +e.getMessage());
        }

        return result;
    }

    @GetMapping("/bank/bidv")
    @ResponseBody
    public String resTransaction(@RequestParam String timeFrom, @RequestParam String timeTo) {
        ObjBankDTO obj = null;
        try{
            String[] results =  PhiDTO.instance.getDataChiBIDV(timeFrom,timeTo);
            obj = ToolPhi.instance.getValueBIDV(results,1000,1800);

//            System.out.println("resBIDV obj: " +obj.soLanChayThucTe);
        }catch (Exception e){
            System.out.println("resBIDV: " +e.getMessage());
        }
        return obj.toString();
    }

    @PostMapping("/bank/thuquaqr")
    @ResponseBody
    public String resThuQuaQR(@RequestParam String timeFrom, @RequestParam String timeTo) {

        ObjPhiThuQuaQR objPhiThuQuaQR = null;
        try{
            ObjThuQuaQR_Request obj = ToolPhi.instance.getValueObjThuQuaQR(timeFrom,timeTo);
//            System.out.println("resThuQuaQR input =========> " +obj.toString());
            ObjThuQuaQR_Response objThuQuaQR_response = CallServices_Phi.instance.postLayPhiThuQuaQR(obj);

            objPhiThuQuaQR = new Gson().fromJson(new Gson().toJson(objThuQuaQR_response.getResult()), ObjPhiThuQuaQR.class);
            double fee = Math.round(objPhiThuQuaQR.totalFee/1.1);

            objPhiThuQuaQR.setTotalFee(fee);
            ToolPhi.instance.tongPhiThuQR = Math.round(fee);

//            System.out.println("resThuQuaQR ====> " +objPhiThuQuaQR.toString());
        }catch (Exception e){
            System.out.println("resThuQuaQR: " +e.getMessage());
        }
        return objPhiThuQuaQR.toString();
    }


    @PostMapping("/bank/thuquathe")
    @ResponseBody
    public String resThuQuaThe(@RequestParam String timeFrom, @RequestParam String timeTo) {

        String result = "";
        AccountInfo acc = new AccountInfo();
        if(DataSystem.instance.accountInfo != null) {
            acc = DataSystem.instance.accountInfo;
        }
        ObjThuQuaTheResponse res = null;
        try{
            ObjThuQuaTheRequest obj = ToolPhi.instance.getValueObjThuQuaThe(acc.phone, timeFrom,timeTo);
//            System.out.println("resThuQuaThe input =========> " +obj.toString());
            res = CallServices_Phi.instance.postLayPhiThuQuaQR(obj);

           // ObjPhiThuQuaQR objPhiThuQuaQR = new Gson().fromJson(new Gson().toJson(objThuQuaQR_response.getResult()), ObjPhiThuQuaQR.class);
            double val = Math.round(res.totalPhi/1.1);
            ToolPhi.instance.tongPhiThuThe = Math.round(res.totalPhi/1.1);
            result = Func.getVNDFormat(val);
//            System.out.println("resThuQuaThe =========> " + val);

        }catch (Exception e){
            System.out.println("resThuQuaThe: " +e.getMessage());
        }
        return result;
    }

    @PostMapping("/bank/phihoantra")
    @ResponseBody
    public String resPhiHoanTra(@RequestParam String timeFrom, @RequestParam String timeTo) {
        String result = "";
        try{
            String param = "11_xxx_"+Func.instance.converFullDateTimeToLongTime(timeFrom)+"_xxx_"+Func.instance.converFullDateTimeToLongTime(timeTo);
            double hoanTraPhi = CallServices_Phi.instance.getPhiHoanTra(param);
            double x_quanLiPhi = Math.round(hoanTraPhi/1.1);
            ToolPhi.instance.phiHoanTra = x_quanLiPhi;
            result = Func.getVNDFormat(x_quanLiPhi);
//            System.out.println("resPhiHoanTra =================> " + x_quanLiPhi);

        }catch (Exception e){
            System.out.println("resPhiHoanTra: " +e.getMessage());
        }
        return result;
    }


    @PostMapping ("/bank/thuquabank")
    @ResponseBody
    public String resThuQuaBank(@RequestParam String timeFrom, @RequestParam String timeTo, @RequestParam int type) {
//        typ =7 thu qua bidv, type = 6 thu qua vbp
        String result = "";
        try{
            AccountInfo acc = new AccountInfo();
            if(DataSystem.instance.accountInfo != null) {
                acc = DataSystem.instance.accountInfo;
            }
            ObjThuChiRequest obj = GetValue.instance.getObjThuChiRequest(acc.secssion, acc.phone, timeFrom, timeTo, type);
            Response res =  CallServices_Phi.instance.resTongGD_ThuChi(obj);

            ObjThuChiResponse objThu = new Gson().fromJson(new Gson().toJson(res.getResult()), ObjThuChiResponse.class);
            double x = Math.round(objThu.totalFee/1.1);

            result = Func.getVNDFormat(objThu.total)+"___"+Func.getVNDFormat(x);
        }catch (Exception e){
            System.out.println("resThuQuaBank e:" +e.getMessage());
        }


        return result;
    }

    @GetMapping ("/bank/thongkeotheogiotrongngay")
    @ResponseBody
    public String resThongKeTheoGioTrongNgay( @RequestParam String date) {
        String html = "";
        try {
           String input = date.replace("/","-");
            System.out.println("resThongKeTheoGioTrongNgay: " +input);
            Response res =  CallServices_Phi.instance.resThongKeGDtheoNgay(input);

            Type collectionType = new TypeToken<List<ObjThongKeGD>>(){}.getType();
            List <ObjThongKeGD> list = new Gson().fromJson(new Gson().toJson(res.getResult()), collectionType);

            html = GenHTMN_Phi.instance.genHtmlListTrans(list);

        }catch (Exception e){
            System.out.println("resThongKeTheoGioTrongNgay e:" + e.getMessage());
        }

        return html;
    }


    @GetMapping ("/bank/timecurrent")
    @ResponseBody
    public String resTimeCurrent() {
        String html = "";
        try {
            // Lấy ngày giờ hiện tại
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Định dạng ngày giờ
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            // Chuyển đổi sang chuỗi định dạng
            String formattedDateTime = currentDateTime.format(formatter);
            html = formattedDateTime.replace("-","/");
//            System.out.println("formattedDateTime :" + formattedDateTime);

        }catch (Exception e){
            System.out.println("resTimeCurrent e:" + e.getMessage());
        }

        return html;
    }

}
