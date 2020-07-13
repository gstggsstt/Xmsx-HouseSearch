package com.xmsx24.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    HouseService hs;
    @Autowired
    UserService us;
    @Autowired
    RecordService rs;

    @RequestMapping(value = "/search/{type}", method = RequestMethod.GET)
    Iterable<HouseBean> Search(@RequestParam String kw, @PathVariable String type, @RequestParam String token) throws JsonProcessingException {
        Iterable<HouseBean> iterable = new ArrayList<>();
        if(type.equals("any")) {
            iterable = hs.findByAny(kw);
        }
        if(type.equals("title")) {
            iterable = hs.findByTitle(kw);
        }
        if(type.equals("area")) {
            iterable = hs.findByArea(kw);
        }
        if(type.equals("community")) {
            iterable = hs.findByCommunity(kw);
        }
        if(!token.equals(""))
            rs.addRecord(token, type, kw);
        return iterable;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    Iterable<HouseBean> Filter(@RequestParam String type, @RequestParam Integer l, @RequestParam Integer r){
        if(type.equals("between")) return hs.findByPriceBetween(l, r);
        if(type.equals("less")) return hs.findByPriceLessThan(l);
        if(type.equals("greater")) return hs.findByPriceGreaterThan(r);
        return null;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void Save(@RequestBody HouseBean bean){
        hs.save(bean);
    }

    @RequestMapping(value = "/saveAll", method = RequestMethod.POST)
    void SaveAll(@RequestBody List<HouseBean> list){
        hs.save(list);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    Message Register(@RequestBody UserBean user){
        return us.register(user);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    Message login(@RequestBody UserBean user){
        return us.login(user);
    }

    @RequestMapping(value = "/record/list", method = RequestMethod.GET)
    Iterable<RecordBean> getRecords(@RequestParam String token){
        return rs.getRecords(token);
    }
}
