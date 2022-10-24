package com.test;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {

    private Configuration cfg = null;
    private final static StringWriter out = new StringWriter();

    public static void main(String[] args) throws Exception {
        FreeMarkerTest maker = new FreeMarkerTest();
        maker.init();
        maker.process();
        System.out.println(out.toString());
    }

    // 初始化工作
    public void init() throws Exception {
        cfg = new Configuration();
        // 设置模板文件位置
        cfg.setDirectoryForTemplateLoading(new File("src/main/java/com/test/"));
    }

    // 模板 + 数据模型 = 输出
    public void process() throws Exception {
        // 创建数据模型
        Map<String, String> rootMap = new HashMap<String, String>();
        rootMap.put("name", "FreeMarker");
        rootMap.put("message", "FreeMarker For Java Project");

        // 使用Configuration实例加载指定模板
        Template template = cfg.getTemplate("freemarkerTemplateUser.ftl");
        // 合并处理（模板 + 数据模型）
        // template.process(rootMap, new OutputStreamWriter(System.out));
        template.process(rootMap, out);

    }
}