package com.xmsx24.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Random;

@Data
@AllArgsConstructor
@Document(indexName = "userrecord")
public class RecordBean implements Serializable {
    public RecordBean(){};
    public RecordBean(String userId, String type, String keyword){
        this.userId = userId;
        this.type = type;
        this.keyWord = keyword;
    }
    @Id
    private String id = getRandomId(64);
    @Field(type = FieldType.Text)
    private String userId;
    @Field(type = FieldType.Text)
    private String type;
    @Field(type = FieldType.Text)
    private String keyWord;
    public static String getRandomId(int len) {
        StringBuffer str = new StringBuffer();
        String temp="ABC0123456789DEF";
        Random rnd = new Random();
        for(int i=0;i<len;++i) str.append(temp.charAt(rnd.nextInt(16)));
        return str.toString();
    }
}
