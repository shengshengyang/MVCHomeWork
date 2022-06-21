package vegan.controller;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vegan.model.Post;
import vegan.service.PostService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/posts")
public class PostController {

	
	
	@Autowired
	private PostService postService;

	
	@GetMapping("/newFoodPost")
	public String processMainAction(Model m) {
		
		Post post = new Post();
		m.addAttribute("posts",post);
		return "CreatePost2";
	}
	
	@PostMapping("/PostNew")
	public String createPostImage(@ModelAttribute("posts")Post post,BindingResult result,ModelMap model,HttpServletRequest request) throws IOException {
		
		
		String headUrl = null;
		String headImgFileName = "pimages/PostsPhoto";
		String defaultImgurl = "images/PostsPhoto/defaultPostImage.jpg";
		
		if(result.hasErrors()) {
			return "Createpost2";
		}
		
		MultipartFile picture = post.getPostImage();
		if(picture.getSize() !=0) {
		//byte[] bytes = picture.getBytes();
		String filename = picture.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf('.'));// 副檔名
		System.out.println("副檔名" + suffix);// .jpg
		// 新的檔名
		String newFileName = new Date().getTime() + suffix;
		System.out.println("新檔名" + newFileName);// 1478509873038.jpg
		
		String savePath = request.getSession().getServletContext().getRealPath("/")+headImgFileName;
		//String savePath = "c:/temp/upload";
		System.out.println(savePath);
		File headImage = new File(savePath, newFileName);
	
		
//		if(!headImage.exists()) {
//			headImage.mkdirs();
//		}
		
		//儲存置資料庫路徑
		headUrl = headImgFileName + "/" + newFileName;
		System.out.println(headUrl);
		String path = request.getSession().getServletContext().getRealPath("/")+"src/main/webapp/WEB-F/"+headUrl;
		System.out.println("絕對路徑:"+path);
		picture.transferTo(headImage);
		
		}else {
			headUrl = defaultImgurl;
		}
		
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		Date date = Date.from(zdt.toInstant());
		
		post.setImgurl(headUrl);
		post.setPostedDate(date);
		
	
		postService.addPostImage(post);
		
		
		model.addAttribute("message", "發表成功");
		return "showResultForm";
		
	}
	
	
	@GetMapping(path = "/postIndex" , produces = "text/html; charset=UTF-8")
	public String showAllPost(Model model) {
		List<Post> findallPost = postService.findallPost();
		
		if (findallPost != null) {
			model.addAttribute("postlist",findallPost);
			return "postsIndex";
		}
		return "postsIndex";
	}

	

	@GetMapping(value = "/showPost/{id}")
	public String showPost(@PathVariable("id") int id, Model model) {
		Post post = postService.findPost(id);
		if (post != null) {
			model.addAttribute("post", post);
			return "showPost";
		} else {
			model.addAttribute("message", "失敗");
			return "showResultForm";
		}

	}


	@RequestMapping(value = "/deletePost/{id}")
	public String deletePost(@PathVariable("id") int id, Model model) {

		if (postService.deletePost(id)) {
			model.addAttribute("message", "刪除成功");
			return "showResultForm";
		} else {
			model.addAttribute("message", "刪除失敗");
			return "showResultForm";
		}

	}

	@GetMapping(value = "/editPost/{id}")
	public String editPost(@PathVariable("id")int id,Model model) {

		Post post = postService.findPost(id);
		if (post != null) {
			model.addAttribute("posts", post);
			return "editPost2";
		} else {
			model.addAttribute("message", "錯誤");
			return "showResultForm";
		}

	}
	

	@PostMapping(path = "/editPost/{id}", produces = "text/html ; charset=UTF-8")
	public String UpdatePostImage(@ModelAttribute("posts")Post post,BindingResult result,ModelMap model,@PathVariable("id")int id )
			throws IOException {

		String headUrl = null;
		String headImgFileName = "images/PostsPhoto";
		String defaultImgurl = "images/PostsPhoto/defaultPostImage.jpg";
		
		if(result.hasErrors()) {
			return "Createpost2";
		}
		
		MultipartFile picture = post.getPostImage();
		if(picture.getSize() !=0) {
		//byte[] bytes = picture.getBytes();
		String filename = picture.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf('.'));// 副檔名
		System.out.println("副檔名" + suffix);// .jpg
		// 新的檔名
		String newFileName = new Date().getTime() + suffix;
		System.out.println("新檔名" + newFileName);// 1478509873038.jpg
		
		
		String savePath = "c:/temp/upload";
		System.out.println(savePath);
		File headImage = new File(savePath, newFileName);
		
		//儲存置資料庫路徑
		headUrl = headImgFileName + "/" + newFileName;
		System.out.println(headUrl);
		picture.transferTo(headImage);
		
		}else {
			headUrl = defaultImgurl;
		}
		
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		Date date = Date.from(zdt.toInstant());
		
		post.setImgurl(headUrl);
		//post.setPostedDate(date);
		
		post.setPostId(id);
		boolean updatePost = postService.updatePost(post);

		if (updatePost) {
			model.addAttribute("message", "發表成功");
			return "showResultForm";
		} else {
			model.addAttribute("message", "發表失敗");
			return "showResultForm";
		}
	}

}