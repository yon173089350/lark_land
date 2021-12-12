package landlark.produce.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * AppResp
 * 
 * @author yonxu
 */
@Setter
@Getter
public class AppResp {
	private String errCode;
	private String errMsg;
	private Object context;
	private Date startTime;
	private Date endTime;
}
