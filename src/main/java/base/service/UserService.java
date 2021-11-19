package base.service;


import base.entity.TestUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final SqlSession sqlSession;

    public UserService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public String getToken(TestUser user) {
        return JWT.create().withAudience(user.getId().toString()).sign(Algorithm.HMAC256(user.getPassword()));
    }

    public TestUser getUserById(Integer userId) {
        return sqlSession.selectOne("MserMapper.getUserById", userId);
    }

    public TestUser getUserByName(String username) {
        return sqlSession.selectOne("MserMapper.getUserByName", username);
    }
}
