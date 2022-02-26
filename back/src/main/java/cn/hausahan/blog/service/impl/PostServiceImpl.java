package cn.hausahan.blog.service.impl;

import cn.hausahan.blog.entity.Post;
import cn.hausahan.blog.mapper.PostMapper;
import cn.hausahan.blog.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
