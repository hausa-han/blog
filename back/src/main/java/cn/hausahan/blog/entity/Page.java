package cn.hausahan.blog.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Hausa_
 * @since 2021-12-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Page extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String title;

    private String src;

    private String created;

    private String updated;

    private Integer statu;

    private Integer readTimes;

    private Integer likeTimes;


}
