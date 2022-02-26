package cn.hausahan.blog.service.impl;

import cn.hausahan.blog.entity.Page;
import cn.hausahan.blog.mapper.PageMapper;
import cn.hausahan.blog.service.IPageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hausa_
 * @since 2021-12-24
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements IPageService {

}
