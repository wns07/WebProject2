package org.zerock.persistence;

import javax.inject.*;

import org.apache.ibatis.session.*;
import org.springframework.stereotype.*;
import org.zerock.domain.*;

@Repository
public class MessageDAOImpl implements MessageDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.MessageMapper";

	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mid) throws Exception {
		return session.selectOne(namespace + ".readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace + ".updateState", mid);
	}

}
