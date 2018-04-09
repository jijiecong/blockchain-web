package com.meiren.web.converter;

import com.meiren.common.utils.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateConverter implements Converter<String, Date> {

private static List<String> patterns=new ArrayList<>();
    static {//注意先后顺序 第三个也会成功解析一种样式的时间
        patterns.add("yyyy-MM-dd HH:mm:ss");
        patterns.add("yyyy-M-d H:m:s");
        patterns.add("yyyy-MM-dd");
        patterns.add("yyyy-M-d");
    }

    @Override
    public Date convert(String source) {
        if (StringUtils.isEmpty(source)){
            return null;
        }
        for (int i=0;i<patterns.size();i++){
            try {
                return new SimpleDateFormat(patterns.get(i)).parse(source.trim());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
