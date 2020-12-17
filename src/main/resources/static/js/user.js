let index = {
    init: function () {
        $("#btn-save").on("click", () => { //function(){},  ()=>{} this를 바인딩 하기위해 쓰는거
            this.save();
        });
    },


    save: function () {
        // alert('userdml save함수 호출됨');
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()

        };
        // console.log(data);

        //ajax호출시 dfault가 비동기 호출
        //아작스통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
        $.ajax({ //회원가입 수행 요청
            type:"POST", //메서드방식을 포스트로
            url:"/blog/api/user", //어느주소로 호출할거야?
            data:JSON.stringify(data), //그냥 위에 자바스크립트에 오브젝트 data 쓰면 인식을못해서 JOSN 문자열로 데이터 날려줘야함 //http body 데이터
            contentType:"application/json; charset=utf-8", //body 데이터가 어떤타입인지(MIME)
            dataType:"json" // 응답이 왔을때 기본적으로 모든것이 String(문자열), 생긴게 json이라면 javascript오브젝트로 변경해줌
        }).done(function(resp){ //정상이면 돈 실행, dataType json으로 응답을 해줌
        alert("회원가입이 완료가 되었습니다.");
        console.log(resp);
        // location.href= "/blog";
        }).fail(function(error){ //실패하면 fail 로 실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청


    }
}
index.init();