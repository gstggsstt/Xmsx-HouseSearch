package com.xmsx24.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDAO extends ElasticsearchRepository<UserBean, String> {
    UserBean findByUsername(String userName);
    UserBean findByUsernameAndPassword(String username, String password);
}
