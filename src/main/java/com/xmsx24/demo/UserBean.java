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
@Document(indexName = "user")
public class UserBean implements Serializable {
    public UserBean(){}
    public UserBean(String username, String password){
        this.username = username;
        this.password = password;
    }
    @Id
    private String id = getRandomId(64);
    @Field(type = FieldType.Text)
    private String username;
    @Field(type = FieldType.Text)
    private String password;

    public static String getRandomId(int len) {
        StringBuffer str = new StringBuffer();
        String temp="ABCDEF0123456789";
        Random rnd = new Random();
        for(int i=0;i<len;++i) str.append(temp.charAt(rnd.nextInt(16)));
        return str.toString();
    }
}
