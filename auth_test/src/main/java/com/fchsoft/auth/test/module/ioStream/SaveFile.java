package com.fchsoft.auth.test.module.ioStream;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName SaveFile.java
 * @Description
 * @createTime 2022-01-18 22:50
 */
@Data
@Document("saveFile")
public class SaveFile {
    private String name;
    private String path;
    private String content;
    private Long size;
}
