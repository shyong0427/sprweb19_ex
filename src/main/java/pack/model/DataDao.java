package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends SqlSessionDaoSupport {
	@Autowired
	public DataDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<JikwonDto> jikwonList() {
		List<JikwonDto> list = getSqlSession().selectList("selectJikwonData");
		
		return list;
	}
	
	public List<GogekDto> gogekList(String num) {
		List<GogekDto> list = getSqlSession().selectList("selectGogekData", num);
		
		return list;
	}

}
