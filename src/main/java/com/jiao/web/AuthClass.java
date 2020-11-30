package com.jiao.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*标记注解，如果一个类被标记上该注解，说明其中存在需要进行权限控制的方法*/
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthClass {
    public String value() default "";

}
