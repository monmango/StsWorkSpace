package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.ReplyDTO;
import service.BoardService;

@Controller
public class BoardController {

	private BoardService service;
	private String path;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@RequestMapping("/boardList.do")
	public ModelAndView boardListPage(ModelAndView mav) {
		mav.addObject("list", service.boardListProcess());
		mav.setViewName("boardList");
		return mav;
	}//end
	@RequestMapping("/boardView.do")
	public ModelAndView boardViewPage(int bno,ModelAndView mav) {
		mav.addObject("boardDTO" , service.boardViewProcess(bno));
		//mav.setViewName("boardView");
		mav.setViewName("boardView3");
		return mav;
	}
		
	
	@RequestMapping("/replyInsertList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto,  HttpServletRequest request ){
		//json타입으로 돌려줘야할 때 사용하는 어노테이션
		//System.out.println(rdto.getReplytext());
		//System.out.println(rdto.getFilename());		
		MultipartFile file = rdto.getFilename();
		
		if(file != null) {
			String filename = file.getOriginalFilename();
			UUID random = UUID.randomUUID();
			String root = request.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp"+File.separator;
			File fe = new File(saveDirectory);
			if(!fe.exists()) {
				fe.mkdir();
			}
			File ff = new File(saveDirectory , random+"_"+filename);
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rdto.setRupload(random+"_"+filename);
		}
		
		return service.replyListProcess(rdto);
	}

	@RequestMapping("/replyDelete.do")
	public @ResponseBody List<ReplyDTO> replyDeletePage(ReplyDTO rdto){
		return service.replyDeleteProcess(rdto);
	}
	@RequestMapping("/replyUpdate.do")
	public @ResponseBody List<ReplyDTO> replyUpdatePage(ReplyDTO rdto){
		return service.replyUpdateProcess(rdto);
		
	}
	
	
	public void saveCopyFile(String saveDirectory , UUID random , String fileName , MultipartFile file) {
		File ff  = new File(saveDirectory , random+"_"+fileName);
		
		try {
			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
	}
	
	
	
	
	
	
}//end class
