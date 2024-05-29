
let krhView = (sno)=> {
    $.ajax({
        url:"/krh_view",
        type: "GET",
        data: {"sno":sno},
        success : (resp)=>{
            let temp=$(resp).find(".view");
            $('.center .left').html(temp);
            krhViewEvent(sno);
        }
    })
}

function krhViewEvent(sno){
    let btnDelete = document.querySelector(".btnDelete");
    let btnModify = document.querySelector(".csyBtnModify");
    btnModify.onclick = ()=>{
        productUpdateForm(sno);
    }
    
    btnDelete.addEventListener('click',()=>{
        let yn=confirm('정말 삭제하시겠습니까?');
        if(!yn) return;

        $.ajax({
            url:"/krhDeleteR",
            type:"GET",
            data:{"sno":sno},
            success:(resp)=>{
                setTimeout(()=>{
                    alert(resp)
                },200);
            }
        })
    })
}
