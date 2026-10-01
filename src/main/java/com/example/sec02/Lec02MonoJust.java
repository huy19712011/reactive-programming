package com.example.sec02;

import com.example.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("vins");
        //System.out.println(mono);
        SubscriberImpl subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10);
        // adding these will have no effect as producer already sent complete
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();

    }
}
