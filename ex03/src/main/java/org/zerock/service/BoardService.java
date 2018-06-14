package org.zerock.service;

import java.util.*;

import org.zerock.domain.*;

public interface BoardService {
	public void regist(BoardVO board) throws Exception;
	public BoardVO read(Integer bno) throws Exception;
	public void modify(BoardVO board) throws Exception;
	public void remove(Integer bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	public int listCountCriteria(Criteria cri) throws Exception;
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
