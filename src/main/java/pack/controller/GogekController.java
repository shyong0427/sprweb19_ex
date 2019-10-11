package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.GogekDto;

@Controller
public class GogekController {
	@Autowired
	private DataDao dataDao;
	String num;
	@RequestMapping("gogek")
	@ResponseBody
	public Map<String, Object> gogeks(@RequestParam("num") String num) {
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = null;
		this.num = num;
		List<GogekDto> gogekdata = dataDao.gogekList(num);
		
		for(GogekDto g : gogekdata) {
			data = new HashMap<String, String>();
			data.put("gogek_no", g.getGogek_no());
			data.put("gogek_name", g.getGogek_name());
			data.put("gogek_tel", g.getGogek_tel());
			
			dataList.add(data);
		}
		
		Map<String, Object> gogekDatas = new HashMap<String, Object>();
		gogekDatas.put("gogekdatas", dataList);
		
		return gogekDatas;
	}
}