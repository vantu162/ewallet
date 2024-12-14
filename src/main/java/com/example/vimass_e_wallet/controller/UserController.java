package com.example.vimass_e_wallet.controller;

import com.example.vimass_e_wallet.html.GenHTML;
import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.acc.AccInfoQrAmThanh;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.tracuu.*;
import com.example.vimass_e_wallet.services.CallServices;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.example.vimass_e_wallet.tool.GetValue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/saokeqr")
    public String saoKeQR(){
        return "user/saokeQR";
    }


    @PostMapping("/transaction_1")
    @ResponseBody
    public String resTransaction( @RequestParam int typeTran,
                                 @RequestParam int offset, @RequestParam int limit,
                                 @RequestParam String timeFrom, @RequestParam String timeTo) {
        String htmlTrans ="";
        String tatolItem = "";
        String tatolAmo = "";
        AccountInfo acc = new AccountInfo();
        if(DataSystem.instance.accountInfo != null) {
            acc = DataSystem.instance.accountInfo;
            ObjQrAmThanhRequest obj = GetValue.instance.getValueObjQrAmThanhRequest(acc.secssion, acc.phone, limit, offset,
             timeFrom, timeTo, typeTran);
            System.out.println("ObjQrAmThanhRequest input ======> " + obj.toString());
            Response res= CallServices.instance.postSaoKeQrAmThanh(obj);

            System.out.println("ObjQrAmThanhRequest ======> " + res.toString());

            ObjQrAmThanhResponse objQrAmThanhResponse = new Gson().fromJson(new Gson().toJson(res.getResult()), ObjQrAmThanhResponse.class);

            htmlTrans += GenHTML.instance.genHtmlListQrAmthanh(objQrAmThanhResponse.getList());
            tatolItem = String.valueOf(objQrAmThanhResponse.getList().size());

            AccInfoQrAmThanh accInfoQrAmThanh = new Gson().fromJson(new Gson().toJson(objQrAmThanhResponse.getAccInf()), AccInfoQrAmThanh.class);
            tatolAmo += Func.getVNDFormat(accInfoQrAmThanh.amo);
        }
        // Trả về JSON cho jQuery
        return tatolItem + "___" + htmlTrans +"___"+tatolAmo;
    }

}
