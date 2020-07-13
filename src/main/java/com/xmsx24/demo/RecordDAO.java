package com.xmsx24.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface RecordDAO extends ElasticsearchRepository<RecordBean, String> {
    List<RecordBean> findByUserId(String userId);
}
