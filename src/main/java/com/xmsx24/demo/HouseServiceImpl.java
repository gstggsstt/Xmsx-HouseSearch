package com.xmsx24.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseDAO dao;

    @Override
    public Iterable<HouseBean> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(HouseBean bean) {
        dao.save(bean);
    }

    @Override
    public List<HouseBean> findByArea(String text) {
        return dao.findByArea(text);
    }

    @Override
    public void save(List<HouseBean> list) {
        dao.saveAll(list);
    }

    @Override
    public List<HouseBean> findByDetailMessage(String kw) {
        return dao.findByDetailMessage(kw);
    }

    @Override
    public List<HouseBean> findByCommunity(String comm) {
        return dao.findByCommunity(comm);
    }

    @Override
    public List<HouseBean> findByPriceLessThan(Integer r) {
        return dao.findByPriceLessThan(r);
    }

    @Override
    public List<HouseBean> findByPriceGreaterThan(Integer l) {
        return dao.findByPriceGreaterThan(l);
    }

    @Override
    public List<HouseBean> findByPriceBetween(Integer l, Integer r) {
        return dao.findByPriceBetween(l, r);
    }

    @Override
    public List<HouseBean> findByAny(String text) {
        return dao.findByTitleOrDetailMessageOrAreaOrCommunity(text,text,text,text);
    }

    @Override
    public List<HouseBean> findByTitle(String text) {
        return dao.findByTitle(text);
    }
}
