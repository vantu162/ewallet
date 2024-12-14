package com.example.vimass_e_wallet.html;

import com.example.vimass_e_wallet.model.phi.ObjThongKeGD;
import com.example.vimass_e_wallet.model.tracuu.ItemTrans;
import com.example.vimass_e_wallet.tool.Func;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GenHTMN_Phi {
    public static GenHTMN_Phi instance;
    static { instance = new GenHTMN_Phi();}

    public String genHtmlListTrans(List<ObjThongKeGD> dsHienThi){

        String html = "";
        int TongSoGDTrongNgay=0;
        int TongSoGDChiTrongNgay=0;
        int TongSoGDThuTrongNgay=0;
        int TongSoGDThuBIDVTrongNgay=0;
        int TongSoGDThuVPBTrongNgay=0;

        for (int i=0; i< dsHienThi.size(); i ++){
            int tongSoGD = 0;
            int TongThuGD = 0;
            int TongChiGD = 0;
            int soGDThuVPBTN = 0;
            int soGDThuBIDVTN = 0;
            for (ObjThongKeGD.ListGiaoDich lisGiaoDich : dsHienThi.get(i).getListGiaoDich()){
                tongSoGD += lisGiaoDich.getTotal();
                if (lisGiaoDich.getTypeTranfer() == 2){
                    TongChiGD += lisGiaoDich.getTotal();
                } else if (lisGiaoDich.getTypeTranfer() == 7){
                    soGDThuBIDVTN = lisGiaoDich.getTotal();
                    TongThuGD += lisGiaoDich.getTotal();
                }else if (lisGiaoDich.getTypeTranfer() == 6){
                    TongThuGD += lisGiaoDich.getTotal();
                    soGDThuVPBTN = lisGiaoDich.getTotal();
                }
            }
            TongSoGDTrongNgay += tongSoGD;
            TongSoGDChiTrongNgay += TongChiGD;
            TongSoGDThuTrongNgay += TongThuGD;
            TongSoGDThuBIDVTrongNgay += soGDThuBIDVTN;
            TongSoGDThuVPBTrongNgay += soGDThuVPBTN;
        }

        html += genHtmlTitle(TongSoGDTrongNgay,TongSoGDChiTrongNgay,TongSoGDThuTrongNgay);
        for (int i =0; i< dsHienThi.size(); i ++){
            html += genHtmRow(dsHienThi.get(i), dsHienThi.get(i).getListGiaoDich());
        }
        return html;
    }

    public String genHtmlTitle(int a, int b, int c){

        String html = "";
        html += " <tr>" +
                "     <td>Giờ</td>\n" +
                "     <td>Tổng số (" +  Func.getVNDFormat(a) + " gd) </td>\n" +
                "     <td>Chi (" +  Func.getVNDFormat(b) + " gd)  </td>\n" +
                "      <td>Thu (" +  Func.getVNDFormat(c) + " gd)  </td>\n" +
                "  </tr>";
        return html;
    }

    public String genHtmRow( ObjThongKeGD objThongKeGD, ArrayList<ObjThongKeGD.ListGiaoDich> item){

        String html = "";
        int tongSoGDTG = 0;
        int soGDThuVPB = 0;
        int soGDThuBIDV = 0;
        int soGDChi = 0;
        int TongThu = 0;
        int TongChi = 0;

        for (ObjThongKeGD.ListGiaoDich lisGiaoDich : item){
            tongSoGDTG += lisGiaoDich.getTotal();
            if (lisGiaoDich.getTypeTranfer() == 2){
                TongChi += lisGiaoDich.getTotal();
            } else if (lisGiaoDich.getTypeTranfer() == 7){
                TongThu += lisGiaoDich.getTotal();
            }else if (lisGiaoDich.getTypeTranfer() == 6){
                TongThu += lisGiaoDich.getTotal();
            }
        }
        html += "<tr>" +
                "  <td><span>" + objThongKeGD.getGio() +"</span></td>" +
                "  <td><span>" + Func.getVNDFormat(tongSoGDTG) + "</span></td>"+
                "  <td><span>" +  Func.getVNDFormat(TongChi) + "</span></td>"+
                "  <td><span>" +  Func.getVNDFormat(TongThu) + "</span></td>"+
                "</tr>";
        return html;
    }



    private String tyLe(int a, int b){
        String tyLex = "";
        try{
            double x = ((double)a/b)*100;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            tyLex = decimalFormat.format(decimalFormat);
        }catch (Exception e){
            System.out.println("tyLe Exception: "+ e.getMessage());
        }

        return tyLex;
    }
}
