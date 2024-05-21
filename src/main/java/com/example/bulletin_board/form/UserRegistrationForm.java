package com.example.bulletin_board.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationForm {
	
	@NotBlank(message="値が入力されていないよ")
	@Size(min=4, max=20, message="4字から20字で入力してね")
	private String userid;
	
	@NotBlank(message="値が入力されていないよ")
	@Size(min=4, max=20, message="4字から20字で入力してね")
	private String username;
	
	@NotBlank(message="値が入力されていないよ")
	@Size(min=8, max=20, message="8字から20字で入力してね")
	private String password;
	
	@NotBlank(message="値が入力されていないよ")
	@Size(min=8, max=20, message="8字から20字で入力してね")
	private String confirmPassword;
	
	@AssertTrue(message="パスワードが一致しないよ")
	public boolean isPasswordValid() {
		if(password == null || confirmPassword == null) {
			return false;
		}
		return password.equals(confirmPassword);
	}

}
