package com.pixel.pgback.common.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.util
 * @Author: zhouzw
 * @CreateTime: 2019/5/12 16:54
 * @Description: ${Description}
 */
public class MailUtilTest {

    @Test
    public void sendMailText() throws Exception {
        MailUtil.sendMailText("单发测试", "单发测试", "627745019@qq.com");
        MailUtil.sendMailText("群发测试", "群发测试", "627745019@qq.com,zhouzhiweidlut@sina.com");
    }

    @Test
    public void sendMailMulti() {
    }

    @Test
    public void mapTest() {
        System.out.println(new HashMap<String, String>().put("1", "1"));
        Map<String, String> map = new HashMap<>(1);
        map.put("1", "2");
        System.out.println(map.put("1", "1"));
        System.out.println(map);
    }
}