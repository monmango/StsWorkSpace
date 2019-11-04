package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {

	public mainController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/mainpage.go")
	public String doGet() {
		return "index";
	}
	
	@RequestMapping("/sing.go")
	public String singForm() {
		return "singup";
	}
	
	@RequestMapping("/login.go")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/mypage.go")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("/intro.go")
	public String intro() {
		return "mypage/intro";
	}
		
	@RequestMapping("/mileage.go")
	public String mileage() {
		return "mypage/mileage";
	}
	
	@RequestMapping("/job.go")
	public String job() {
		return "mypage/job";
	}
	
	@RequestMapping("/jobSearch.go")
	public String jobSearch() {
		return "mypage/jobSearch";
	}
	
	@RequestMapping("/product.go")
	public String product() {
		return "mypage/product";
	}
	
	@RequestMapping("/auction.go")
	public String auction() {
		return "mypage/auction";
	}
	
	@RequestMapping("/donation.go")
	public String donation() {
		return "mypage/donation";
	}
	
	@RequestMapping("/mileage_charge.go")
	public String mileage_charge() {
		return "mypage/mileage_charge";
	}
	
	@RequestMapping("/mileage_payment.go")
	public String mileage_payment() {
		return "mypage/mileage_payment";
	}
	
	
	
	
	
	
	
}
