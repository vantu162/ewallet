package com.example.vimass_e_wallet.controller.donvi;

import com.example.vimass_e_wallet.controller.phi.PhiDTO;
import com.example.vimass_e_wallet.controller.phi.ToolPhi;
import com.example.vimass_e_wallet.html.GenHTML_DonVi;
import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.donvi_model.ItemViDN;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeGDViDN;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeViRequest;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeViRequest_v1;
import com.example.vimass_e_wallet.model.phi.ObjThuChi;
import com.example.vimass_e_wallet.model.phi.ObjThuChiResponse;
import com.example.vimass_e_wallet.model.tracuu.ItemCards;
import com.example.vimass_e_wallet.model.tracuu.ItemTrans;
import com.example.vimass_e_wallet.services.CallServices_DonVi;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class DonViController {

    @PostMapping ("/donvi/saoke_v")
    @ResponseBody
    public String resSaoKeV(@RequestParam String idVi,
            @RequestParam String timeFrom, @RequestParam String timeTo,
                            @RequestParam int limit, @RequestParam int offset,
                            @RequestParam int type, @RequestParam String content) {
        System.out.println("here");
        String result = "";
        try{
            AccountInfo acc = new AccountInfo();
            if(DataSystem.instance.accountInfo != null) {
                acc = DataSystem.instance.accountInfo;
            }
        ObjSaoKeViRequest objSaoKeViRequest = ToolDonVi.instance.getValueObjSaoKeViRequest(acc,idVi,limit,offset,type,content,timeFrom,timeTo);
            System.out.println("objSaoKeViRequest: "+ objSaoKeViRequest.toString());
        Response res = CallServices_DonVi.instance.postSaoKeVi(objSaoKeViRequest);

        ObjSaoKeGDViDN objSaoKeGDViDN = new Gson().fromJson(new Gson().toJson(res.getResult()), ObjSaoKeGDViDN.class);

            result =  GenHTML_DonVi.instance.genHtmlSaoKeGDViDN(objSaoKeGDViDN);
            System.out.println("result "+ result);
        }catch (Exception e){
            System.out.println("resSaoKeV e:"+ e.getMessage());
        }

        return result;
    }

    @PostMapping ("/donvi/saoke_v1")
    @ResponseBody
    public String resSaoKeV1(@RequestParam String idVi,
                            @RequestParam String timeFrom, @RequestParam String timeTo,
                            @RequestParam int limit, @RequestParam int offset,
                            @RequestParam int type, @RequestParam String content) {
        System.out.println("here");
        String result = "";
        try{
            AccountInfo acc = new AccountInfo();
            if(DataSystem.instance.accountInfo != null) {
                acc = DataSystem.instance.accountInfo;
            }
            ObjSaoKeViRequest_v1 objSaoKeViRequest_v1 = ToolDonVi.instance.getValueObjSaoKeViRequest_v1(acc,idVi,limit,offset,type,content,timeFrom,timeTo);
            System.out.println("ObjSaoKeViRequest_1: "+ objSaoKeViRequest_v1.toString());
            Response res = CallServices_DonVi.instance.postSaoKeVi_1(objSaoKeViRequest_v1);


            System.out.println("resSaoKeV "+ res.toString());

        }catch (Exception e){
            System.out.println("resSaoKeV e:"+ e.getMessage());
        }

        return result;
    }


    @GetMapping("/donvi/dsvidn")
    @ResponseBody
    public String resDsViDoanhNghiep() {
        String result = "";
        try{
          String res =  CallServices_DonVi.instance.getListViDN();

            List<ItemViDN> list = new ArrayList<ItemViDN>();
            Type collectionType_sk = new TypeToken<List<ItemViDN>>(){}.getType();

            list = new Gson().fromJson(res, collectionType_sk);
            Collections.sort(list, new Comparator<ItemViDN>() {
                @Override
                public int compare(ItemViDN x, ItemViDN x1) {
                    return x.tenVietTat.compareTo(x1.tenVietTat);
                }
            });

            result = GenHTML_DonVi.instance.genHtml_DsViDN(list);
            System.out.println("dsViDoanhNghiep: " + list.size());

        }catch (Exception e){
            System.out.println("resDsViDoanhNghiep e:"+ e.getMessage());
        }
        return result;
    }
}
