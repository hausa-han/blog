package cn.hausahan.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String title;

    private String src;

    private String created;

    private String updated;

    private String password;

    private Integer statu;

    private Integer readTimes;

    private Integer likeTimes;


}
