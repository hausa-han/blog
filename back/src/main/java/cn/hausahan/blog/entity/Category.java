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
 * @since 2021-11-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private LocalDateTime created;

    private Integer readTimes;

    private Integer likeTimes;


}
