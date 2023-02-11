package com.jrzs.stock.service;

import com.jrzs.stock.vo.LoginReqVo;
import com.jrzs.stock.vo.LoginRespVo;
import com.jrzs.stock.vo.R;

import java.io.IOException;
import java.util.Map;

public interface UserService {

	/**
	 * 获取用户详情
	 * @return
	 */
	R<Map<String, String>> getInfo(String id);

	/**
	 * 用户登录功能实现
	 * @param vo
	 * @return
	 */
	R<LoginRespVo> login(LoginReqVo vo);

	/**
	 * 生成验证码
	 *  map结构：
	 *      code： xxx,
	 *      rkey: xxx
	 * @return
	 */
	R<Map> generateCaptcha() throws IOException;
}
