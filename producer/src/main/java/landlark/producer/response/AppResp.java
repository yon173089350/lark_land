package landlark.producer.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * AppResp
 * 
 * @author yonxu
 */
@Data
@Builder
public class AppResp {
	private Date timestamp;
	private int status;
	private String error;
	private String path;
	private Object context;
}
