package com.kh.spring.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.memberDao;
import com.kh.spring.member.model.vo.Member;
import com.kh.spring.security.model.vo.MemberExt;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private memberDao memberDao;
	
	@Override
	public Member loginMember(Member m) {
		// TODO Auto-generated method stub
		return memberDao.loginMember(m); 
	}

	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		int result = memberDao.insertMember(m);
		memberDao.insertAurthority(m);
		// 놓침
//		
		return result;
	}

	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return memberDao.idCheck(userId);
	}

	@Override
	public Member selectOne(String userId) {
		// TODO Auto-generated method stub
		return memberDao.selectOne(userId);
	}

	@Override
	public int updateMember(MemberExt loginUser) {
		return memberDao.updateMember(loginUser);
	}
	
	
}
