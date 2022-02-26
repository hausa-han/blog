package cn.hausahan.blog.entity;

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
public class PostCate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer postId;

    private Integer categoryId;


}
