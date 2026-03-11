//여기 처리속도가 느리기 때문에 작업후 강력 새로고침 꼭하기(새로고침 우클릭하면 나옴)

// iife즉시실행함수
(
    function(){
        const display = document.querySelector(".display-chatting");
        display.scrollTop = display.scrollHeight;
    }
)();

//1. 채팅 메세지 보내기 긴증
document.getElementById("send")
.addEventListener("click", sendMessae);

function sendMessae(){
    var input = document.getElementById("inputChatting");

    if(input.value.trim().length == 0){
        alert("1글자 이상 입력하세요");
        input.value = "";
        input.focus();
        return;
    }

    var chatMessage = {
        message : input.value,
        chatRoomNo,
        userNo,
        userName

    }

    var json = JSON.stringify(chatMessage); // 제이슨 형태로 보낸다 chat메시지를
    chattingSocket.send(json);

    input.value = "";
    
}
// 서버에서 전달하는 메세지를 처리하는 이벤트 핸들러
chattingSocket.onmessage = function(e){
    // 서버에서 전달한 json데이터를 js로 파싱
    const chatMessage = JSON.parse(e.data);//parse로 JSON을 자바스크립트로 변환

    const li = document.createElement("li");
    const p = document.createElement("p");
    p.classList.add("chat");

    p.innerHTML = chatMessage.message;
    const span = document.createElement("span");
    span.classList.add("chatDate");
    span.innerText = chatMessage.createDate;

    // 메시지를 보낸 주체가 누구인지를 불류
    if(chatMessage.userNo == userNo){// 메시지보낸사람 이 나라면
        li.classList.add("myChat");
        li.append(span,p);
    }else{// 메시지보낸사람 다른사람이랴면
        // el표현식
        li.innerHTML = `<b>${chatMessage.userName}</b>`
        li.append(p, span);
    }

    const display = document.querySelector(".display-chatting");
    display.append(li); // 다못씀

    display.scrollTop = display.scrollHeight;


}
