package org.baits.v1;

import org.baits.v1.conf.Configuration;
import org.baits.v1.conf.Executor;
import org.baits.v1.conf.SqlSession;
import org.baits.v1.mapper.BlogMapper;

public class Test {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        System.out.println(mapper.getBlogById(1));
    }
}
