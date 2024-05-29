
let view = (code)=>{
    $.ajax({
        url : "/ojw_view",
        type : "GET",
        data : {"code" : code},
        success : (resp)=>{
            let temp = $(resp).find(".ojw_view");
            $('.center .left').html(temp);
            viewEvent(code);
        }
    });
}

function viewEvent(code){
    let btnDelete = document.querySelector(".btnDelete");
    let btnUpdate = document.querySelector(".btnCodeUpdateForm");
    btnUpdate.onclick=()=>{
        codeUpdateForm(code);
    }

    btnDelete.addEventListener("click",()=>{
        let yn = confirm(code + "를 삭제하시겠습니까?");
        if(!yn) return;

        $.ajax({
            url : "/deleteR",
            type : "GET",
            data : {"code" : code},
            success : (resp)=>{
                list("")
                setTimeout(()=>{
                    alert(resp)
                }, 200);
            }
        })
    })
}