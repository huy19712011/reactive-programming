package com.example.sec02;

import com.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    public static void main(String[] args) {

        //getUsername(3).subscribe(Util.subscriber());

        getUsername(3).subscribe(
                s -> System.out.println(s),
                err -> {}
        );

    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 ->
                    Mono.just("sam");
            case 2 ->
                    Mono.empty(); // null
            default ->
                    Mono.error(new RuntimeException("invalid input"));
        };
    }
}
