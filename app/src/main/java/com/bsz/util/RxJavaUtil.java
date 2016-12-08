package com.bsz.util;

import android.widget.Toast;

import com.bsz.entity.UserInfo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sunyan on 16/12/1.
 */
public class RxJavaUtil {
    public static void rxjava1() {
        //1.创建消费者：Observer/Subscriber
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

        Observer observer1 = new Observer<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

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

        //...同Observer

        //2.创建被观察者 Observable
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("sunyan");
                subscriber.onCompleted();
                //这句执行 观察者会回调相应的onNext(),onCompleted()方法，这样，数据就传递给了观察者
                //但并不是Observable.create()这里已完成就会走回调，而是要等订阅后才会走。
            }
        });

        String[] strs = {"sunyan", "xuwei"};
        Observable observable1 = Observable.from(strs);

        Observable observable2 = Observable.just("sunyan", "xuwei");

        //3.观察者 订阅(subscibe) 被观察者，建立消费事件
        //3-1 直接绑定observer
        observable.subscribe(observer1);

        //3-2 绑定Action
        Action1 action1 = new Action1<String>() {

            @Override
            public void call(String s) {

            }
        };
        //observable.subcribe(Action1 act1 ...);参数分别会回调给observer.onnext(),onError(),onCompleted()
        observable.subscribe(action1);
        observable1.subscribe(action1);
        observable2.subscribe(action1);
    }


    public static void rxJava2() {

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("rxjava2");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                L.e(s);//输出：rxjava2
            }
        });

        Observable.just("111", "222").subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                L.e(s);//输出：111 222
            }
        });


        String[] strs = {"333", "444"};
        Observable.from(strs).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                L.e(s);
            }
        });
    }

    public static void rxJava3() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("你好啊");
            }
        }).subscribeOn(Schedulers.io())//指定订阅过程subscribe()发生在IO线程
                .observeOn(AndroidSchedulers.mainThread())//指定事件回调发生在主线程
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(UIUtils.getContext(), s, Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void rxJava4() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("123");
            }
        }).map(new Func1<String, UserInfo>() {
            @Override
            public UserInfo call(String s) {
                UserInfo info = new UserInfo();
                info.setName(s + "111");
                return info;
            }
        }).subscribe(new Action1<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                L.e(userInfo.getName());
            }
        });
    }

//    public static void rxjava5() {
//        List<UserInfo> infos = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            UserInfo info = new UserInfo();
//            info.setName("sunyan" + i);
//            info.setAge(18 + i);
//            info.setCourse(new String[]{"语文" + i, "数学" + i});
//            infos.add(info);
//        }
//
//        Observable.from(infos).flatMap(new Func1<UserInfo, Observable<String[]>>() {
//            @Override
//            public Observable<String[]> call(UserInfo userInfo) {
//                return (Observable<String[]>) Observable.from(userInfo.getCourse());
//            }
//        }).subscribe(new Action1<String[]>() {
//            @Override
//            public void call(String[] strings) {
//
//            }
//        });
//
//    }
}
