package vegan.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "post")
@Component
public class Post {


	//private static final long serialVersionUID = 1L;
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer postId;
	  	@Column(columnDefinition = "nvarchar(255)")
	    private String title;
	    @Column(columnDefinition = "datetime")
	    private Date postedDate;
	    @Column(columnDefinition = "nvarchar(MAX)")
	    private String postedText;
	    @Column(columnDefinition = "nvarchar(255)")
	    private String imgurl;
	    
	    @Transient
		MultipartFile postImage;
	    
	    
	    

		public Post() {
	    	
	    }
	    
	    public Post(Integer postId,String title,Date postedDate,String postedText,String imgurl) {
	    	
	    	this.postId =postId;
	    	this.title = title;
	    	this.postedDate = postedDate;
	    	this.postedText = postedText;
	    	this.imgurl = imgurl;
	    	
	    }
	    
		public Post(Integer postId, String title, String postedText) {
			this.postId =postId;
	    	this.title = title;
	    	this.postedText = postedText;
		}
		
		public Post(Integer postId, String title, String postedText, String imgurl) {
			this.postId =postId;
	    	this.title = title;
	    	this.postedText = postedText;
	    	this.imgurl = imgurl;
		}
		
		
		public Post(Integer postId) {
			this.postId =postId;
		}

		public Post(String title,Date postedDate,String postedText,String imgurl) {
	    	
	    	
	    	this.title = title;
	    	this.postedDate = postedDate;
	    	this.postedText = postedText;
	    	this.imgurl = imgurl;
	    	
	    }

		



		public Integer getPostId() {
			return postId;
		}
		public void setPostId(Integer postId) {
			this.postId = postId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Date getPostedDate() {
			return postedDate;
		}
		public void setPostedDate(Date postedDate) {
			this.postedDate = postedDate;
		}
		public String getPostedText() {
			return postedText;
		}
		public void setPostedText(String postedText) {
			this.postedText = postedText;
		}
		public String getImgurl() {
			return imgurl;
		}
		public void setImgurl(String imgurl) {
			this.imgurl = imgurl;
		}
	    
		public MultipartFile getPostImage() {
			return postImage;
		}

		public void setPostImage(MultipartFile postImage) {
			this.postImage = postImage;
		}
	    
	    
	    
	    
}
