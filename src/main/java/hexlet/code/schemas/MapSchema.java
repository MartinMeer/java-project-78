package hexlet.code.schemas;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class MapSchema extends BaseSchema<Map<String, ?>> {

    private Map<String, ? extends BaseSchema<?>> schemas;

    public MapSchema() {
        predicatesMap = new HashMap<>();
    }

    public MapSchema sizeof(int size) {
        predicatesMap.put("isSize", map -> map.size() == size);
        return this;
    }

    //private Predicate<Map<String, Predicate<?>>> isTrue = p -> p.values().stream().allMatch(predicate -> true);


    public <T> MapSchema shape(Map<String, ? extends BaseSchema<?>> schemas) {
        T input = null;
        //var schema = schemas.values();
        BaseSchema[] f = (BaseSchema[]) schema.toArray();
        BaseSchema r = f[0];
        r.isValid(input);
        Map<String, Map<String, Predicate<?>>> result = schemas.entrySet().stream()
                .collect(Collectors.toMap(key -> key, value -> {
                    List<Collection<? extends BaseSchema<?>>> schema = List.of(schemas.values());

                }))
        Predicate<Map<String, Predicate<?>>> isTrue = p -> p.values().stream().allMatch(predicate -> true);


        return this;
    }

    public <T> boolean isValid(Map<String, ?> input) {
        List<Boolean> resultList = new ArrayList<>();
        Predicate<List> isTrue = e -> !e.contains(Boolean.FALSE);
        boolean result = isTrue.test(resultList);
        List<String> keys = input.keySet().stream().toList();
        for (int i = 0; i < schemas.size(); i++) {
            String key = keys.get(i);
            resultList.add(predicatesMap.values()
                    .stream()
                    .allMatch(e -> e.test((Map<String, ?>) input.get(key))));

        }
        return result;
    }

}
