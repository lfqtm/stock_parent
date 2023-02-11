package com.jrzs.stock.service.impl;

import com.google.common.base.Strings;
import com.jrzs.stock.mapper.SysUserMapper;
import com.jrzs.stock.pojo.SysUser;
import com.jrzs.stock.service.UserService;
import com.jrzs.stock.utils.CaptchaImage;
import com.jrzs.stock.utils.IdWorker;
import com.jrzs.stock.vo.LoginReqVo;
import com.jrzs.stock.vo.LoginRespVo;
import com.jrzs.stock.vo.R;
import com.jrzs.stock.vo.ResponseCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private SysUserMapper sysUserMapper;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Resource
	private RedisTemplate redisTemplate;

	@Resource
	private IdWorker idWorker;

	@Resource
	private CaptchaImage captchaImage;

	@Override
	public R<Map<String, String>> getInfo(String id) {
		Map<String, String> vo = new HashMap<>();
		vo.put("roles", "['admin']");
		SysUser sysUser = sysUserMapper.findById(id);
		vo.put("username", sysUser.getRealName());
		return R.ok(vo);
	}

	@Override
	public R<LoginRespVo> login(LoginReqVo vo) {
		if (vo == null || Strings.isNullOrEmpty(vo.getUsername())
			|| Strings.isNullOrEmpty(vo.getPassword()) || Strings.isNullOrEmpty(vo.getRkey())) {
			return R.error(ResponseCode.DATA_ERROR.getMessage());
		}
		//验证码校验
		//获取redis中rkey对应的code验证码
		String rCode = (String) redisTemplate.opsForValue().get(vo.getRkey());
		//校验
		if (Strings.isNullOrEmpty(rCode) || !rCode.equals(vo.getCode())) {
			return R.error(ResponseCode.DATA_ERROR.getMessage());
		}
		//redis清除key
		redisTemplate.delete(vo.getRkey());

		//根据用户名查询用户信息
		SysUser user = this.sysUserMapper.findByUserName(vo.getUsername());
		//判断用户是否存在，存在则密码校验比对
		if (user == null || !passwordEncoder.matches(vo.getPassword(), user.getPassword())) {
			return R.error(ResponseCode.SYSTEM_PASSWORD_ERROR.getMessage());
		}
		//组装登录成功数据
		LoginRespVo respVo = new LoginRespVo();
		BeanUtils.copyProperties(user, respVo);
		respVo.setToken(user.getId());
		return R.ok(respVo);
	}

	/**
	 * 生成验证码
	 * map结构：
	 * code： xxx,
	 * rkey: xxx
	 * @return
	 */
	@Override
	public R<Map> generateCaptcha() throws IOException {
		//1.生成4位数字验证码
		String checkCode = RandomStringUtils.randomNumeric(4);
		//2.获取全局唯一id
		String rkey = String.valueOf(idWorker.nextId());
		//验证码存入redis中，并设置有效期1分钟
		redisTemplate.opsForValue().set(rkey, checkCode, 60, TimeUnit.SECONDS);

		// 3.生成验证码图片
		//将图片转正base64
		BufferedImage image = CaptchaImage.createImage(checkCode);
		//转base64
		BASE64Encoder encoder = new BASE64Encoder();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
		ImageIO.write(image, "png", baos);//写入流中
		byte[] bytes = baos.toByteArray();//转换成字节
		String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
		//删除 \r\n
		png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");

		// 4.组装数据
		HashMap<String, String> map = new HashMap<>();
		map.put("base64", "data:image/png;base64," + png_base64);
		map.put("rkey", rkey);
		map.put("code", checkCode);
		return R.ok(map);
	}
}
