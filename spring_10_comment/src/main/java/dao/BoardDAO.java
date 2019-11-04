package dao;

import java.util.List;

import dto.BoardDTO;
import dto.ReplyDTO;

public interface BoardDAO {
	
	public List<BoardDTO> boardListMethod();
	public BoardDTO boardViewMethod(int bno);
	public void replyInsrtMethod(ReplyDTO rdto);
	public List<ReplyDTO> replyListMethod(int bno);
	public void replyDeleteMethod(int bno);
	public void replyUpdateMethod(ReplyDTO rdto);
	

}
