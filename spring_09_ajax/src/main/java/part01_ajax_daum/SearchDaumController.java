package part01_ajax_daum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SearchDaumController {

	public SearchDaumController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/daumForm.do")
	public String form() {
		return "part01_ajax_daum/daumForm";
	}
	
	@RequestMapping(value = "/searchOpen.do")
	public @ResponseBody String process(String search) throws IOException {
		String input = "";
		String total="";
		String url="https://dapi.kakao.com/v3/search/book?target=title";
		url += "&query="+URLEncoder.encode(search, "UTF-8");
		URL ur12 = new URL(url);
		URLConnection conn = ur12.openConnection();
		HttpURLConnection urlConn = (HttpURLConnection)conn;
		urlConn.setRequestMethod("GET");
		urlConn.setRequestProperty("Authorization", "KakaoAK 668ae8de05368d7851f65f24b0c0723d");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		while((input = reader.readLine())!= null) {
			total+= input;
		}
		System.out.println(total);
		return total;
	}//end process()
	
	
	
	
	
	
}//end class
