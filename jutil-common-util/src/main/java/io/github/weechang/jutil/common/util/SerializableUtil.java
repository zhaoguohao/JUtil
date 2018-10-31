package io.github.weechang.jutil.common.util;

import java.io.*;
import java.util.Base64;

/**
 * 序列化工具类
 *
 * @author zhangwei
 * date 2018/10/31
 * time 18:21
 */
public class SerializableUtil {

    /**
     * 对象序列化为base64字符串
     *
     * @param source 待序列化对象
     * @return 序列化结果
     * @throws IOException exception
     */
    public static String serialize(Object source) throws IOException {
        //ByteArrayOutputStream 用于存储序列化的Objecte对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //将Object对象输出成byte数据
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(source);
        //将字节码，编码成String类型数据
        return Base64.getEncoder().encodeToString(bos.toByteArray());
    }


    /**
     * base64字符串反序列化为对象
     *
     * @param source 反序列化字符串
     * @return 序列化结果
     * @throws IOException            异常
     * @throws ClassNotFoundException 异常
     */
    public static Object deserialize(String source) throws IOException, ClassNotFoundException {
        //读取字节码表
        ByteArrayInputStream bis = new ByteArrayInputStream(Base64.getDecoder().decode(source));
        //将字节码反序列化成 对象
        ObjectInputStream in = new ObjectInputStream(bis);
        Object target = in.readObject();
        return target;
    }
}
