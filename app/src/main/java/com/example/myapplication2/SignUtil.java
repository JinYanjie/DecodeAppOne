package com.example.myapplication2;

import java.util.HashMap;

/**
 * author :shengsheng
 * date :2019/9/17
 * i despised my soul when i committed a wrong,and comforted myself that others also commit wrong.
 */
public class SignUtil {
    public static String a(HashMap<String, Object> paramsMap) {
        //获取time值
        String time = String.valueOf(paramsMap.get("time"));
        HashMap<String, Object> np = new HashMap<>();
        np.putAll(paramsMap);
        //移除time 的key和value
        np.remove("time");
        //加密，得到处理过得字符串
        String resultMD5 = Md5Util.a(ParamentEncode.a(np));
        //拼接
        StringBuilder sbAppend = new StringBuilder();
        sbAppend.append(resultMD5);
        sbAppend.append("e2fae2b4e226e878e7f81e4e7e39c9da");
        sbAppend.append(time);
        //再次加密，得到处理后的加密，作为sign
        return Md5Util.a(sbAppend.toString());
    }
}
