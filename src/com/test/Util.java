package com.test;

import java.nio.charset.StandardCharsets;

public class Util {
    public static String toUTF8(String str) {
        return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public static String getDepartment(int departmentId) {
        switch (departmentId) {
            case 1:
                return "经济管理学院";
            case 2:
                return "智能制造学部";
            case 3:
                return "艺术设计学院";
            case 4:
                return "外国语学院";
            case 5:
                return "数学与计算科学学院";
            case 6:
                return "马克思主义学院";
            default:
                return null;
        }
    }
}
