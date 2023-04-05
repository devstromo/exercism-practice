import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {

    public List<Object> flatten(List<?> two) {
        return flattenList(two).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <T> Stream<T> flattenList(List<?> nestedList) {
        return nestedList.stream().flatMap(new FlatMapper<>());
    }

    private static class FlatMapper<T> implements Function<Object, Stream<T>> {
        @SuppressWarnings("unchecked")
        @Override
        public Stream<T> apply(Object input) {
            if (input instanceof List) {
                return flattenList((List<Object>) input);
            } else {
                return Stream.of((T) input);
            }
        }
    }
}
