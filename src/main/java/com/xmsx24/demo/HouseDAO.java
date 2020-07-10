package com.xmsx24.demo;

import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface HouseDAO extends ElasticsearchRepository<HouseBean, String> {
    List<HouseBean> findByTitle(String id);
    List<HouseBean> findByDetailMessage(String kw);
    List<HouseBean> findByTitleOrDetailMessageOrAreaOrCommunity(String t1, String t2, String t3, String t4);
    List<HouseBean> findByArea(String area);
    List<HouseBean> findByCommunity(String comm);
    List<HouseBean> findByPriceLessThan(Integer r);
    List<HouseBean> findByPriceGreaterThan(Integer l);
    List<HouseBean> findByPriceBetween(Integer l, Integer r);
}
