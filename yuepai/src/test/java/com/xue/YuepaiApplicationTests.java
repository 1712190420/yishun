package com.xue;

import com.xue.utils.AddressTransferUtil;
import com.xue.utils.IPAddressUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@SpringBootTest
class YuepaiApplicationTests {
    public static void main(String[] args) {
        String path = null;
        path = "D:/Project/test/file";
        System.out.println(path);
        //如果路径不存在，创建一个
       /* File realPath = new File(path);
        if (!realPath.exists()) {
            boolean b = realPath.mkdir();
            System.out.println("b: "+b);
        }*/
    }

    @Test
    void contextLoads() {

    }

}
