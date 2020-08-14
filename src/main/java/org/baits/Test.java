package org.baits;

public class Test {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        System.out.println(mapper.getBlogById(1));
    }
}
