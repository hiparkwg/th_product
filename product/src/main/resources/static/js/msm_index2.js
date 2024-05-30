$(function(){
    codeList();
    let btnCode = document.querySelector('.btnCode');
    let btnProduct = document.querySelector('.btnProduct');

    btnCode.onclick = codeList;
    btnProduct.onclick = productList;

});

/* code ------------------------------ */

function codeList(){
    let findStr="";
    let nowPage = 1;
    $.ajax({                         
        url : "/code/msm_list",               
        type : "GET",
        data : {'findStr' : findStr, "nowPage" : nowPage},
        success : (resp)=>{           
            let temp = $(resp).find(".msm_container");
            $('.right').html(temp);
            search();
        }   
    });
}

function search(){
    let btnSearch = document.querySelector(".btnSearch");
                
    let btnRegister = document.querySelector(".register");
    btnRegister.onclick = ()=>{
        showRegisterForm();
    }

    $(".btnPrev").on("click", ()=>{
        console.log("prev...")
        let nowPage=1;
        let findStr = $(".findStr").val();
        if(sessionStorage.getItem("codeNowPage") != null){
            nowPage = sessionStorage.getItem("codeNowPage");
            if(nowPage>1) nowPage--;
        }
        loadItem(findStr, nowPage);

    })
    $(".btnNext").on("click", ()=>{
        console.log("nect...")
        let nowPage=1;
        let findStr = $(".findStr").val();
        if(sessionStorage.getItem("codeNowPage") != null){
            nowPage = sessionStorage.getItem("codeNowPage");
            nowPage++;
        }
        loadItem(findStr, nowPage);
    })



    btnSearch.addEventListener('click', ()=>{ 
        let findStr = $(".findStr").val();
        let nowPage = 1;
        sessionStorage.setItem("findStr", findStr);  
        loadItem(findStr, nowPage);
    }
)}

function loadItem(findStr, nowPage){
    console.log("loadItem.....", findStr, nowPage)
    $.ajax({
        url  : "/code/msm_list",
        type : "GET",
        data : {"findStr" : findStr, "nowPage" : nowPage},
        success : (resp)=>{
            let temp = $(resp).find(".item");
            $(".items").html(temp);
            sessionStorage.setItem("codeNowPage", nowPage);
        }
    })
}





/* product ------------------------------- */

function productList(){
    let findStr="";
    $.ajax({                         
        url : "/product/msm_list",               
        type : "GET",
        data : {'findStr' : findStr},
        success : (resp)=>{           
            let temp = $(resp).find(".msm_container");
            $('.right').html(temp);
            productSearch();
        }   
    });
}

function productSearch(){
    console.log("1")
    let btnSearch = document.querySelector(".btnSearch");

    let btnRegister = document.querySelector(".register");
    btnRegister.onclick = ()=>{
        showProductRegisterForm();
    }


    btnSearch.addEventListener('click', ()=>{ 
        let findStr = $(".findStr").val();
        console.log("2" , findStr)
        sessionStorage.setItem("findStr", findStr);  

        $.ajax({
            url : "/product/msm_list", 
            type : "GET",
            data : {"findStr" : findStr},
            success : (resp)=>{
                let temp = $(resp).find(".item");
                $(".items").html(temp);
            }
        }
    )}
)}

