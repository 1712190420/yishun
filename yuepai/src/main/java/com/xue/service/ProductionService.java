package com.xue.service;

import com.xue.exception.MyException;
import com.xue.pojo.dto.ProductionTransfer;
import com.xue.pojo.vo.ProductionShow;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface ProductionService {
    List<ProductionShow>  selectProductionByTag(String tag) throws MyException;
    List<String> selectHotImg();
    String insertProduction(MultipartFile[] files, HttpServletRequest request, ProductionTransfer productionTransfer)throws IOException;
    List<ProductionShow> selectProductionByAccount(String account)throws MyException;
}
