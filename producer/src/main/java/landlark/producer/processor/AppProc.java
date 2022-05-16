package landlark.producer.processor;

import java.io.IOException;

/**
 * AppProc
 * 
 * @author yonxu
 */
public interface AppProc {
	
	/**
     * process by request message
     * 
     * @param paramString JSON format context
     * @return Object
     */
	public Object process(String req) throws InterruptedException, IOException;
}