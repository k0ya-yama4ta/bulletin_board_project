package com.example.bulletin_board.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentForm {
	
	@NotBlank(message="何か書いてね")
	@Size(max=200, message="200字以内で入力してね")
	private String content;

}
