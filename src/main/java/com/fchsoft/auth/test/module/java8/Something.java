package com.fchsoft.auth.test.module.java8;

import lombok.Data;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName Something.java
 * @Description
 * @createTime 2022-02-18 16:41
 */
@Data
public class Something {
    private String name;
    public Something() {
    }

    public Something(String something) {
        System.out.println(something);
    }

    static String startWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));
    }

    void endWith (){
    }

    public static void main(String[] args) {
        IConvert<String, String> convert = Something::startWith;
        String r = convert.convert("123");
        System.out.println(r);
        IConvert<String, String> convert1 = new Something()::endWith;
        String j = convert1.convert("java");
        System.out.println(j);
        IConvert<String, Something> convert2 = Something::new;
        convert2.convert("constructor11");
    }
}
