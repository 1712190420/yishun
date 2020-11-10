package com.xue.controller;

import com.xue.exception.MyException;
import com.xue.pojo.dto.ProductionTransfer;
import com.xue.pojo.vo.ProductionShow;
import com.xue.service.ProductionService;
import com.xue.utils.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    ProductionService productionService;

    @ApiOperation("根据标签获取作品")
    @GetMapping("/getProduction")
    public JSONResult getProductionByTag(String tag){
        try {
            if ("".equals(tag)){
                return JSONResult.errorMsg("tag为空，请输入！！");
            }
            return  JSONResult.success(productionService.selectProductionByTag(tag));
        } catch (MyException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }
    @ApiOperation("获取热门图片")
    @GetMapping("getHotImg")
    public JSONResult getHotImage(){
        return JSONResult.success(productionService.selectHotImg());
    }


    @ApiOperation("新增作品")
    @PostMapping("/insertNewProduction")
    public JSONResult insertNewProduction(@RequestParam("file")MultipartFile[] files, HttpServletRequest request, ProductionTransfer productionTransfer){
        try {
            return  JSONResult.success(productionService.insertProduction(files,request,productionTransfer));
        } catch (IOException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }

    @ApiOperation("根据账号获取作品")
    @GetMapping("/getProductionByAccount")
    public JSONResult getProductionByAccount(String account){
        try {
            if ("".equals(account)){
                return JSONResult.errorMsg("account为空，请输入！！");
            }
            return  JSONResult.success(productionService.selectProductionByAccount(account));
        } catch (MyException e) {
            return JSONResult.errorMsg(e.getMessage());
        }
    }


}
