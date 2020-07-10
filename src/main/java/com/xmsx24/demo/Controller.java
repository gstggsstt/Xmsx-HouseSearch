package com.xmsx24.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    HouseService hs;

    @RequestMapping(value = "/search/{type}", method = RequestMethod.GET)
    Iterable<HouseBean> Search(@RequestParam String kw, @PathVariable String type) throws JsonProcessingException {
        if(type.equals("any")) return hs.findByAny(kw);
        if(type.equals("title")) return hs.findByTitle(kw);
        if(type.equals("area")) return hs.findByArea(kw);
        if(type.equals("community")) return hs.findByCommunity(kw);
        return null;
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
}
