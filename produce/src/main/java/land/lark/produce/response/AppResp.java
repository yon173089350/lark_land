package land.lark.produce.response;

import java.util.Date;

/**
 * AppResp
 * 
 * @author yonxu
 */
public class AppResp {
	private String errCode;
	private String errMsg;
	private Object context;
	private Date startTime;
	private Date endTime;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getContext() {
		return this.context;
	}

	public void setContext(Object context) {
		this.context = context;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
