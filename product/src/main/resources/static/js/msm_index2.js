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
    $.ajax({                         
        url : "/code/msm_list",               
        type : "GET",
        data : {'findStr' : findStr},
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

    btnSearch.addEventListener('click', ()=>{ 
        let findStr = $(".findStr").val();
        sessionStorage.setItem("findStr", findStr);  

        $.ajax({
            url  : "/code/msm_list",
            type : "GET",
            data : {"findStr" : findStr},
            success : (resp)=>{
                let temp = $(resp).find(".item");
                $(".items").html(temp);
            }
        })
    
    }

)}





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

