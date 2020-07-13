package com.xmsx24.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    RecordDAO dao;

    @Override
    public Message addRecord(String userId, String type, String keyword) {
        RecordBean record = new RecordBean(userId, type, keyword);
        Message message = new Message();
        try {
            dao.save(record);
            message.setState(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setState(false);
        }
        return message;
    }

    @Override
    public Iterable<RecordBean> getRecords(String userId) {
        Iterable<RecordBean> records = new ArrayList<>();
        try {
            records = dao.findByUserId(userId);
            //records = dao.findByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}
