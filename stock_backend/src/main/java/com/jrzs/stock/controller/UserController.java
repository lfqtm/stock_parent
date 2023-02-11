package com.jrzs.stock.controller;

import com.jrzs.stock.pojo.StockBlockRtInfo;
import com.jrzs.stock.service.StockService;
import com.jrzs.stock.service.UserService;
import com.jrzs.stock.vo.LoginReqVo;
import com.jrzs.stock.vo.LoginRespVo;
import com.jrzs.stock.vo.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * 用户登录功能实现
	 * @param vo
	 * @return
	 */
	@PostMapping("/login")
	public R<LoginRespVo> login(@RequestBody LoginReqVo vo){
		return this.userService.login(vo);
	}

	/**
	 * 生成验证码
	 *  map结构：
	 *      code： xxx,
	 *      base64：,
	 *      rkey: xxx
	 */
	@GetMapping("/captcha")
	public R<Map> generateCaptcha(){
		try {
			return this.userService.generateCaptcha();
		} catch (IOException e) {
			e.printStackTrace();
			return R.error(e.getMessage());
		}
	}

	@GetMapping("/info/{id}")
	public R<Map<String, String>> getUserInfo(@PathVariable("id") String id) {
		return userService.getInfo(id);
	}

	@GetMapping("/test")
	public R<String> getName(){
		return R.ok("今日指数");
	}
}
