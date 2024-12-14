package com.example.vimass_e_wallet.services;

import com.example.vimass_e_wallet.model.phi.*;
import com.example.vimass_e_wallet.model.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class CallServices_Phi {
    public static CallServices_Phi instance;
    static {
        instance = new CallServices_Phi();
    }

    public Response resTongGD_ThuChi(ObjThuChiRequest objThuChiRequest){

        // Tạo URL với các tham số truy vấn (query parameters)
        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.tong_gd_thu_chi)
                .queryParam("fromDate", String.valueOf(objThuChiRequest.fromDate))
                .queryParam("toDate", String.valueOf(objThuChiRequest.toDate))
                .queryParam("typeTranfer", String.valueOf(objThuChiRequest.typeTranfer))
                .queryParam("session", objThuChiRequest.session)
                .queryParam("VMApp", String.valueOf(objThuChiRequest.VMApp))
                .queryParam("user", objThuChiRequest.user)
                .queryParam("checkSum", objThuChiRequest.checkSum)
                .queryParam("amount", objThuChiRequest.amount)
                .queryParam("amountFrom", String.valueOf(objThuChiRequest.amountFrom))
                .queryParam("amountTo", String.valueOf(objThuChiRequest.amountTo))
                .queryParam("limit", String.valueOf(objThuChiRequest.limit))
                .queryParam("offset", String.valueOf(objThuChiRequest.offset))
                .queryParam("ver", String.valueOf(1))
                .build()
                .toUri();
        System.out.println("url ==========> " + uri.toString());
        RestTemplate restTemplate = new RestTemplate();
        //GET request
        Response res = restTemplate.getForObject(uri, Response.class);
        return res;
    }

    public Response resThongKeGDtheoNgay(String input){

        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.thong_ke_gd_theo_gio_trong_ngay)
                .queryParam("input", input)
                .build()
                .toUri();
        System.out.println("resThongKeGDtheoNgay url ==========> " + uri.toString());
        RestTemplate restTemplate = new RestTemplate();
        //GET request
        Response res = restTemplate.getForObject(uri, Response.class);
        return res;
    }


    public String postBankDTO(BankDTORequest bankDTORequest){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(bankDTORequest.toString(), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(API.instance.chi_ho, entity, String.class);
        return response.getBody();
    }


    public double getPhiHoanTra(String param) {

        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.quan_li_phi)
                .queryParam("pass", "84935896gjskfvjfhgQEWRHGs")
                .queryParam("param", param)
                .build()
                .toUri();
//        System.out.println("getQuanLyPhi uri==========> " + uri);

        RestTemplate restTemplate = new RestTemplate();
        //GET request
        double res = restTemplate.getForObject(uri, double.class);
//        System.out.println("getQuanLyPhi ==========> " + res);

        return res;
    }
    public String getlayPhiChiHoPVCB(long timeFrom, long timeTo, int type) {

        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.vpb_chi_ho)
                .queryParam("timeFrom", timeFrom)
                .queryParam("timeTo", timeTo)
                .queryParam("type", type)
                .build()
                .toUri();
//        System.out.println("getlayPhiChiHoPVCB uri==========> " + uri);

        RestTemplate restTemplate = new RestTemplate();
        //GET request
        String res = restTemplate.getForObject(uri, String.class);
//        System.out.println("getlayPhiChiHoPVCB ==========> " + res);

        return res;
    }

    public String postLayPhiChiHoBIDV(BankDTORequest bankDTORequest) {

//        System.out.println("bankDTORequest: " + bankDTORequest.toString());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(bankDTORequest.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity(API.instance.chi_ho, entity, String.class);
//        System.out.println("postLayPhiChiHoBIDV ==========> " + response.getBody());

        return response.getBody();
    }

    public ObjThuQuaQR_Response postLayPhiThuQuaQR(ObjThuQuaQR_Request obj) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);
        ResponseEntity<ObjThuQuaQR_Response> response = restTemplate.postForEntity(API.instance.thu_qua_qr, entity, ObjThuQuaQR_Response.class);
        ObjThuQuaQR_Response res = response.getBody();
        //        System.out.println("postLayPhiThuQuaQR ==========> " + response.getBody());
        return res;
    }


    public ObjThuQuaTheResponse postLayPhiThuQuaQR(ObjThuQuaTheRequest obj) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);
        ResponseEntity<ObjThuQuaTheResponse> response = restTemplate.postForEntity(API.instance.thu_qua_the, entity, ObjThuQuaTheResponse.class);
        ObjThuQuaTheResponse res = response.getBody();
        //        System.out.println("postLayPhiThuQuaQR ==========> " + response.getBody());
        return res;
    }
}
