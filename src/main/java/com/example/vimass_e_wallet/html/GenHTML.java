package com.example.vimass_e_wallet.html;

import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTaiKhoanDamBaoMoi;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTaiKhoanNoiBo;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTraCuuThongTinVdtRequest;
import com.example.vimass_e_wallet.model.tracuu.ItemCards;
import com.example.vimass_e_wallet.model.tracuu.ItemQrAmThanh;
import com.example.vimass_e_wallet.model.tracuu.ItemTrans;
import com.example.vimass_e_wallet.services.CallServices_TaiKhoan;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.example.vimass_e_wallet.tool.GetValue;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenHTML {
    public static GenHTML instance;
    static { instance = new GenHTML();}

    public String genHtmlListTrans(ArrayList<ItemTrans> dsHienThi){
        String strHTML = "";
        if(dsHienThi != null){
            for(int i = 0; i< dsHienThi.size(); i++){
                strHTML +="  <tr class=\"w-100\">" +
                        "            <td>"+(i+1)+"</td>\n" +
                        "            <td>"+ Func.getVNDFormat(dsHienThi.get(i).tien)+" đ"+ "</td>\n" +
                        "            <td>"+Func.getVNDFormat(dsHienThi.get(i).phi)+" đ"+"</td>\n" +
                        "            <td>"+dsHienThi.get(i).tu+"</td>\n" +
                        "            <td>"+dsHienThi.get(i).den+"</td>\n" +
                        "            <td>"+dsHienThi.get(i).nd+"</td>\n" +
                        "            <td>"+ Func.convertLongTimeFull(dsHienThi.get(i).tg)+"</td>\n" +
                        "        </tr>";
            }
        }

//        System.out.println("strHTML =========> " + strHTML);
        return strHTML;
    }

    public String genHtmlListTransCard(ArrayList<ItemCards> dsHienThi){
        String strHTML = "";
        if(dsHienThi != null){
            for(int i = 0; i< dsHienThi.size(); i++){
                strHTML +="  <tr class=\"w-100\">" +
                        "            <td>"+(i+1)+"</td>\n" +
                        "            <td>"+ Func.getVNDFormat(dsHienThi.get(i).tien)+" đ"+ "</td>\n" +
                        "            <td>"+Func.getVNDFormat(dsHienThi.get(i).phi)+" đ"+"</td>\n" +
                        "            <td>"+dsHienThi.get(i).tu+"</td>\n" +
                        "            <td>"+dsHienThi.get(i).den+"</td>\n" +
                        "            <td>"+dsHienThi.get(i).nd+"</td>\n" +
                        "            <td>"+ Func.convertLongTimeFull(dsHienThi.get(i).tg)+"</td>\n" +
                        "        </tr>";
            }
        }
        return strHTML;
    }



    public String genHtmlListQrAmthanh( List<ItemQrAmThanh> list){
        String strHTML = "";

        if(list != null ){
            for(int i = 0; i< list.size(); i++){
                strHTML +=" <tr class=\"w-100\">" +
                        "     <td>"+(i+1)+"</td>\n";

                if(list.get(i).phi> 0){
                    strHTML += " <td> <div class=\"d-flex align-items-center \">"
                            +"<span class=\"pe-3\">C</span>"
                            +"<span>"+Func.getVNDFormat(list.get(i).amount)+" đ"+"</span>"
                            +"</div></td>\n";
                }else{
                    strHTML += " <td> <div class=\"d-flex align-items-center \">"
                            +"<span class=\"pe-3\">T</span>"
                            +"<span>"+Func.getVNDFormat(list.get(i).amount)+ " đ"+"</span>"
                            +"</div></td>\n";
                }

                strHTML += " <td>"+Func.getVNDFormat(list.get(i).phi)+" đ"+"</td>\n" +
                        "    <td>"+list.get(i).content+"</td>\n" +
                        "    <td>"+ Func.convertLongTimeFull(list.get(i).transTime)+"</td>\n" +
                        "   </tr>";
            }
        }
        return strHTML;
    }




}
