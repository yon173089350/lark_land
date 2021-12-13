package landlark.produce.processor.base;

import com.google.gson.Gson;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class Proc {
    protected Gson gson = new Gson();

    protected void init(String jsonStr, String reqId){
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(this.getClass().getResourceAsStream("/schema/"+reqId+".json")));
        JSONObject jsonSubject = new JSONObject(jsonStr);

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }
}
