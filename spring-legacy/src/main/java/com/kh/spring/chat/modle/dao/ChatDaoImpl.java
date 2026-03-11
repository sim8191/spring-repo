package com.kh.spring.chat.modle.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.chat.model.vo.ChatMessage;
import com.kh.spring.chat.model.vo.ChatRoom;
import com.kh.spring.chat.model.vo.ChatRoomJoin;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ChatDaoImpl implements ChatDao {
	private final SqlSessionTemplate session;
	
	@Override
	public List<ChatRoom> selectChatRoomList() {
		// TODO Auto-generated method stub
		return session.selectList("chat.selectChatRoomList");
	}

	@Override
	public int openChatRoom(ChatRoom room) {
		// TODO Auto-generated method stub
		return session.insert("chat.openChatRoom", room);
	}

	@Override
	public int joinCheck(ChatRoomJoin join) {
		// TODO Auto-generated method stub
		return session.selectOne("chat.joinCheck",join);
	}

	@Override
	public int joinChatRoom(ChatRoomJoin join) {
		// TODO Auto-generated method stub
		return session.insert("chat.joinChatRoom",join);
	}

	@Override
	public List<ChatMessage> selectChatMessage(ChatRoomJoin join) {
		// TODO Auto-generated method stub
		return session.selectList("chat.selectChatMessage",join);
	}

	@Override
	public int inertMessage(ChatMessage chatMessage) {
		// TODO Auto-generated method stub
		return session.insert("chat.inertMessage",chatMessage);
	}

	@Override
	public int exitChatRoom(ChatMessage message) {
		// TODO Auto-generated method stub
		return session.delete("chat.exitChatRoom",message);
	}

	@Override
	public int countChatRoomMember(ChatMessage message) {
		// TODO Auto-generated method stub
		return session.selectOne("chat.countChatRoomMember", message);
	}

	@Override
	public int closeChatRoom(ChatMessage message) {
		// TODO Auto-generated method stub
		return session.update("closeChatRoom",message);
	}
	
}
