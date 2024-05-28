$(function(){
    list();
});


function list(){
    $.ajax({                         
        url : "/list",               
        type : "GET",
        data : {'findStr' : findStr},
        success : (resp)=>{           
            let temp = $(resp).find(".change");
            $('.change').html(temp);
            search();
        }   
    });
}

function search(){
    let btnSearch = document.querySelector(".btnSearch");

    btnSearch.addEventListener('click', ()=>{ 
        findStr = $(".findStr").val();
        sessionStorage.setItem("findStr", findStr);  

        $.ajax({
            url  : "/list",
            type : "GET",
            data : {"findStr" : findStr},
            success : (resp)=>{
                let temp = $(resp).find(".item");
                $(".items").html(temp);
            }
        }
    )}
)}
