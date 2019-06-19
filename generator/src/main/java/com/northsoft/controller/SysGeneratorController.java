

package com.northsoft.controller;

import com.northsoft.service.SysGeneratorService;
import com.northsoft.utils.GenUtils;
import com.northsoft.utils.R;
import com.northsoft.utils.PageUtils;
import com.northsoft.utils.Query;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author Mark sunlightcs@gmail.com
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils pageUtil = sysGeneratorService.queryList(new Query(params));

        return R.ok().put("page", pageUtil);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    public void code(String tables,
                     String packageInfo,
                     String moduleName,
                     String author,
                     String email,
                     HttpServletResponse response) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("package", packageInfo);
        params.put("moduleName", moduleName);
        params.put("author", author);
        params.put("email", email);

        byte[] data = sysGeneratorService.generatorCode(tables.split(","), params);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"northsoft_oddjobs.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }

    @ResponseBody
    @RequestMapping("/properties")
    public R properties() {
        return R.ok()
                .put("package", GenUtils.getConfig().getString("package", ""))
                .put("moduleName", GenUtils.getConfig().getString("moduleName", ""))
                .put("author", GenUtils.getConfig().getString("author", ""))
                .put("email", GenUtils.getConfig().getString("email", ""));
    }
}
