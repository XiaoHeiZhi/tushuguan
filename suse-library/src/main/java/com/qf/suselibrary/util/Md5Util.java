package com.qf.suselibrary.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {

    public static String get(String source,String salt){
        Md5Hash md5Hash = new Md5Hash(source, salt, 1000);
        return md5Hash.toString();
    }
    /*public static void main(String[] args){
        String s = Md5Util.get("admin", "admin");
        System.out.println(s);
    }*/

}
