let productUpdateForm=(sno)=>{
    $.ajax({
        url      : "/csyProductForm",
        type     : "GET",
        data     :{"sno" : sno},
        success : (resp)=>{
            let temp = $(resp).find(".codeUpdateForm");
            $(".left").html(temp);

            let btn = document.querySelector('.csyBtnModifyR');
            btn.onclick=()=>{
                productUpdate();
            }

        }
    })
}


let productUpdate = () => {
    let frm = document.csyFrmProductModify;
    let frmData = $(frm).serialize();
    $.ajax({
        url : "/csyProductUpdate",
        type: "POST",
        data: frmData,
        success: (resp) => {
            if (resp) {
                // load();
                // clearForm();
                alert("수정에 성공하였습니다.")
            } else {
                alert("수정 중 오류가 발생하였습니다.");
            }
        }
    })
}

