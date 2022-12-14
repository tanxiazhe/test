package com.test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩处理
 * 
 * @author 崔素强
 */
@SuppressWarnings("restriction")
public class ImgCompress {
    private final Image img;
    private final int width;
    private final int height;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        System.out.println("开始：" + new Date().toLocaleString());
        ImgCompress imgCom = new ImgCompress("C:\\Users\\\\Downloads\\XXLARGE.png");
        imgCom.resizeFix(960, 960);
        System.out.println("结束：" + new Date().toLocaleString());
    }

    /**
     * 构造函数
     */
    public ImgCompress(String fileName) throws IOException {
        File file = new File(fileName);// 读入文件
        img = ImageIO.read(file);      // 构造Image对象
        width = img.getWidth(null);    // 得到源图宽
        height = img.getHeight(null);  // 得到源图长
    }

    /**
     * 按照宽度还是高度进行压缩
     * 
     * @param w
     *            int 最大宽度
     * @param h
     *            int 最大高度
     */
    public void resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            resizeByWidth(w);
        } else {
            resizeByHeight(h);
        }
    }

    /**
     * 以宽度为基准，等比例放缩图片
     * 
     * @param w
     *            int 新宽度
     */
    public void resizeByWidth(int w) throws IOException {
        // System.out.println("resize by width");
        int h = height * w / width;
        resize(w, h);
    }

    /**
     * 以高度为基准，等比例缩放图片
     * 
     * @param h
     *            int 新高度
     */
    public void resizeByHeight(int h) throws IOException {
        // System.out.println("resize by height");
        int w = width * h / height;
        resize(w, h);
    }

    /**
     * 强制压缩/放大图片到固定的大小
     * 
     * @param w
     *            int 新宽度
     * @param h
     *            int 新高度
     */
    public void resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        // image.getGraphics().drawImage(img.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, null); // 绘制缩小后的图

        JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(image);
        /* 压缩质量 */
        jep.setQuality(1, true);

        File destFile = new File("C:\\Users\\\\Downloads\\test111.png");
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

        // encoder.encode(image); // JPEG编码
        encoder.encode(image, jep);

        out.close();

        // JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bufferedThumbnail);
        // jep.setQuality(1, true);
        // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bout);
        // encoder.encode(bufferedThumbnail, jep);

    }
}