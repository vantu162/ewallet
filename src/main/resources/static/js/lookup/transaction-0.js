$(document ).ready(function() {

    let tatolItemTrans = [];
    var a = $("body #listTrans").attr("data-info");
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
                    getDataSK(pages[i].a,100, 1);
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
                    getDataSK(pages[i].a,100,1);
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
                    getDataSK(pages[i].a,100, 1);
                    break;
                }
            }

        }
    })

    // function showAlert(message, time) {
    //     $("#alertMessage").text(message); // Đặt nội dung thông báo
    //     $("#customAlert").fadeIn(); // Hiển thị thông báo
    //     setTimeout(() => {
    //         $("#customAlert").fadeOut(); // Ẩn thông báo sau thời gian nhất định
    //     }, time);
    // }
    $("#btnTransaction").on('click',function(){
        // alert("click")
        var timeFrom = $('#datepickerFrom').val();
        var timeTo = $('#datepickerTo').val();

        var time =  getTimeMiliSecons(timeFrom);
        var time1 =  getTimeMiliSecons(timeTo);
        if(time1 > time){
            getDataSK(0,100, 0);
        }else{
            alert("Ngày bắt đầu phải nhỏ hơn ngày kết thúc!");
            // showAlert("Ngày bắt đầu phải nhỏ hơn ngày kết thúc!",3000);
        }


    });

    function getTimeMiliSecons(input){// Parse it to a Date object
        const [day, month, year, hour, minute, second] = input.match(/\d+/g);

        // Convert to Date object (month is 0-based, so subtract 1)
        const date = new Date(year, month - 1, day, hour, minute, second);

        // Get milliseconds
        const milliseconds = date.getTime();

        console.log(`Milliseconds: ${milliseconds}`);
        return milliseconds;
    }

    function getDataSK(a,b, type) {
        $("#loader").show();
        $.ajax({
            url: '/transaction',
            type: 'GET',
            data: {
                typeE: $('#typeE').val(),
                typeTran: $('#typeTrans').val(),
                offset: Number(a),
                limit: Number(b),
                amountFrom: $('#amountFrom').val(),
                amountTo: $('#amountTo').val(),
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
                        $("#listTrans").empty().append(str);
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

