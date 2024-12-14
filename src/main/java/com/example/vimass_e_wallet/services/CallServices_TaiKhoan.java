package com.example.vimass_e_wallet.services;

import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTraCuuThongTinVdtRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjQrAmThanhRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjSaoKeNHNNRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class CallServices_TaiKhoan {

    public static CallServices_TaiKhoan instance;
    static {
        instance = new CallServices_TaiKhoan();
    }

    //POST
    public Response postTraCuuThongTinVDT(ObjTraCuuThongTinVdtRequest objTraCuuThongTinVdtRequest ){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(objTraCuuThongTinVdtRequest.toString(), headers);
        // Make a POST request
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.SERVICE_TRACUU_THONGTIN_VDT, entity, Response.class);
        Response res = response.getBody();

        return res;
    }

    public Response getListBankInfo() {

        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.SERVICE_LIST_BANK)
                .queryParam("pass", "84935896gjskfvjahSGHSHS")

                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        //GET request
        Response res = restTemplate.getForObject(uri, Response.class);

        return res;
    }

}
