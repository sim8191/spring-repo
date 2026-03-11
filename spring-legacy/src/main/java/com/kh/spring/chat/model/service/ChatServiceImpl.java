package com.kh.spring.chat.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.chat.model.vo.ChatMessage;
import com.kh.spring.chat.model.vo.ChatRoom;
import com.kh.spring.chat.model.vo.ChatRoomJoin;
import com.kh.spring.chat.modle.dao.ChatDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	private final ChatDao chatDao;
	
	@Override
	public List<ChatRoom> selectChatRoomList() {
		// TODO Auto-generated method stub
		return chatDao.selectChatRoomList();
	}

	@Override
	public int openChatRoom(ChatRoom room) {
		// TODO Auto-generated method stub
		return chatDao.openChatRoom(room);
	}

	@Override
	public List<ChatMessage> joinChatRoom(ChatRoomJoin join) {
		// 현채회원이 해당 채팅방에 이미 참여하고 있는지 확인.
		int result = chatDao.joinCheck(join);//참여 중이라면1, 아니라면 0
		if(result == 0) {
			// 참여자 정보를 insert
			
			result = chatDao.joinChatRoom(join);
		}
		
		// insert 성공시 list반환. 실패시 null반환
		List<ChatMessage> list = null;
		if(result > 0) {
			list = chatDao.selectChatMessage(join);
		}
		return list;
	}

	@Override
	public int inertMessage(ChatMessage chatMessage) {
		// TODO Auto-generated method stub
		return chatDao.inertMessage(chatMessage);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void exitChatRoom(ChatMessage message) {
		// TODO Auto-generated method stub
		int result = chatDao.exitChatRoom(message);
		
		if(result == 0) {
			throw new RuntimeException("채팅방 나가기 오류");
		}
		// 마지막으로 나간 경우라면 채팅방 삭제처리
		int cnt = chatDao.countChatRoomMember(message);
		
		if(cnt == 0 ) {
			result = chatDao.closeChatRoom(message);
			if(result == 0) {
				throw new RuntimeException("채팅방 삭제 오류");
			}
		}
	}

}
