package com.example.myapplication2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author :shengsheng
 * date :2019/9/17
 * i despised my soul when i committed a wrong,and comforted myself that others also commit wrong.
 *
 * 这个类作用就是 按照key排序后，对字符串拼接，如果有特殊字符，就进行替换，这个类可自己实现
 */
public class ParamentEncode {
    public static String a(HashMap<String, Object> parament) {
        StringBuffer sb = new StringBuffer();
        Object[] keys = parament.keySet().toArray();
        Arrays.sort(keys);
        for (Object key : keys) {
            List<List<String>> ls = a(String.valueOf(key), parament.get(key));
            List<String> keyList = (List) ls.get(0);
            List<String> valueList = (List) ls.get(1);
            for (int i = 0; i < keyList.size(); i++) {
                String k = (String) keyList.get(i);
                String v = (String) valueList.get(i);
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(k);
                sb.append("=");
                sb.append(v);
            }
        }
        return sb.toString();
    }

    public static List<List<String>> a(String key, Object value) {
        List<List<String>> kvs = new ArrayList<>();
        List<String> keyList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        if (value instanceof List) {
            for (Object a : (List) value) {
                List<List<String>> ls = a(key + "[]", a);
                keyList.addAll((Collection) ls.get(0));
                valueList.addAll((Collection) ls.get(1));
            }
            kvs.add(keyList);
            kvs.add(valueList);
        } else if (value instanceof Object[]) {
            for (Object a2 : (Object[]) value) {
                List<List<String>> ls2 = a(key + "[]", a2);
                keyList.addAll((Collection) ls2.get(0));
                valueList.addAll((Collection) ls2.get(1));
            }
            kvs.add(keyList);
            kvs.add(valueList);
        } else if (value instanceof Map) {
            Map s = (Map) value;
            Object[] keys = s.keySet().toArray();
            Arrays.sort(keys);
            for (Object k : keys) {
                List<List<String>> ls3 = a(String.valueOf(k), s.get(key));
                keyList.addAll((Collection) ls3.get(0));
                valueList.addAll((Collection) ls3.get(1));
            }
            kvs.add(keyList);
            kvs.add(valueList);
        }else {
            keyList.add(a(key));
            valueList.add(a(String.valueOf(value)));
            kvs.add(keyList);
            kvs.add(valueList);
        }
        return kvs;
    }

    public static String a(String s) {
        if (s == null) {
            return "";
        }
        try {
            //替换方式
            return URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException wow) {
            throw new RuntimeException(wow.getMessage(), wow);
        }
    }
}
