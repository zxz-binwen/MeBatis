package org.baits.v1.mapper;

import org.baits.v1.entity.Blog;

public interface BlogMapper {

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Blog getBlogById(Integer id);
}
