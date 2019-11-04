package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardService;

@Controller
public class BoardController {
	private BoardService service;
	private int currentPage;
	private PageDTO pdto;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("/list.sb")
	public ModelAndView listMethod(PageDTO pv, ModelAndView mav) {
		int totalRecord = service.countProcess();
		if(totalRecord >= 1) {
			if(pv.getCurrentPage() == 0) {
				currentPage = 1;
			}else {
				currentPage = pv.getCurrentPage();				
			}
			
			pdto = new PageDTO(currentPage, totalRecord);
			mav.addObject("pv", pdto);
			mav.addObject("aList", service.listProcess(pdto));
		}
		
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping(value= "/write.sb" , method = RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv, BoardDTO dto, ModelAndView mav) {
		
		if(dto.getRef() != 0) { //답변글이면?
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto", dto);
		}
		mav.setViewName("board/write");
		return mav;
	}
	
	@RequestMapping("/view.sb")
	public ModelAndView viewMethod(int currentPage, int num, ModelAndView mav) {
		mav.addObject("dto", service.contentProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/view");
		return mav;
	}
	
	@RequestMapping(value = "/write.sb", method= RequestMethod.POST)
	public String writePromethod(BoardDTO dto, HttpServletRequest request) {
		
		MultipartFile file = dto.getFilename();
		
		String saveDirectory = saveCopyFile(dto, request, file);
		if(!file.isEmpty()) {
			File fe = new File(saveDirectory);
			if(!fe.exists()) 
				fe.mkdir();
		}
		
		//답변글이면
		if(dto.getRef() != 0) {
			service.reStepProcess(dto);
		}else { //제목글이면
			service.insertProcess(dto);
		}
		
		return "redirect:/list.sb";
	}
	
	@RequestMapping(value = "/update.sb", method = RequestMethod.GET)
	public ModelAndView updateMethod(int num, int currentPage, ModelAndView mav) {
		mav.addObject("dto", service.updateSelectProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/update");
		
		return mav;
	}
	
	@RequestMapping(value = "/update.sb", method = RequestMethod.POST)
	public ModelAndView updateProc(BoardDTO dto, int currentPage, ModelAndView mav, HttpServletRequest request) {

		// 기존 첨부파일
		String filename = service.fileSelectprocess(dto.getNum());

		// 수정할 첨부파일
		MultipartFile file = dto.getFilename();
		
		String saveDirectory = saveCopyFile(dto, request, file);
		
		if (!file.isEmpty()) {
			if (filename != null) {
				File fe = new File(saveDirectory, filename);
				fe.delete();
			}
		}
		// 수정한 첨부파일이 있으면
		if (!file.isEmpty()) {
			UUID random = UUID.randomUUID();
			// 기존 첨부파일이 있으면
			if (filename != null) {
				File fe = new File(saveDirectory, filename);
				fe.delete();
			}
		}
		
		service.updateProcess(dto);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/list.sb");
		return mav;
	}
	
	public String saveCopyFile(BoardDTO dto, HttpServletRequest request, MultipartFile file) {
		
		String filenName = file.getOriginalFilename();
		String root = request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root + "temp" + File.separator;
		
		if (!file.isEmpty()) {
			// 중복파일명을 처리하기 위해 난수 발생
			UUID random = UUID.randomUUID();

			File ff = new File(saveDirectory, random + "_" + filenName);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setUpload(random + "_" + filenName);
		}
		dto.setIp(request.getRemoteAddr());
		return saveDirectory;
	}
	
	@RequestMapping("/delete.sb")
	public ModelAndView deleteMethod(int num, int currentPage, ModelAndView mav, HttpServletRequest request) {
		String upload = service.fileSelectprocess(num);
		if(upload != null) {
			String root = request.getSession().getServletContext().getRealPath("/");
			String saveDirectory = root + "temp" + File.separator;
			File fe = new File(saveDirectory, upload);
			fe.delete();
		}
		
		service.deleteProcess(num);
		PageDTO pv = new PageDTO(currentPage, service.countProcess());
		if(pv.getTotalPage() <= currentPage)
			mav.addObject("currentPage", pv.getTotalPage());
		else
			mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/list.sb");
		return mav;
	}
	
	@RequestMapping("/contentdownload.sb")
	public ModelAndView downMethod(int num, ModelAndView mav) {
		mav.addObject("num", num);
		mav.setViewName("download");
		return mav;
	}
	
}
