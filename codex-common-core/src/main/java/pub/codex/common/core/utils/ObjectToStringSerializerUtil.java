package pub.codex.common.core.utils;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.IOException;
import java.util.ArrayList;

public class ObjectToStringSerializerUtil extends ToStringSerializer {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
            throws IOException
    {

        if(value instanceof ArrayList){
            ArrayList<String> result = new ArrayList<>();
            ((ArrayList<Long>)value).stream().forEach(item -> {
                result.add(item.toString());
            });
            gen.writeObject(result);
        }else{
            gen.writeString(value.toString());
        }
    }
}
