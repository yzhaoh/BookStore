package com.bs.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * 验证码
 * 
 * @author 若水
 *
 */
public class ValidateCode {
	private static final int WIDTH = 90;
	private static final int HEIGHT = 43;
	private static final int LINESIZE = 24;
	private static final int FONTSIZE = 4;
	private static final String CODE = "01234567890123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random random = new Random();
	private String text = "";

	/**
	 * 返回验证码文本
	 * 
	 * @return 验证码文本
	 */
	public String getCode() {
		text = "";
		String ch = "";
		for (int j = 1; j <= FONTSIZE; j++) {
			ch = String.valueOf(CODE.charAt(random.nextInt(CODE.length())));
			text = text + ch;
		}
		return text;
	}

	/**
	 * 返回验证码图片
	 * 
	 * @return 验证码图片
	 */
	public BufferedImage getImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255)));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255)));
		g.setFont(new Font("楷体", Font.ROMAN_BASELINE, 28));
		for (int i = 0; i <= LINESIZE; i++) {
			g.drawLine(random.nextInt(66), random.nextInt(66),
					random.nextInt(66), random.nextInt(66));
		}
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255)));
		g.drawString(text, 8, 34);
		g.dispose();
		return image;
	}

	/**
	 * 将BufferedImage转换成ByteArrayInputStream
	 * 
	 * @param image
	 *            图片
	 * @return ByteArrayInputStream 流
	 */
	public ByteArrayInputStream convertImageToStream(BufferedImage image) {
		ByteArrayInputStream inputSteam = null;
		ByteArrayOutputStream outputSteam = new ByteArrayOutputStream();
		try {
			ImageOutputStream imageOutputSteam = ImageIO
					.createImageOutputStream(outputSteam);
			ImageIO.write(image, "JPEG", imageOutputSteam);
			imageOutputSteam.close();
			inputSteam = new ByteArrayInputStream(outputSteam.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputSteam;
	}
}
