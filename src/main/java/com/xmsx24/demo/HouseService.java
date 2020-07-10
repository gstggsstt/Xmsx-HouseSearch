package com.xmsx24.demo;

import java.util.List;
import java.util.Random;

public interface HouseService {
    Iterable<HouseBean> findAll();
    void save(HouseBean bean);
    void save(List<HouseBean> list);
    List<HouseBean> findByTitle(String id);
    List<HouseBean> findByDetailMessage(String kw);
    List<HouseBean> findByAny(String t);
    List<HouseBean> findByArea(String area);
    List<HouseBean> findByCommunity(String comm);
    List<HouseBean> findByPriceLessThan(Integer r);
    List<HouseBean> findByPriceGreaterThan(Integer l);
    List<HouseBean> findByPriceBetween(Integer l, Integer r);
}
