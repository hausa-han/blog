package cn.hausahan.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long parentId;

    private String name;

    private String path;

    /**
     * for auth, such as: user:list,user:create
     */
    private String perms;

    private String component;

    /**
     * types, 0:directory, 1:menu, 2:button
     */
    private Integer type;

    /**
     * order
     */
    @TableField("orderNum")
    private Integer orderNum;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Integer statu;

    @TableField(exist = false)
    private List<Menu> children = new ArrayList<>();

}
