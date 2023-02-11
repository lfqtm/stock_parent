package com.jrzs.stock.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;

class CaptchaImageTest {

	@Autowired
	private CaptchaImage captchaImage;

	@Test
	void testCreate() throws IOException {
		BufferedImage image = captchaImage.createImage("2344");
		OutputStream os = new FileOutputStream("D:/1.png");
		ImageIO.write(image, "png", os);
		os.close();

	}
}
