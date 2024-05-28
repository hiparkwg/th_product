$(function(){ //body가 준비되면 실행시키라는 함수
    // 자동실행
    list();
});

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