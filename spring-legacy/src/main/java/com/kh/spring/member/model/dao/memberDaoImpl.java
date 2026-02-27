package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class memberDaoImpl implements memberDao{

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public Member loginMember(Member m) {
		// TODO Auto-generated method stub
		return session.selectOne("member.loginMember", m);
	}

	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		return session.insert("member.insertMember", m);
	}

	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.idCheck", userId);
	}

	@Override
	public Member selectOne(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectOne", userId);
	}
	
}
