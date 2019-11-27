package com.jiao.controller;

import com.jiao.pojo.dao.Zan;
import com.jiao.service.ZanService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zan")
public class ZanController {

    @Autowired
    private ZanService zanService;

    @GetMapping("/")
    public Map<String, Zan> addzan() {
        zanService.addCount();
        Zan zanCount = zanService.getZanCount();
        Zan zfCount = zanService.getZfCount();
        Map<String, Zan> map = new HashMap<>();
        map.put("zanCount", zanCount);
        map.put("zfCount", zfCount);
        return map;
    }

    @GetMapping("/count")
    private Map<String, Zan> getZanCount() {
        Zan zanCount = zanService.getZanCount();
        Zan zfCount = zanService.getZfCount();
        Map<String, Zan> map = new HashMap<>();
        map.put("zanCount", zanCount);
        map.put("zfCount", zfCount);
        return map;
    }

    @GetMapping("/download")
    private Zan download(@RequestParam(name = "type",required = false) Integer type) {

        return zanService.addDowmloadCount(type);
    }

}
