let btnR = document.querySelector(".btnR");
btnR.addEventListener("click", () => {
    $.ajax({
        url : "/bjmRegister",
        type : "GET",
        success : (resp) => {
            let temp = $(resp).find(".bjmRegister");
            $(".left").html(temp);
            register();
        }
    })
})

function register(){
    let bjmBtnRegisterR = document.querySelector(".bjmBtnRegisterR");
    bjmBtnRegisterR.addEventListener("click", () => {
        let temp = document.bjmFrmRegister;
        let frm = $(temp).serialize();
        $.ajax({
            url : "/bjmRegisterR",
            type : "POST",
            data : frm,
            success : (resp) => {
                if(resp){
                    alert("성공")
                }else{
                    alert("실패");
                }
            }
        })
    })
}