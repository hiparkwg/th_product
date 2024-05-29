/*
let findStr = document.querySelector(".findStr");
let btnManage = document.querySelector(".btnManage");
btnManage.onclick=()=>{
   load();

}
let register = ()=>{

    let btnRegister = document.querySelector(".btnRegister");
    btnRegister.onclick=()=>{
       
        $.ajax({
            url:"/register",
            type:"GET",
            success:(resp)=>{
                let temp = $(resp).find(".register");
                $(".left").html(temp);
                let btnregisterR = document.querySelector(".btnregisterR");
                btnregisterR.onclick=()=>{
                    let temp = document.frmDisplay;
                    let frm = $(temp).serialize();
                    $.ajax({
                        url:"/registerR",
                        type:"POST",
                        data:frm,
                        success:(resp)=>{
                            load();
                        }
                    })
                }
            }
        })
       
    }
    
}
let choiView = (code)=>{
    $.ajax({
        url:"/update",
        type:"GET",
        data:{"code":code},
        success:(resp)=>{
            let temp =$(resp).find(".update");
            $(".left").html(temp);
            let btnUpdateR = document.querySelector(".btnUpdateR");
            btnUpdateR.onclick=()=>{
                let ftemp = document.frmDisplay;
                let ffrm = $(ftemp).serialize();

                $.ajax({
                    url:"/updateR",
                    type:"POST",
                    data:ffrm,
                    success:(resp)=>{
                        load();
                    }
                })
            }
        }

    })
}

  

let load=()=>{
    let findStr="";
    if(sessionStorage.getItem("findStr") != null){
        findStr = sessionStorage.getItem("findStr");}
    $.ajax({
        url:"/view",
        type:"GET",
        success:(resp)=>{
        let temp = $(resp).find(".view");
        $(".left").html(temp);
        }
    })
    
    $.ajax({
        url:"/list",
        type:"GET",
        data:{"findStr":""},
        success:(resp)=>{
            let temp = $(resp).find(".change");
            $(".right").html(temp);
            register();
        }
    })
}
*/


function codeUpdateForm(code){
    $.ajax({
        url     : "/update",
        type    : "GET",
        data    : {"code" : code},
        success : (resp)=>{
            let temp = $(resp).find(".update");
            $('.left').html(temp);
            let btn = document.querySelector('.btnUpdateR');
            btn.onclick = codeUpdateR;
        }
    })
}
function codeUpdateR(){
    let yn = confirm("정말 수정하려고???");
    if( !yn ) return;
    
    let temp = document.frmDisplay;
    let frm = $(temp).serialize();
    $.ajax({
        url     : "/updateR",
        type    : "POST",
        data    : frm,
        success : (resp)=>{
            alert(resp)
        }
    })
}




