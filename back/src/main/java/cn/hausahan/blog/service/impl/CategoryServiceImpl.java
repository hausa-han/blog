package cn.hausahan.blog.service.impl;

import cn.hausahan.blog.entity.Category;
import cn.hausahan.blog.mapper.CategoryMapper;
import cn.hausahan.blog.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
