$(function(){
    list(); //list를 부를거야
});

let view = (sno)=> {
  
    $.ajax({
        url:"/krh_view",
        type: "GET",
        data: {"sno":sno},
        success : (resp)=>{
            let temp=$(resp).find(".view");
            $('.center .left').html(temp);
            viewEvent(sno);
        }
    })
}

function viewEvent(sno){
    let btnDelete = document.querySelector(".btnDelete");

    btnDelete.addEventListener('click',()=>{
        let yn=confirm('정말 삭제하시겠습니까?');
        if(!yn) return;

        $.ajax({
            url:"/deleteR",
            type:"GET",
            data:{"sno":sno},
            success:(resp)=>{
                list("")
                    setTimeout(()=>{
                        alert(resp)
                    },200);
            }
        })
    })
}
