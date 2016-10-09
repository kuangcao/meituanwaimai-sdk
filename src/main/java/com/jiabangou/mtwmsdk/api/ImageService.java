package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;

/**
 * 配送范围类API
 * Created by freeway on 16/3/12.
 */
public interface ImageService {

    /**
     * 图片上传
     *
     * @throws MtWmErrorException
     */
    String uploadImage(String appPoiCode, String imgName, Byte[] imgData) throws MtWmErrorException;

    /**
     * 图片上传
     *
     * @throws MtWmErrorException
     */
    String uploadImage(String appPoiCode, String imgName, String imgUrl) throws MtWmErrorException;


}
