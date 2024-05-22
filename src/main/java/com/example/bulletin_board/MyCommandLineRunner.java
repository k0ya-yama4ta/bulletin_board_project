package com.example.bulletin_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bulletin_board.service.CommentService;
import com.example.bulletin_board.service.UserRegistrationService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Autowired
	private CommentService commentService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("コマンドラインランナー実行開始");
		
		// テスト用サンプル
//		userRegistrationService.adminRegistration("admin","管理者","password");
//		userRegistrationService.userRegistration("test", "テスト", "password");
//		userRegistrationService.userRegistration("Alice123", "AliceWonder", "password");
//		userRegistrationService.userRegistration("Bob789", "BobMarley", "password");
//		userRegistrationService.userRegistration("CB456", "CharlieBrown", "password");
//		userRegistrationService.userRegistration("David987", "DavidJohnson", "password");
//		userRegistrationService.userRegistration("EVE321", "EveSmith", "password");
		
//		commentService.addComment("admin", "管理者です。テストテスト");
//		commentService.addComment("Alice123", "好奇心旺盛なアリスだよ！探求心を持ち、新たな発見を楽しみにしているの！");
//		commentService.addComment("Bob789", "リズムにのって楽しんでいるボブです。人生のリズムに合わせて、笑顔で歩んでいます。");
//		commentService.addComment("CB456", "ユーモアを大切にするチャーリーです。人生の波に乗りながら、笑いと明るさを提供しています。");
//		commentService.addComment("David987", "夢を追いかけるデイビッドと申します。自分の道を切り拓き、夢を叶えるために努力しています。");
//		commentService.addComment("EVE321", "星空を見上げながら、宇宙の美しさに触れるイブです。自然との共鳴を大切にしています。");
		


		System.out.println("コマンドラインランナー実行終了");
	}

}