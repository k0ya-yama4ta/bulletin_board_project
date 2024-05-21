package com.example.bulletin_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bulletin_board.entity.Comment;
import com.example.bulletin_board.repository.CommentRepository;
import com.example.bulletin_board.service.UserRegistrationService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Autowired
	CommentRepository cr;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("コマンドラインランナー実行開始");
		
		userRegistrationService.adminRegistration("admin","管理者","password");
		userRegistrationService.userRegistration("test", "テスト", "password");
		
		Comment c1 = new Comment("admin", "管理者です。テストテスト");
		cr.save(c1);


		System.out.println("コマンドラインランナー実行終了");
	}

}