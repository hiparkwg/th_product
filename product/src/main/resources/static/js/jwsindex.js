let btnR = document.querySelector(".btnR");
btnR.addEventListener("click", () => {
    $.ajax({
        url : "/jwsregister",
        type : "GET",
        success : (resp) => {
            let temp = $(resp).find(".jwsregister");
            $(".left").html(temp);
            register();
        }
    })
})

function register(){
    let jwsBtnRegisterR = document.querySelector(".jwsBtnregisterR");
    jwsBtnregisterRegisterR.addEventListener("click", () => {
        let temp = document.jwsFrmRegister;
        let frm = $(temp).serialize();
        $.ajax({
            url : "/jwsregisterR",
            type : "POST",
            data : frm,
            success : (resp) => {
                if(resp){
                    alert("Successful Registration")
                }else{
                    alert("Registration failed");
                }
            }
        })
    })
}