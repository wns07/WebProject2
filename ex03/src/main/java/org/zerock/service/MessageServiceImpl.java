package org.zerock.service;

import javax.inject.*;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.zerock.domain.*;
import org.zerock.persistence.*;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	private MessageDAO messageDAO;
	
	@Inject
	private PointDAO pointDAO;

	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		messageDAO.create(vo);
		pointDAO.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {
		messageDAO.updateState(mno);
		pointDAO.updatePoint(uid, 5);
		return null;
	}
	
}
