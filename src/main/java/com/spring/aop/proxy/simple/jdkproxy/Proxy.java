package com.spring.aop.proxy.simple.jdkproxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {
    /**
     * 
     * @param infce
     *            被代理类的接口
     * @param h
     *            代理类
     * @return
     * @throws Exception
     */
    public static Object newProxyInstance(Class<?> infce, InvocationHandler h) throws Exception {
        String methodStr = "";
        String rt = "\r\n";

        // 利用反射得到infce的所有方法，并重新组装
        Method[] methods = infce.getMethods();
        for (Method m : methods) {
            methodStr += rt + "    @Override" + rt + "    public  " + m.getReturnType() + " " + m.getName() + "() {"
                    + rt + "        try {" + rt + "               Method md = " + infce.getName()
                    + ".class.getMethod(\"" + m.getName() + "\");" + rt + "               h.invoke(this, md);" + rt
                    + "        }catch(Exception e) {" + rt + "             e.printStackTrace();" + rt + "        }" + rt
                    + "    }" + rt;
        }

        String className = infce.getName();
        className = "$Proxy" + className.substring(className.lastIndexOf(".") + 1);

        // 生成Java源文件
        String srcCode = "package com.tgb.jdkproxy;" + rt + "import java.lang.reflect.Method;" + rt + rt + "public class "
                + className + " implements " + infce.getName() + "{" + rt + rt
                + "    InvocationHandler h;" + rt + rt + "    public " + className
                + "(InvocationHandler h) {" + rt + "        this.h = h;" + rt + "    }" + rt + methodStr + rt + "}";

        String fileName = "C:\\Users\\\\workspace_employee\\test\\src\\main\\java\\com\\tgb\\jdkproxy\\" + className
                + ".java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(srcCode);
        fw.flush();
        fw.close();

        // 将Java文件编译成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> units = fileMgr.getJavaFileObjects(fileName);
        CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        // 加载到内存，并实例化
        URL[] urls = new URL[] {
                new URL("file:\\" + "C:\\Users\\\\workspace_employee\\test\\src\\main\\java\\") };
        @SuppressWarnings("resource")
        URLClassLoader ul = new URLClassLoader(urls);
        Class<?> c = ul.loadClass("com.tgb.jdkproxy." + className);

        Constructor<?> ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(h);

        return m;
    }

}