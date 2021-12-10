package land.lark.processor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import land.lark.mapper.UsrMapper;
import land.lark.processor.AppProc;

@Component("usrProc")
public class CalPositionProc implements AppProc {

	@Autowired
	private UsrMapper usrMapper;
	
	
	@Override
	public Object process(String paramString) {
		return usrMapper.selectAll();
	}

}
