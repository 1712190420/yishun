package com.xue.service.Impl;

import com.xue.dao.ProductionMapper;
import com.xue.dao.UserDetailMapper;
import com.xue.exception.MyException;
import com.xue.pojo.dto.ProductionTransfer;
import com.xue.pojo.po.Production;
import com.xue.pojo.po.UserDetail;
import com.xue.pojo.vo.ProductionShow;
import com.xue.service.ProductionService;
import com.xue.utils.AddressTransferUtil;
import com.xue.utils.IPAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    ProductionMapper productionMapper;
    @Autowired
    UserDetailMapper userDetailMapper;

    @Override
    public List<ProductionShow> selectProductionByTag(String tag) throws MyException {
        List<Production> productions = productionMapper.fuzzyQueryByTagList(tag);
        if (productions.size()==0){
            throw  new MyException("该分类下没有作品！！");
        }
        List<ProductionShow>  productionShows=new ArrayList<>();
        for (int i = 0; i < productions.size(); i++) {
            ProductionShow productionShow = new ProductionShow();
            UserDetail userDetail = userDetailMapper.selectByPrimaryKey(productions.get(i).getAccount());
            productionShow.setCameraArea(productions.get(i).getCameraArea());
            productionShow.setExplain(productions.get(i).getExplain());
            productionShow.setId(productions.get(i).getId());
            productionShow.setImglist(AddressTransferUtil.addressTrans(productions.get(i).getImglist()));
            productionShow.setLaunchTime(productions.get(i).getLaunchTime());
            productionShow.setNickName(userDetail.getNickName());
            productionShows.add(productionShow);
        }
        return productionShows;
    }

    @Override
    public List<String> selectHotImg() {
        List<String> imgs = productionMapper.selectHotImg();
        List<String> imgList =new ArrayList<>();
        for (String img : imgs) {
            String[] images = img.split(";");
            for (String image : images) {
                image=IPAddressUtil.getLocalIp()+image;
                imgList.add(image);
            }
        }
        return imgList;
    }

    @Override
    public String insertProduction(MultipartFile[] files, HttpServletRequest request, ProductionTransfer productionTransfer) throws IOException {
        Production production = new Production();
        if (files==null){
            System.out.println("文件为空");
            return "请选择照片后再上传作品！";
        }else{
            System.out.println("文件不为空！");
            String pictureurl="";
            System.out.println("文件长度"+files.length);
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                String uploadFileName =files[i].getOriginalFilename();
                if ("".equals(uploadFileName)){
                    return "上传的图片文件名不能为空";
                }
                System.out.println("上传文件名："+uploadFileName);
                String path= "/home/projects/yuepai/pro";
                File realPath =new File(path);
                if (!realPath.exists()){
                    realPath.mkdir();
                }
                System.out.println("上传文件保存地址："+realPath);
                InputStream is =files[i].getInputStream();
                OutputStream os =new FileOutputStream(new File(realPath,uploadFileName));
                int len =0;
                byte[] buffer =new byte[1024];
                while((len = is.read(buffer))!=-1){
                    os.write(buffer,0,len);
                    os.flush();
                }
                os.close();
                is.close();
                if (i==files.length-1){
                    pictureurl=pictureurl+"pro/"+uploadFileName;
                }else{
                    pictureurl=pictureurl+"pro/"+uploadFileName+";";
                }
            }
            production.setAccount(productionTransfer.getAccount());
            production.setCameraArea(productionTransfer.getCameraArea());
            production.setExplain(productionTransfer.getExplain());
            production.setLaunchTime(productionTransfer.getLaunchTime());
            production.setTaglist(productionTransfer.getTaglist());
            production.setImglist(pictureurl);
            productionMapper.insert(production);
            return "插入成功";
        }
    }

    @Override
    public List<ProductionShow> selectProductionByAccount(String account) throws MyException {
        List<Production> productions = productionMapper.selectByAccount(account);
        if (productions.size()==0){
            throw  new MyException("你还没有发布作品！！");
        }
        List<ProductionShow>  productionShows=new ArrayList<>();
        for (int i = 0; i < productions.size(); i++) {
            ProductionShow productionShow = new ProductionShow();
            UserDetail userDetail = userDetailMapper.selectByPrimaryKey(productions.get(i).getAccount());
            productionShow.setCameraArea(productions.get(i).getCameraArea());
            productionShow.setExplain(productions.get(i).getExplain());
            productionShow.setId(productions.get(i).getId());
            productionShow.setImglist(AddressTransferUtil.addressTrans(productions.get(i).getImglist()));
            productionShow.setLaunchTime(productions.get(i).getLaunchTime());
            productionShow.setNickName(userDetail.getNickName());
            productionShows.add(productionShow);
        }
        return productionShows;
    }
}
