package landlark.producer.response;

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
	private Date timestamp;
	private int status;
	private String error;
	private String path;
	private Object context;
}
