package com.nibolyoung.baiduai.api;

import com.nibolyoung.baiduai.utils.Base64Util;
import com.nibolyoung.baiduai.utils.FileUtil;
import com.nibolyoung.baiduai.utils.HttpUtil;

import java.net.URLEncoder;

/**
 * Created by: nibolyoung on 2020/11/10.
 * Description: api for car distinguish
 */

public class CarDistinguish {
    private static final String TAG=CarDistinguish.class.getSimpleName();

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String getCarMessageJson(String url,String filePath,String accessToken) {
        // 请求url
        try {
            // 本地文件路径
            //String filePath = "[本地文件路径]";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam + "&top_num=" + 5;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
