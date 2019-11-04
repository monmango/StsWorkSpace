package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardServiceImp implements BoardService{
	
	private BoardDAO dao;
	
	public BoardServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<BoardDTO> boardListProcess() {
		return dao.boardListMethod();
		
		
	}


	@Override
	public BoardDTO boardViewProcess(int bno) {
		return dao.boardViewMethod(bno);
	}


	@Override
	public List<ReplyDTO> replyListProcess(ReplyDTO rdto) {
		dao.replyInsrtMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	}


	@Override
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto) {
		dao.replyDeleteMethod(rdto.getRno());
		return dao.replyListMethod(rdto.getBno());
	}


	@Override
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto) {
		dao.replyUpdateMethod(rdto);
		return dao.replyListMethod(rdto.getBno());
	}
	
	
	

}
