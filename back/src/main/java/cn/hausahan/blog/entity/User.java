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
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String email;

    private LocalDateTime lastLogin;

    private Integer statu;


}
