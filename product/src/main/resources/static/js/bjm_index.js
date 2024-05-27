// $(function(){
//     clearForm();
// })
let btnCode = document.querySelector(".btnCode")
let btnProduct = document.querySelector(".btnProduct")

btnCode.onclick=()=>{
    btnCode.style.backgroundColor="#719ECE";
    btnCode.style.color="#ff0";
    btnProduct.style.backgroundColor="#F0F0F0";
    btnProduct.style.color="#000"
}

btnProduct.onclick=()=>{
    btnProduct.style.backgroundColor="#719ECE";
    btnProduct.style.color="#ff0";
    btnCode.style.backgroundColor="#F0F0F0";
    btnCode.style.color="#000"
}

let btnR = document.querySelector(".btnR");
btnR.addEventListener("click", () => {
    $.ajax({
        url : "/bjmRegister",
        type : "GET",
        success : (resp) => {
            // alert("성공")
            let temp = $(resp).find(".bjmRegister");
            $(".left").html(temp);
            // alert($(temp).html());
            register();
        }
    })
})

function register(){
    let bjmBtnRegisterR = document.querySelector(".bjmBtnRegisterR");
    bjmBtnRegisterR.addEventListener("click", () => {
        let temp = document.bjmFrmRegister;
        let frm = $(temp).serialize();
        // alert(frm);
        $.ajax({
            url : "/bjmRegisterR",
            type : "POST",
            data : frm,
            success : (resp) => {
                if(resp){
                    alert("성공")
                    clearForm();
                }else{
                    alert("오류발생");
                }
            }
        })
    })
}
// let clearForm = () => {
//     let frm = document.bjmFrmRegister;
//     frm.code.value="";
//     frm.codeName.value="";
// }
// let btnCancel = document.querySelector(".btnCancel");
// btnCancel.addEventListener('click', () => {
//     clearForm();
// })