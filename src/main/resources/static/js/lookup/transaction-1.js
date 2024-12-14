$(document ).ready(function() {

    let tatolItemTrans = [];
    var a = $("#tatolItem").text();
    // alert(a);
    if(a != "undefined"){

        var pages = [];
        pages = renderPage(0,a,100)
    }

    if(tatolItemTrans.length >= 0){
        pagegitonV1(1, pages.length);
    }

    $("body" ).on("click","#paging div",function(){
        var num =  Number($(this ).children().text());

        // console.log("num ====> " +  isNaN(num))
        if(!isNaN(num) & num > 0){
            // alert(num)
            pagegitonV1(num, pages.length);
            for(let i = 0; i <= pages.length; i++){

                if(i == (num - 1)){
                 // alert("div a: " +pages[i].a +"/ b:"+pages[i].b );
                    getData(pages[i].a,pages[i].b, 1);
                    break;
                }
            }

        }
    })

    $("#prePaging").on('click',function(){
        var num = Number($(".active-trans").children().text()) - 1;
        if(!isNaN(num) && num > 0){

            pagegitonV1(num, pages.length);

            for(let i = 0; i <= pages.length; i++){
                if(i == (num - 1)){
                   // alert("pre a: " +pages[i].a +"/ b:"+pages[i].b );
                    getData(pages[i].a,pages[i].b,1);
                    break;
                }
            }
        }
    })

    $("#nextPaging").on('click',function(){
        var num = Number($(".active-trans").children().text()) + 1;
        if(!isNaN(num) && num <= pages.length){

            pagegitonV1(num, pages.length);

            for(let i = 0; i < pages.length; i++){

                if(i == (num - 1)){
                    // alert("next a: " +pages[i].a +"/ b:"+pages[i].b );
                   getData(pages[i].a,pages[i].b, 1);
                    break;
                }
            }

        }
    })

    $("#btnTransaction").on('click',function(){
        getData(0,100, 0);

    });

    function getData(a,b, type) {
        $("#loader").show();
        $.ajax({
            url: '/transaction_1',
            type: 'POST',
            data: {
                typeTran: $('#typeTrans').val(),
                offset: Number(a),
                limit: Number(b),
                timeFrom: $('#datepickerFrom').val(),
                timeTo: $('#datepickerTo').val()
            },
            success: function(data) {
                if(data != null){
                    if(data.indexOf("___")!=-1){

                        tatolItemTrans = data.split("___")[0];
                        var str = data.split("___")[1];
                        $("body #listTrans").attr("data-info", tatolItemTrans);
                        if(type == 0){
                            pages = renderPage(0,tatolItemTrans,100);
                            pagegitonV1(1, pages.length);
                        }
                        $("#tatolItem").empty();
                        $("#tatolItem").append(tatolItemTrans);


                        $("#tatolAmo").empty();
                        $("#tatolAmo").append(data.split("___")[2]);

                        if(str.length > 0){
                            $("#listTrans").empty();
                            $("#listTrans").append(str);
                        }else{
                            var content =" Chưa có giao dich!";
                            $("#noti").empty().append(content);
                        }


                        $("#loader").hide();

                    }
                }
            },
            error: function(error) {
                alert("có lỗi xảy ra");
                console.log('Có lỗi xảy ra.');
            }
        });
    }
});

function pagegitonV1(numPage, tatolItem){
     // alert(tatolItem)
    if(tatolItem > 0){
        $("#prePaging").show();
        $("#nextPaging").show();

        var htmlPagination = "";
        var styleItem ="d-flex align-items-center justify-content-center btn-trans";
        var styleActive =" active-trans";

        if(tatolItem <= 8){

            for(let i = 1; i <= tatolItem ; i++){

                if(i == numPage){
                    htmlPagination +="<div class='"+styleItem+ styleActive+"' ><span>" +i+"</span></div>";
                }else{
                    htmlPagination += "<div class='" + styleItem + "' ><span>" + i + "</span></div>";
                }
            }

        }else{
            if(numPage < 5 ){
                if(tatolItem <= 5 ){
                    for(let i = 1; i <= tatolItem ; i++){

                        if(i == numPage){
                            htmlPagination +="<div class='"+styleItem+ styleActive+"' ><span>" +i+"</span></div>";
                        }else{
                            htmlPagination += "<div class='" + styleItem + "' ><span>" + i + "</span></div>";
                        }
                    }
                }else if (tatolItem > 5) {

                    for (let i = 1; i <= 5; i++) {

                        if (i == numPage) {
                            htmlPagination += "<div class='" + styleItem + styleActive + "' ><span>" + i + "</span></div>";
                        } else {
                            htmlPagination += "<div class='" + styleItem + "' ><span>" + i + "</span></div>";
                        }
                    }
                    htmlPagination += "<div class='" + styleItem + "'><span>...</span></div>";
                    htmlPagination += "<div class='" + styleItem + "'><span>" + tatolItem + "</span></div>";
                }
            }

            if(numPage >= 5 && numPage <= (tatolItem-4)){

                var index = numPage+1;
                // alert("num =======> " +(numPage-1) +" /" + numPage + "/ " +index)
                htmlPagination +="<div class='"+styleItem+"'><span>" +1+"</span></div>";
                htmlPagination +="<div class='"+styleItem+"'><span>...</span></div>";

                htmlPagination +="<div class='"+styleItem+"'><span>"+(numPage-1)+"</span></div>";
                htmlPagination +="<div class='"+styleItem+styleActive+"'><span>"+numPage+"</span></div>";

                htmlPagination +="<div class='"+styleItem+"'><span>"+index+"</span></div>";

                htmlPagination +="<div class='"+styleItem+"'><span>...</span></div>";
                htmlPagination +="<div class='"+styleItem+"'><span>" +tatolItem+"</span></div>";
            }

            if(numPage > tatolItem-4 && (tatolItem-4) >= 5){

                htmlPagination +="<div class='"+styleItem+"'><span>"+1+"</span></div>";
                htmlPagination +="<div class='"+styleItem+"'><span>...</span></div>";
                for(let i = (tatolItem-4); i <= tatolItem ; i++){

                    if(i == numPage){
                        htmlPagination +="<div class='"+styleItem+ styleActive+"'><span>" +i+"</span></div>";
                    }else{
                        htmlPagination +="<div class='"+styleItem+"'><span>" +i+"</span></div>";
                    }
                }
            }

        }
        $("#paging").empty();
        $("#paging").append(htmlPagination);

    }else{
        $("#prePaging").hide();
        $("#nextPaging").hide();
    }
}


function renderPage(start, end, step){
    var pages = [];
    var itemPage = null;
    for (let i = start; i < end; i += step) {
        itemPage = { a: i, b: i + step };

       // console.log("titemPage: " + JSON.stringify(itemPage));
        pages.push(itemPage);
    }

    // alert("pages: " + pages.length);

    return pages;
}

