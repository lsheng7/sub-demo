package com.example.subdemo.arthas;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;

public class Arthas {

    public static final String userName = "userName";

    public List<String> method() {
        return Arrays.asList("a", "b");
    }
}
