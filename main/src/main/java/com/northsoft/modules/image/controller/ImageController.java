package com.northsoft.modules.image.controller;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.northsoft.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * 图片相关接口
 *
 * @author liuyi
 * @email 343368666@qq.com
 * @date 19-6-25
 */
@Slf4j
@Controller
@RequestMapping(value = "/api/image")
public class ImageController {
    @Autowired
    private OkHttpClient okHttpClient;

    @PostMapping(value = "/uploadImageMultipart")
    @ResponseBody
    public R uploadImageMultipart(@RequestParam(value = "file") MultipartFile file) throws IOException {
        log.info("客户端请求使用Multipart方式上传图片");
        if (file == null && file.isEmpty()) {
            return R.error(400, "未找到对应文件");
        }
        String fileName = file.getOriginalFilename();
        byte[] fileBytes = file.getBytes();
        return uploadImage(fileName, fileBytes);
    }

    @PostMapping(value = "/uploadImageBase64/{fileName}")
    @ResponseBody
    public R uploadImageBase64(@PathVariable(value = "fileName") String fileName, @RequestBody String base64) throws IOException {
        log.info("客户端请求使用BASE64方式上传图片");
        if (StringUtils.isEmpty(base64)) {
            return R.error(400, "未找到对应的图片base64信息");
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte fileBytes[] = decoder.decodeBuffer(base64);
        return uploadImage(fileName, fileBytes);
    }

    public R uploadImage(String fileName, byte[] fileBinary) throws IOException {
        log.info("fileName:" + fileName);
        String ext = null;
        if (fileName.contains(".")) {
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return R.error(400, "上传的文件扩展名为空");
        }
        if (!stringIn(ext, "jpg", "jpeg", "png")) {
            return R.error(400, "不支持上传文件的格式");
        }

        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("image/" + ext), fileBinary);
        Request request = new Request.Builder()
                .url("http://api.heatingpay.com/heatingpay/attachment/uploadbinaryfile?FileName=" + fileName)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        JsonObject jo = new JsonParser().parse(response.body().string()).getAsJsonObject();
        int errcode = jo.get("errcode").getAsInt();
        if (errcode != 0) {
            log.error("服务上传图片发生异常，错误码：[" + errcode + "]错误消息：" + jo.get("errmsg").getAsString());
            return R.error("服务上传图片发生异常，错误码：" + errcode);
        }
        String mediaId = jo.get("data").getAsJsonObject().get("mediaid").getAsString();

        request = new Request.Builder()
                .url("http://api.heatingpay.com/heatingpay/attachment/getfile?MediaID=" + mediaId + "&FilePath=OddJobs")
                .get()
                .build();

        call = okHttpClient.newCall(request);
        response = call.execute();

        jo = new JsonParser().parse(response.body().string()).getAsJsonObject();
        errcode = jo.get("errcode").getAsInt();
        if (errcode != 0) {
            log.error("服务上传图片发生异常，错误码：[" + errcode + "]错误消息：" + jo.get("errmsg").getAsString());
            return R.error("服务上传图片发生异常，错误码：" + errcode);
        }

//        String path = "http://api.heatingpay.com" + jo.get("data").getAsJsonObject().get("filename").getAsString();
        String path = jo.get("data").getAsJsonObject().get("filename").getAsString();
        log.info("图片上传成功，保存地址:" + path);
        return R.ok().put("filePath", path);
    }

    public boolean stringIn(String key, String... compares) {
        for (String compare : compares) {
            if (StringUtils.equals(key, compare)) {
                return true;
            }
        }
        return false;
    }

}
