package com.example.sec05;

import com.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    /*
    Handle behaves like filter + map

    1 => -2
    4 => do not send
    7 => error
    everything else => send as it is
    */

    public static void main(String[] args) {

        Flux.range(1, 10)
                .filter(i -> i != 7)
                .handle((item, sink) -> {
                    switch (item) {
                        case 1 ->
                                sink.next(-2);
                        case 4 -> {
                        }
                        case 7 ->
                                sink.error(new RuntimeException("oops"));
                        default ->
                                sink.next(item);
                    }
                })
                .cast(Integer.class)
                .subscribe(Util.subscriber());
    }
}
