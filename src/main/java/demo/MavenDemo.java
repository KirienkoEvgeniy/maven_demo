package demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MavenDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Number> result = objectMapper.readValue(MavenDemo.class.getResourceAsStream("test1.json"), HashMap.class);
        result.entrySet().forEach(System.out::println);
        System.out.println();

        double sum = result.values().stream().mapToDouble(Number::doubleValue).sum();
        System.out.println("Sum -> " + sum);

        int uniqueValue = result.keySet().stream().collect(Collectors.toList()).size();
        System.out.println("Unique value -> " + uniqueValue);
        System.out.println();

        Map<String, Number> collect = result.entrySet().stream().collect(Collectors.toMap(p -> p.getKey(),
                t -> (t.getValue().doubleValue()*sum)));
        collect.entrySet().forEach(System.out::println);
        System.out.println();

        Map result2 = objectMapper.readValue(MavenDemo.class.getResourceAsStream("test2.json"), HashMap.class);
        result2.entrySet().forEach(System.out::println);
    }
}
