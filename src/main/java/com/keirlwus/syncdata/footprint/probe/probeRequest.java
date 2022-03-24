package com.keirlwus.syncdata.footprint.probe;

import com.keirlwus.syncdata.footprint.entity.ResponseInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by krielwus on 2022-03-24 11:04
 * 探针请求
 * @author krielwus
 */
@RestController
@RequestMapping(value = "/probeRequest")
public class probeRequest {

    @RequestMapping(value = "/test.html")
    public Object probe(String push_text,HttpServletRequest request){
        ResponseInfo responseInfo = new ResponseInfo(1001,push_text+",probeRequest success!",null,
                "timestamp:"+System.currentTimeMillis());
        return responseInfo;
    }
}
