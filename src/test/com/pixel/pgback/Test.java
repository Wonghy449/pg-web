package com.pixel.pgback;

import com.pixel.pgback.common.Constants;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback
 * @Author: zhouzw
 * @CreateTime: 2019/7/6 0:57
 * @Description: test
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd HH";
        DateFormat sdf = DateFormat.getDateTimeInstance();
        String s = "2019-08-10 0401";
        String[] strings = s.split(" ");
        System.out.println(Arrays.toString(strings));
        String date = strings[0];
        System.out.println(sdf.parse(date + " " + Constants.INTERVIEW_TIME_09));
    }
}
