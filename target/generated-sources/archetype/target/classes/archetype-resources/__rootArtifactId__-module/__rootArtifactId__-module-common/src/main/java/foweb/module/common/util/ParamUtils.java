#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.foweb.module.common.util;

import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ParamUtils {

    public static int getPageNow(Map<String, Object> param) {
        int pageNow = 0;
        if (param != null) {
            Object pageNowObj = param.get("pageNow");
            if (pageNowObj == null)
                return 1;
            if (pageNowObj instanceof Integer) {
                pageNow = ((Integer) pageNowObj).intValue();
            }
            pageNow = new Integer(pageNowObj.toString()).intValue();
        }
        return pageNow;
    }

    public static int getPageSize(Map<String, Object> param) {
        int pageSize = 0;
        if (param != null) {
            Object pageSizeObj = param.get("pageSize");
            if (pageSizeObj == null)
                return 10;
            if (pageSizeObj instanceof Integer) {
                pageSize = ((Integer) pageSizeObj).intValue();
            }
            pageSize = new Integer(pageSizeObj.toString()).intValue();
        }
        return pageSize;
    }

    private static Integer getInteger(String string) {
        Integer integer = 0;
        if (StringUtils.isNotBlank(string)) {
            integer = new Integer(string);
        }
        return integer;
    }

    public static Integer getInteger(Map<String, Object> param, String key) {
        Object value = param.get(key);
        Integer integer = null;
        if (value != null && StringUtils.isNotBlank(value.toString())) {
            integer = new Integer(value.toString());
        }
        return integer;
    }

    public static Boolean getBoolean(Map<String, Object> param, String key) {
        Object value = param.get(key);
        Boolean result = null;
        if (value instanceof String) {
            result = Boolean.valueOf((String) value);
        } else if (value instanceof Boolean) {
            result = (Boolean) value;
        }
        return result;
    }

}
