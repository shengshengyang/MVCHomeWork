package vegan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	
	@NotBlank(message ="*請輸入email")
	@Email(message = "*請確認email格式")
	@Size(max=50, message="*不可超出50個字節")
	private String email;

	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message="*至少包含1個大、小寫字母和數字,僅能為英數字且字節介於8~20個")
	private String password;
	
	@NotBlank(message ="*請輸入使用者名稱")
	@Size(max=20, message="*不可超出20個字節")
	private String username;
	
	public User() {}
	
	public User(Integer uid,String email,String password,String username) {
		this.uid = uid;
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", password=" + password + ", username=" + username + "]";
	}
	
}
