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
@Document(indexName = "house")
public class HouseBean implements Serializable {
    public HouseBean() {}
    @Id
    @Builder.Default
    private String id = getRandomId(64);

    @Field(type = FieldType.Integer)
    @Builder.Default
    private Integer price = -1;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    @Builder.Default
    private String title = "";
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    @Builder.Default
    private String detailMessage = "";
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    @Builder.Default
    private String area="";
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    @Builder.Default
    private String community="";
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    @Builder.Default
    private String visitTime="";

    @Field(type = FieldType.Text)
    @Builder.Default
    private String picture="";
    @Field(type = FieldType.Text)
    @Builder.Default
    private String url = "";

    public static String getRandomId(int len) {
        StringBuffer str = new StringBuffer();
        String temp="0123456789ABCDEF";
        Random rnd = new Random();
        for(int i=0;i<len;++i) str.append(temp.charAt(rnd.nextInt(16)));
        return str.toString();
    }
}
