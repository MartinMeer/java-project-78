package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, ? extends BaseSchema<?>>> {

    public MapSchema() {
        predicatesMap = new HashMap<>();
    }

    public MapSchema sizeof(int size) {
        predicatesMap.put("isSize", map -> map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema<?>> schemas) {


        return this;
    }

}
