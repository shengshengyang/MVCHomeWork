package vegan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="forum") 
@Component
public class Forum {
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer forumid;
		@Column(name = "forumTitle")
		private String forumTitle;
		@Column(name = "forumContent")
		private String forumContent;
		@Column(name = "forumDate")
		private String forumDate;
		
		public Forum() {}
		
		public Forum(Integer forumid, String forumTitle, String forumContent, String forumDate) {
			super();
			this.forumid = forumid;
			this.forumTitle = forumTitle;
			this.forumContent = forumContent;
			this.forumDate = forumDate;
		}

		public Integer getForumid() {
			return forumid;
		}

		public void setForumid(Integer forumid) {
			this.forumid = forumid;
		}

		public String getForumTitle() {
			return forumTitle;
		}

		public void setForumTitle(String forumTitle) {
			this.forumTitle = forumTitle;
		}

		public String getForumContent() {
			return forumContent;
		}

		public void setForumContent(String forumContent) {
			this.forumContent = forumContent;
		}

		public String getForumDate() {
			return forumDate;
		}

		public void setForumDate(String forumDate) {
			this.forumDate = forumDate;
		}
		
		
}
