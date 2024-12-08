package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;


public final class MapSchema extends BaseSchema<Map<String, ?>> {

    public MapSchema() {
        predicatesMap = new HashMap<>();
    }

    public MapSchema sizeof(int size) {
        predicatesMap.put("isSize", map -> map.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        predicatesMap.put("isTrue", map -> schemas.entrySet().stream().allMatch(e -> {
            var v = map.get(e.getKey());
            var schema = e.getValue();
            return schema.isValid((T) v);
        }));
        return this;
    }
}
