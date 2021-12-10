package land.lark.processor;

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
	public Object process(String paramString);
}