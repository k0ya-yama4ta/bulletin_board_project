package com.example.bulletin_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bulletin_board.entity.Comment;
import com.example.bulletin_board.entity.User;
import com.example.bulletin_board.form.CommentForm;
import com.example.bulletin_board.form.DeleteCommentForm;
import com.example.bulletin_board.form.UserRegistrationForm;
import com.example.bulletin_board.service.CommentService;
import com.example.bulletin_board.service.UserRegistrationService;
import com.example.bulletin_board.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MyController {

	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserRegistrationService userRegistrationService;

	@Autowired
	private HttpSession httpSession;

	@GetMapping("/")
	public String getRoot() {
		return "redirect:/board";
	}

	/**
	 * ログイン
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	/**
	 * ログアウト処理
	 * 
	 * @return
	 */
	@PostMapping("/logout")
	public String postLogout() {
		return "logout";
	}

	/**
	 * 新規登録
	 * 
	 * @param form
	 * @return
	 */
	@GetMapping("/user/registration")
	public String getUserRegistration(@ModelAttribute("form") UserRegistrationForm form) {
		return "user-registration";
	}

	/**
	 * 新規登録処理
	 * 
	 * @param form
	 * @param result
	 * @return
	 */
	@PostMapping("/user/registration")
	public String postUserRegistration(@Valid @ModelAttribute("form") UserRegistrationForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "user-registration";
		}
		userRegistrationService.userRegistration(form.getUserid(), form.getUsername(), form.getPassword());
		return "redirect:/login";
	}

	/**
	 * 掲示板
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/board")
	public String getBoard(
			@PageableDefault(page=0, size=10) Pageable pageable,
			Model model) {
		User loginUser = (User) httpSession.getAttribute("user");
		model.addAttribute("loginUser", loginUser);
		
		Page<Comment> commentPage = commentService.getPageComment(pageable);
		List<Comment> comments = commentPage.getContent();
		model.addAttribute("page", commentPage);
		model.addAttribute("comments", comments);
		return "board";
	}

	/**
	 * コメント追加処理
	 * 
	 * @param form
	 * @param result
	 * @return
	 */
	@PostMapping("/comment")
	public String postComment(@Valid @ModelAttribute("form") CommentForm form, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "redirect:/board";
		}
		User loginUser = (User) httpSession.getAttribute("user");
		commentService.addComment(loginUser.getUserid(), form.getContent());
		return "redirect:/board";
	}
	/**
	 * コメント削除処理
	 * @param form
	 * @return
	 */
	@PostMapping("/deleteComment")
	public String postDeleteComment(@ModelAttribute("form") DeleteCommentForm form) {
		commentService.deleteComment(form.getId());
		System.out.println(form.getId());
		return "redirect:/management/comment";
	}

	/**
	 * 管理者用ページ
	 * @param model
	 * @return
	 */
	@GetMapping("/management/user")
	public String getManagementUser(
			@PageableDefault(page=0, size=10) Pageable pageable,
			Model model) {
		User loginUser = (User) httpSession.getAttribute("user");
		model.addAttribute("loginUser", loginUser);
		
		Page<User> userPage = userService.getPageUser(pageable);
		List<User> users = userPage.getContent();
		model.addAttribute("page", userPage);
		model.addAttribute("users", users);

		return "management-user";
	}
	@GetMapping("/management/comment")
	public String getManagementComment(
			@RequestParam(name="userid", required=false, defaultValue="") String userid,
			@PageableDefault(page=0, size=10) Pageable pageable,
			Model model) {
		User loginUser = (User) httpSession.getAttribute("user");
		model.addAttribute("loginUser", loginUser);
		
		Page<Comment> commentPage = userid.equals("") ? commentService.getPageComment(pageable) : commentService.getUseridPageComment(userid, pageable);
		List<Comment> comments = commentPage.getContent();
		model.addAttribute("userid", userid);
		model.addAttribute("page", commentPage);
		model.addAttribute("comments", comments);

		return "management-comment";
	}

	/**
	 * ユーザが権限のないページにアクセスしたときようのページ
	 * @return
	 */
	@GetMapping("/accessDenied")
	public String getAccessDenied(Model model) {
		User loginUser = (User) httpSession.getAttribute("user");
		model.addAttribute("loginUser", loginUser);
		return "accessDenied";
	}

}
