$(function(){
    list();
});


function list(){
    $.ajax({                          //ajax라는 함수를 실행 시킨다 라고 생각하면된다, //서버랑 통신하기 위한 코드
        url : "/list",                //서버에 list를 호출한다
        type : "GET",
        data : {'findStr' : findStr},
        success : (resp)=>{           //요청과 응답이 success(성공) 했을때 어떤 값을 넣어줄것인가
            let temp = $(resp).find(".change");
            $('.change').html(temp);
            search();
        }   
    });
}

function search(){
    let btnSearch = document.querySelector(".btnSearch");

    btnSearch.addEventListener('click', ()=>{ //검색어를 집어넣고 검색을 했을때
        findStr = $(".findStr").val();
        sessionStorage.setItem("findStr", findStr); //findStr은 사용자 검색어 

        $.ajax({
            url  : "/list",
            type : "GET",
            data : {"findStr" : findStr},
            success : (resp)=>{
                let temp = $(resp).find(".item");
                $(".items").html(temp);
            }
        }
    )}
)}
