package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	private DataDao dataDao;
	
	@RequestMapping("jikwon")
	@ResponseBody
	public Map<String, Object> jikwons() {
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = null;
		
		List<JikwonDto> jikwondata = dataDao.jikwonList();
		
		for(JikwonDto j : jikwondata) {
			data = new HashMap<String, String>();
			data.put("jikwon_no", j.getJikwon_no());
			data.put("jikwon_name", j.getJikwon_name());
			data.put("buser_tel", j.getBuser_tel());
			data.put("jikwon_jik", j.getJikwon_jik());
			data.put("gogek_su", j.getGogek_su());
			
			dataList.add(data);
		}
		
		Map<String, Object> jikwonDatas = new HashMap<String, Object>();
		jikwonDatas.put("jikwondatas", dataList);
		
		return jikwonDatas;
	}
}