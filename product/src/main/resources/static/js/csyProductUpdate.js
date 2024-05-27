let csyBtnModify = document.querySelector(".csyBtnModify");

csyBtnModify.onclick = () => {
    let frm = document.csyFrmProductModify;
    let frmData = $(frm).serialize();
    alert(frmData);
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

