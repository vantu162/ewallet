package com.example.vimass_e_wallet.services;

import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.acc.LoginRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjQrAmThanhRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjSaoKeNHNNRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjSaokeTheRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class CallServices {

    public static CallServices instance;
    static {
        instance = new CallServices();
    }
    //*************************Using RestTemplate*************************

    // get sao ke nhnn

    public Response getSaoKeNHNN(ObjSaoKeNHNNRequest objSaoKeNHNN) {

        // Tạo URL với các tham số truy vấn (query parameters)
        URI uri = UriComponentsBuilder.fromHttpUrl(API.instance.saoke_bank)
                .queryParam("fromDate", objSaoKeNHNN.fromDate)
                .queryParam("toDate", objSaoKeNHNN.toDate)
                .queryParam("typeTranfer", objSaoKeNHNN.typeTranfer)
                .queryParam("session", objSaoKeNHNN.session)
                .queryParam("VMApp", objSaoKeNHNN.VMApp)
                .queryParam("user", objSaoKeNHNN.user)
                .queryParam("checkSum", objSaoKeNHNN.getCKS())
                .queryParam("amount", getValue(objSaoKeNHNN.amount))
                .queryParam("amountFrom", getValue(objSaoKeNHNN.amountFrom))
                .queryParam("amountTo", objSaoKeNHNN.amountTo)
                .queryParam("limit", objSaoKeNHNN.limit)
                .queryParam("offset", objSaoKeNHNN.offset)
                .queryParam("ver", String.valueOf(objSaoKeNHNN.ver))
                .build()
                .toUri();
        System.out.println("url ==========> " + uri.toString());
        RestTemplate restTemplate = new RestTemplate();
        //GET request
        Response res = restTemplate.getForObject(uri, Response.class);
        //System.out.println("res sk ==========> " + res.toString());

        return res;
    }
    //POST
    public Response postSaoKeThe(ObjSaokeTheRequest objSaokeTheRequest){
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("objSaokeTheRequest: " + objSaokeTheRequest.toString());
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity containing headers and body
        HttpEntity<String> entity = new HttpEntity<>(objSaokeTheRequest.toString(), headers);

        // Make a POST request
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.url_saoKe_the, entity, Response.class);
        Response res = response.getBody();
        // Output the response
        System.out.println("2: " + res.result);
//        System.out.println("2: " + res.msgCode);
//        System.out.println("3: " + res.msgContent_en);
        return res;
    }


    private String getValue(Double x){
        if(x > 0){
            return  String.valueOf(x);
        }else {
            return String.valueOf(0);
        }
    }



    //POST
    public Response postLogin(){
        RestTemplate restTemplate = new RestTemplate();
        LoginRequest obj =  new LoginRequest();
        obj.user= "0911588925";
        obj.pass= "04091999";
        obj.deviceId =3;
        obj.companyCode ="";
        obj.type = 1;

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity containing headers and body
        HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);

        // Make a POST request
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.login, entity, Response.class);
        Response res = response.getBody();
        // Output the response
        System.out.println("1: " + res.result);
//        System.out.println("2: " + res.msgCode);
//        System.out.println("3: " + res.msgContent_en);
        return res;
    }

    //POST
    public Response postLoginV1(String userName, String passWord){
        RestTemplate restTemplate = new RestTemplate();
        LoginRequest obj =  new LoginRequest();
        obj.user= userName;
        obj.pass= passWord;
        obj.deviceId =3;
        obj.companyCode ="";
        obj.type = 1;

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity containing headers and body
        HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);

        // Make a POST request
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.login, entity, Response.class);
        Response res = response.getBody();
        // Output the response
        System.out.println("1: " + res.result);
//        System.out.println("2: " + res.msgCode);
//        System.out.println("3: " + res.msgContent_en);
        return res;
    }


    //POST
    public Response postSaoKeQrAmThanh(ObjQrAmThanhRequest objQrAmThanhRequest){
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("objQrAmThanhRequest: " + objQrAmThanhRequest.toString());
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity containing headers and body
        HttpEntity<String> entity = new HttpEntity<>(objQrAmThanhRequest.toString(), headers);
        // Make a POST request
        ResponseEntity<Response> response = restTemplate.postForEntity(API.instance.url_saoKe_qr_amthanh, entity, Response.class);
        Response res = response.getBody();
        // Output the response

        return res;
    }



}
