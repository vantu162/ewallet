package com.example.vimass_e_wallet.html;

import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.taiKhoan.BankInfoResponse;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTaiKhoanDamBaoMoi;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTaiKhoanNoiBo;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTraCuuThongTinVdtRequest;
import com.example.vimass_e_wallet.services.CallServices_TaiKhoan;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.example.vimass_e_wallet.tool.GetValue;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GenHTML_TaiKhoan {

    public static GenHTML_TaiKhoan instance;
    static { instance = new GenHTML_TaiKhoan();}


    public String layDanhSachTaiKhoanDamBao(String user,String session,String tongViCoTien,String tongTienCacVi)
    {
        String html = "";
        ObjTraCuuThongTinVdtRequest objTraCuuThongTinVdtRequest = GetValue.instance.getObjTraCuuThongTinVdtRequest(2,user, session,"fkjskldfadafa");

        Response res  = CallServices_TaiKhoan.instance.postTraCuuThongTinVDT(objTraCuuThongTinVdtRequest);

        if(res!=null&&res.getMsgCode()==1)
        {
            ObjTaiKhoanNoiBo obj = new Gson().fromJson(new Gson().toJson(res.getResult()),ObjTaiKhoanNoiBo.class);
            if(obj!=null&&obj.ds.size()>0)
            {
                List<ObjTaiKhoanDamBaoMoi> list = new ArrayList<ObjTaiKhoanDamBaoMoi>();
                for(ObjTaiKhoanDamBaoMoi obj1 : obj.ds)
                {
                    if(!obj1.soTK.equals("xxx"))
                    {
                        if(obj1.soTK.equals("59523333")&&obj1.tenTK.contains("VPB"))
                        {
                            DataSystem.instance.objVPB = obj1;
                        }
                        else
                        {
                            list.add(obj1);
                        }
                    }
                }

                System.out.println("ca nhan: " + obj.ds.size());
                System.out.println("ca nhan thuc te: " + list.size());
                ObjTaiKhoanNoiBo obj1 = new ObjTaiKhoanNoiBo();
                ObjTaiKhoanNoiBo obj2 = new ObjTaiKhoanNoiBo();

                obj1.tongSoDu = obj.tongSoDu;
                obj2.tongSoDu = obj.tongSoDu;
                int index = list.size()/2;
                obj1.ds = list.subList(0,index);
                obj2.ds = list.subList(index,list.size());

                DataSystem.instance.A1 = obj.tongSoDu;
                html += content_layDanhSachTaiKhoanDamBao( list.size(),  obj.tongSoDu, tongViCoTien, tongTienCacVi);
                html +="_vm_";
                html += genHtmlTaiKhoanDamBao(obj2);
            }
        }
        return html;
    }

    public String content_layDanhSachTaiKhoanDamBao(int tatol,double tongSoDu, String tongViCoTien, String tongTienCacVi){

        String html ="<div class=\"d-flex flex-column\">" +
                        "<div class=\"d-flex flex-row\">" +
                            "<div class=\"me-2\" ><strong>TKĐBTT Tổng số TK: </strong><span class=\"color-01 fw-bold\">"+tatol+"</span></div>"+
                            "<div class=\"me-2\"><strong>A1: </strong><span class=\"color-01 fw-bold\">"+Func.getVNDFormat(tongSoDu)+"</span></div>"+
                            "<div class=\"me-2\"><strong>Tổng ví có tiền: </strong><span class=\"color-01 fw-bold\">"+tongViCoTien+"</span></div>"+
                        "</div>"+
                        "<div>" +
                             "<strong>B1: </strong>" + "<span class=\"color-01 fw-bold\">"+ tongViCoTien + "</span>"+
                        "</div>"+
                "</div>";
        return html;
    }

    public String layDanhSachTaiKhoanThuChiHo(String user,String session,String tongTienViThuChiHo)
    {
        String html = "";
        ObjTraCuuThongTinVdtRequest objTraCuuThongTinVdtRequest = GetValue.instance.getObjTraCuuThongTinVdtRequest(5,user, session,"fkjskldfadafa");
        Response res  = CallServices_TaiKhoan.instance.postTraCuuThongTinVDT(objTraCuuThongTinVdtRequest);
        if(res!=null&&res.getMsgCode()==1)
        {
            ObjTaiKhoanNoiBo obj = new Gson().fromJson(new Gson().toJson(res.getResult()),ObjTaiKhoanNoiBo.class);
            if(obj!=null&&obj.ds.size()>0)
            {
                DataSystem.instance.A4 = obj.tongSoDu;
                html += content_layDanhSachTaiKhoanThuChiHo(obj.ds.size(), obj.tongSoDu, tongTienViThuChiHo);
                html +="_vm_";
                html += genHtmlTaiKhoanDamBao(obj);
            }
        }
        return html;
    }

    public String content_layDanhSachTaiKhoanThuChiHo(int tatol,double tongSoDu, String tongTienViThuChiHo){

        String html ="<div class=\"d-flex flex-column\">" +
                        "<div class=\"d-flex flex-row\">" +
                            "<div class=\"me-2\" ><strong>TK THU CHI HỘ DN: </strong><span class=\"color-01 fw-bold\">"+tatol+"</span></div>"+
                            "<div class=\"me-2\"><strong>A4: </strong><span class=\"color-01 fw-bold\">"+Func.getVNDFormat(tongSoDu)+"</span></div>"+
                        "</div>"+
                        "<div>" +
                            "<strong>B2: </strong>" + "<span class=\"color-01 fw-bold\">"+ tongTienViThuChiHo + "</span>"+
                        "</div>"+
                     "</div>";

        return html;
    }


    public String layDanhSachTaiKhoanDamBao_CTT(String user,String session)
    {
        String html = "";
        // tai khoan dam bao CTT
        String funcId_taiKhoanCTT = "6";
        ObjTraCuuThongTinVdtRequest objTraCuuThongTinVdtRequest = GetValue.instance.getObjTraCuuThongTinVdtRequest(6,user, session,"fkjskldfadafa");

        Response res  = CallServices_TaiKhoan.instance.postTraCuuThongTinVDT(objTraCuuThongTinVdtRequest);
        if(res!=null&&res.getMsgCode()==1)
        {
            ObjTaiKhoanNoiBo obj = new Gson().fromJson(new Gson().toJson(res.getResult()),ObjTaiKhoanNoiBo.class);
            if(obj!=null&&obj.ds.size()>0)
            {
                DataSystem.instance.A3 = obj.tongSoDu;
                html += content_layDanhSachTaiKhoanDamBao_CTT_1(obj.ds.size(), obj.tongSoDu);
                html += "_vm_";
                html += genHtmlTaiKhoanDamBao(obj);
            }
        }
        return html;
    }


    public String content_layDanhSachTaiKhoanDamBao_CTT_1(int tatol, double tongSoDu){

        String html ="<div class=\"d-flex flex-column\">" +
                        "<div class=\"d-flex flex-row\">" +
                            "<div class=\"me-2\" ><strong>KHOẢN ĐẢM BẢO CTT: <strong><span class=\"color-01 fw-bold\">"+tatol+"</span></div>"+
                            "<div class=\"me-2\"><strong>A3: <strong><span class=\"color-01 fw-bold\">"+Func.getVNDFormat(tongSoDu)+"</span></div>"+
                        "</div>"+
                    "</div>";

        return html;
    }

    public String layDanhSachTaiKhoanCaNhan(String user,String session)
    {
        String html = "";
        // tai khoan ca nhan
        ObjTraCuuThongTinVdtRequest objTraCuuThongTinVdtRequest = GetValue.instance.getObjTraCuuThongTinVdtRequest(7,user, session,"fkjskldfadafa");

        Response res  = CallServices_TaiKhoan.instance.postTraCuuThongTinVDT(objTraCuuThongTinVdtRequest);
        if(res!=null&&res.getMsgCode()==1)
        {
            ObjTaiKhoanNoiBo obj = new Gson().fromJson(new Gson().toJson(res.getResult()),ObjTaiKhoanNoiBo.class);
            if(obj!=null&&obj.ds.size()>0)
            {
                List<ObjTaiKhoanDamBaoMoi> list = new ArrayList<ObjTaiKhoanDamBaoMoi>();
                for(ObjTaiKhoanDamBaoMoi obj1 : obj.ds)
                {
                    if(!obj1.soTK.equals("xxx"))
                    {
                        list.add(obj1);
                    }
                }

                DataSystem.instance.A2 = obj.tongSoDu;
                html += content_layDanhSachTaiKhoanCaNhan(list.size(),obj.tongSoDu);
                html +="_vm_";
                html += genHtmlTaiKhoanDamBao(obj);
            }
        }
        return html;
    }

    public String content_layDanhSachTaiKhoanCaNhan(int tatol, double tongSoDu){

        String html ="<div class=\"d-flex flex-column\">" +
                "<div class=\"d-flex flex-row\">" +
                "<div class=\"me-2\" ><strong>TK THU CHI HỘ CN: </strong><span class=\"color-01 fw-bold\">"+tatol+"</span></div>"+
                "<div class=\"me-2\"><strong>A2: </strong><span class=\"color-01 fw-bold\">"+Func.getVNDFormat(tongSoDu)+"</span></div>"+
                "</div>"+
                "</div>";
        return html;
    }


    public static String genHtmlTaiKhoanDamBao(ObjTaiKhoanNoiBo listTK)
    {
        String html = "";
        List<ObjTaiKhoanDamBaoMoi> list = listTK.ds;
        int count = 0;
        for(ObjTaiKhoanDamBaoMoi obj : list)
        {
            if(obj.tenTK.contains("SEABANK"))
            {
                obj.tenTK.replace("SEABANK","SEAB");
            }
            if(obj.tenTK.contains("-"))
            {
                String temp = obj.tenTK.split("-")[0];
                obj.tenTK = temp;
            }
            if(!obj.soTK.equals("xxx"))
            {
                // Check if soDu > 1 tỷ (1,000,000,000 VND)
                boolean highlight = obj.soDu > 1000000000;

                html +="<tr" + (highlight ? " style=\"background-color: yellow;\"" : "") + ">\n";
                html += "    <td class=\"w-20 ps-1\">"+obj.tenTK+"</td>\n";
                html += "    <td class=\"w-30 ps-1\">"+obj.soTK+"</td>\n";
                html += "    <td class=\"w-50 ps-1\">"+Func.getVNDFormat(obj.soDu)+"</td>\n";
                html += "</tr>";

                count = count +1;
            }
        }

        return html;
    }

    public  String genVenhTien()
    {
        String html = "";
        Response responseMessage_nganhang = CallServices_TaiKhoan.instance.getListBankInfo();
        if(responseMessage_nganhang!=null&&responseMessage_nganhang.getMsgCode()==1)
        {
            BankInfoResponse bankInfoResponse = new Gson().fromJson(new Gson().toJson(responseMessage_nganhang.getResult()), BankInfoResponse.class);
            html +=
                    "<tr>\n" +
                            "   <td class=\"w-25 color-t--s1 text-center\">"+Func.getVNDFormat(bankInfoResponse.getTotalWalletTheDaNang()) +"</td>\n" +
                            "   <td class=\"w-25 color-t--s2 text-center\">"+Func.getVNDFormat(bankInfoResponse.getTotalBank())+"</td>\n" +
                            "   <td class=\"w-25 color-t--s3 text-center\">"+Func.getVNDFormat(bankInfoResponse.getTotalWallet())+"</td>\n" +
                            "   <td class=\"w-25 color-t--s4 text-center\">"+Func.getVNDFormat(bankInfoResponse.getCheckLechSoDu()).replace("-","")+"</td>\n" +
                            "</tr>";
        }
        return html;
    }

    public  String genHtmlChenhLech(double B2,double A4, double B1B2, double A1A2A3A4)
    {
        double chenhLech1 = B2 - A4;
        double chenhLech2 = B1B2 - A1A2A3A4;
        String html =
                "<tr style=\"background: #1dbb00;color: white;\">\n" +
                        "    <td class=\"text-center\">A = A1 + A2 + A3 + A4</td>\n" +    //Tổng số dư toàn bộ vi
                        "    <td class=\"text-center\">B = B1 + B2</td>\n" +    //Tổng số dư toàn bộ TKDB
                        "    <td class=\"text-center\">A - B</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "    <td class=\"text-center\">"+ Func.getVNDFormat(A1A2A3A4)+"</td>\n" +
                        "    <td class=\"text-center\">"+Func.getVNDFormat(B1B2)+"</td>\n" +
                        "    <td class=\"text-center\">"+Func.getVNDFormat(chenhLech2)+"</td>\n" +
                        "</tr>" +
                        "<tr style=\"background: #1dbb00;color: white;\">\n" +                 //Tổng TK DN thu chi hộ (A)
                        "                            <td class=\"text-center\">C = B2</td>\n" +
                        "                            <td class=\"text-center\">D = A4</td>\n" +       //Tổng số dư ví thu chi hộ (B)
                        "                            <td class=\"text-center\">C - D</td>\n" +
                        "                        </tr>\n" +
                        "                        <tr>\n" +
                        "                            <td class=\"text-center\">"+ Func.getVNDFormat(B2)+"</td>\n" +
                        "                            <td class=\"text-center\">"+Func.getVNDFormat(A4)+" </td>\n" +
                        "                            <td class=\"text-center\">"+Func.getVNDFormat(chenhLech1)+"</td>\n" +
                        "                        </tr>\n";

        return html;
    }

}
