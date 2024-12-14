package com.example.vimass_e_wallet.services;

import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeViRequest;
import com.example.vimass_e_wallet.model.donvi_model.ObjSaoKeViRequest_v1;
import com.example.vimass_e_wallet.model.phi.ObjThuChiRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class CallServices_DonVi {

    public static CallServices_DonVi instance;
    static {
        instance = new CallServices_DonVi();
    }

    public Response postSaoKeVi(ObjSaoKeViRequest objSaoKeViRequest){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(objSaoKeViRequest.toString(), headers);
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.sao_ke_vi_dn, entity, Response.class);
//        System.out.println("postSaoKeVi ==========> " + response.getBody());
        return response.getBody();
    }

    public Response postSaoKeVi_1(ObjSaoKeViRequest_v1 objSaoKeViRequest_v1){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(objSaoKeViRequest_v1.toString(), headers);
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.sao_ke_vi_dn, entity, Response.class);
//        System.out.println("postSaoKeVi ==========> " + response.getBody());
        return response.getBody();
    }
    public String getListViDN() {

        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.ds_vi_doanh_nghiep)
                .queryParam("pass", "84935896gjskfvjfhgQEWRHGs")
                .queryParam("param", "28_xxx_efwi5839jksr95635")
                .build()
                .toUri();
        System.out.println("getListViDN uri==========> " + uri);
        RestTemplate restTemplate = new RestTemplate();
        //GET request
        String res = restTemplate.getForObject(uri, String.class);

        return res;
    }
}
