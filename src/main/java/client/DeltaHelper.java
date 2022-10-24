package client;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by I311579 on 5/1/2016.
 */
public abstract class DeltaHelper {
    public abstract void send(String message) throws IOException;

    public void send(String measurement,
                     Map<String, String> tags,
                     Map<String, Integer> integerFields,
                     Map<String, Float> floatFields,
                     Map<String, Boolean> booleanFields,
                     Map<String, String> stringFields) throws IOException {
        send(measurement, tags, integerFields, floatFields, booleanFields, stringFields, -1);
    }

    public void send(String measurement,
                     Map<String, String> tags,
                     Map<String, Integer> integerFields,
                     Map<String, Float> floatFields,
                     Map<String, Boolean> booleanFields,
                     Map<String, String> stringFields,
                     long timestamp) throws IOException {
        StringBuilder message = new StringBuilder(escape(measurement));
        if (tags != null && tags.size() > 0) {
            Iterator<Map.Entry<String, String>> entries = tags.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                message.append(",").append(escape(entry.getKey())).append("=").append(escape(entry.getValue()));
            }
        }

        if (integerFields != null && integerFields.size() > 0) {
            Iterator<Map.Entry<String, Integer>> entries = integerFields.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Integer> entry = entries.next();
                message.append(" ").append(escape(entry.getKey())).append("=").append(entry.getValue());
            }
        }

        if (floatFields != null && floatFields.size() > 0) {
            Iterator<Map.Entry<String, Float>> entries = floatFields.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Float> entry = entries.next();
                message.append(" ").append(escape(entry.getKey())).append("=").append(entry.getValue());
            }
        }

        if (booleanFields != null && booleanFields.size() > 0) {
            Iterator<Map.Entry<String, Boolean>> entries = booleanFields.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Boolean> entry = entries.next();
                message.append(" ").append(escape(entry.getKey())).append("=").append(entry.getValue());
            }
        }

        if (stringFields != null && stringFields.size() > 0) {
            Iterator<Map.Entry<String, String>> entries = stringFields.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                message.append(" ").append(escape(entry.getKey())).append("=").append(entry.getValue());
            }
        }
        if (timestamp > 0) {
            message.append(" ").append(timestamp);
        }
        send(message.toString());
    }

    public String escape(String message) {
        return message.replace(",", "\\,").replace(" ", "\\ ").replace("=", "\\=");
    }

}
