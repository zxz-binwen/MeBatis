package org.baits.mapper;

import org.baits.entity.Blog;

public interface BlogMapper {

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Blog getBlogById(Integer id);
}
