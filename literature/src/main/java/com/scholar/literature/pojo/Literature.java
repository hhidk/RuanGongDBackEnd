package com.scholar.literature.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Literature {
    // 从数据库中直接取到的字段
    private String literatureID;
    private String title;
    private String url;
    private String references;
    private String type;
    private String publisher;
    private String _abstract; // 和java关键字重名了
    private String keywords;
    private String area;
    private String venue;
    private String authors;

    // 从取出字段拆分得到的对象
    private List<String> referenceList;
    private List<String> keywordList;
    private List<Author> authorList;
}
