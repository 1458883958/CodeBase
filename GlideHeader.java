package com.cardplus.mobile.cardplus.utils;

import android.text.TextUtils;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.cardplus.mobile.cardplus.common.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间： 2019/1/10 9:11
 * 描述：    对添加了请求头的图片url进行加头
 */
public class GlideHeader {
    public static GlideUrl get(String url) {
        if (TextUtils.isEmpty(url)) return null;
        //添加请求头
        return new GlideUrl(Common.IV_HEADER + url, () -> {
            Map<String, String> header = new HashMap<>();
            header.put("Referer", Common.NET);
            return header;
        });
    }
}
