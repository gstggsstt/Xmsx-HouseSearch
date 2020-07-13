package com.xmsx24.demo;

import java.util.List;

public interface RecordService {
    Message addRecord(String userId, String type, String keyword);
    Iterable<RecordBean> getRecords(String userId);
}
