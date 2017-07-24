package huangshun.it.com.androiddesignpattern.rxjava.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Callable;

import huangshun.it.com.androiddesignpattern.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RxJavaActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaActivity";

    private Observable<String> mObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                mObservable = getObservable();
//                Observer observer = getObserver();
//                mObservable.subscribe(observer);
//                test1();
//
//                getObservableA().subscribe(observer);
            }
        });
    }

    public Observable<String> getObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("大保健");
                e.onNext("洗刷刷");
                e.onComplete();
            }
        });
    }

    public Observable<String> getObservableA() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "哈喽哇";
            }
        });
    }

    public Observer getObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe() called with " + "d = [" + d + "]");
            }

            @Override
            public void onNext(String o) {
                Log.d(TAG, "onNext() called with " + "o = [" + o + "]");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() called with " + "e = [" + e + "]");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete() called with " + "");
            }
        };
    }

    public void test1() {
        mObservable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept() called with " + "s = [" + s + "]");

            }
        });
    }

    public void test2() {
        Observable<Integer> observable = Observable.just(1);
        Observable<String> stringObservable = observable.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer + "";
            }
        });
        stringObservable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
    }
}
