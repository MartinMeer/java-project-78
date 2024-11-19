package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchemaT<T> extends BaseSchema<Map<String, T >> {

    public MapSchemaT() {
        predicateMap = new HashMap<>();
    }

    public MapSchemaT<?> sizeof(int size) {
        predicateMap.put("isSize", map -> map.size() == size);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {

    }
}
