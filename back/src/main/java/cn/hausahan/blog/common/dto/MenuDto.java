package cn.hausahan.blog.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * title: 'algorithm',
 * name: 'DevelopmentAlgorithm',
 * path: '/development/algorithm',
 * component: 'common/mainviews/DevelopAlgorithm',
 * children: []
 */
@Data
public class MenuDto implements Serializable {

    private Long id;
    private String title;
    private String name;
    private String path;
    private String component;
    private List<MenuDto> children = new ArrayList<>();

}
