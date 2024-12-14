package com.example.vimass_e_wallet.html;

import com.example.vimass_e_wallet.model.donvi_model.ItemViDN;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeGDViDN;
import com.example.vimass_e_wallet.model.phi.ObjThongKeGD;
import com.example.vimass_e_wallet.model.tracuu.ItemCards;
import com.example.vimass_e_wallet.model.tracuu.ItemTrans;
import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GenHTML_DonVi {
    public static GenHTML_DonVi instance;
    static { instance = new GenHTML_DonVi();}

    public String genHtml_DsViDN(List<ItemViDN> list){
        String html = "";
        for(ItemViDN item: list){
            html +="<option class=\"text-start\" value=\'"+item.soViVimass+"'\">"+item.tenVietTat+"</option>";
        }
        return html;
    }

    public String genHtmlSaoKeGDViDN(ObjSaoKeGDViDN objSaoKeGDViDN){
        String html = "";
        try{

            Type collectionType = new TypeToken<List<ItemTrans>>(){}.getType();
            List <ItemTrans> list = new Gson().fromJson(new Gson().toJson(objSaoKeGDViDN.dsHienThi), collectionType);

            for(int i = 0; i < list.size(); i++){
                html  +="  <tr class=\"w-100\">" +
                        "            <td class=\"w-25\">"+(i+1)+"</td>\n" +
                        "            <td class=\"w-25\">"+ list.get(i).maGiaoDichSaoKe+" đ"+ "</td>\n" +
                        "            <td class=\"w-25\">"+Func.getVNDFormat(list.get(i).tien)+" đ"+"</td>\n" +
                        "            <td class=\"w-25\">"+list.get(i).nd+"</td>\n" +
                        "            <td class=\"w-25\">"+ Func.convertLongTimeFull(list.get(i).tg)+"</td>\n" +
                        "        </tr>";
            }

        }catch (Exception e){
            System.out.println("genHtmlSaoKeGDViDN e: "+e.getMessage());
        }

        return html;

    }

}
