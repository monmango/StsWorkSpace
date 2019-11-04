package dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReplyDTO {
	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private String rupload;
	private String ruploadfulename; // board테이블의 다중 파일첨부시 파일 하나씩 분리 처리해주는 멤버변수
	private List<MultipartFile> filename;

	public ReplyDTO() {

	}

	public List<MultipartFile> getFilename() {
		return filename;
	}

	public void setFilename(List<MultipartFile> filename) {
		this.filename = filename;
	}

	public String getRupload() {
		return rupload;
	}

	public void setRupload(String rupload) {
		this.rupload = rupload;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getRuploadfulename() {
		return ruploadfulename;
	}

	public void setRuploadfulename(String ruploadfulename) {
		this.ruploadfulename = ruploadfulename;
	}

}// end class
