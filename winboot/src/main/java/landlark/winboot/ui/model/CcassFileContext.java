package landlark.winboot.ui.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CcassFileContext {
    private Map<String, List<String>> messageLit;
    private String header;
    private String tail;
}

