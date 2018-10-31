package io.github.weechang.jutil.re.util;

/**
 * Rest 请求工具
 *
 * @author zhangwei
 * date 2018/7/30
 * time 10:53
 */
public class RestClient {

    private static RestClient util = null;

    public static synchronized RestClient getInstance() {
        if (util == null) {
            util = new RestClient();
        }
        return util;
    }

    
    public void posForObject(String url, Object param, Class clazz){

    }

    public void getForObject(){

    }
}
