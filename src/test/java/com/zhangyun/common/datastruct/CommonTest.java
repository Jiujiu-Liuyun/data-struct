package com.zhangyun.common.datastruct;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/8/14 23:54
 * @since: 1.0
 */
@Slf4j
public class CommonTest {

    @Test
    public void jsonTest() {
        String s = "\"ab\"";
        String integer = JSONObject.parseObject(s, String.class);
        log.info("{}", integer);
    }
}
