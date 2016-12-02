package com.bsz.util;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sunyan on 16/12/1.
 */
public class RxJavaUtil {
    public static void rxJava(){
        //观察者 observer,subscriber
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        };

        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        };


        //被观察者
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1111");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                L.e("哈哈哈："+s);
            }
        });

        Observable.just("hello").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return Integer.valueOf(s);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                L.e("hello:"+integer);
            }
        });

        Observable.just("111").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s+"aaaaaa";
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                L.e("onnext:"+s);
            }
        });
    }
}
