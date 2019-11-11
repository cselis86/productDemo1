package com.elis.product1.product1.commons.validation;

import java.util.Collection;
import java.util.Map;

public class Validator {

    public static boolean isEmptyOrNull(Object o){
        if (o == null){
            return true;
        }
        if (o instanceof String){
            return o.toString().trim().isEmpty();
        }
        if (o instanceof Collection){
            return ((Collection) o).isEmpty();
        }
        if (o instanceof Map) {
            return ((Map) o).isEmpty();
        }
        return false;
    }

    public static boolean isEmptyOrNull(Object[] o){
        return o == null || o.length == 0;
    }

    public static boolean hasValue(Object o){
        return !isEmptyOrNull(o);
    }

    public static boolean hasValue(Object[] o){
        return !isEmptyOrNull(o);
    }

}

