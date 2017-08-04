package huangshun.it.com.androiddesignpattern.rxjava.demo4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;

public class RxPicActivity extends AppCompatActivity {
    @BindView(R.id.btn_rx_pic)
    Button mBtnPic;
    private static final String TAG = "RxSearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_pic);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
//        //内存缓存
//        final Observable<String> memoryObservable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("memory");
////                e.onNext(null);
//                e.onComplete();
//            }
//        });
//        //disk缓存
//        final Observable<String> diskObservable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("disk");
//                e.onComplete();
//            }
//        });
//        //network缓存
//        final Observable<String> networkObservable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("network");
//                e.onComplete();
//            }
//        });
//
//
//        RxView.clicks(mBtnPic)
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) throws Exception {
//                        Observable.concat(memoryObservable, diskObservable, networkObservable)
//                                .filter(new Predicate<String>() {
//                                    @Override
//                                    public boolean test(String s) throws Exception {
//                                        return s.equals("disk");
//                                    }
//                                })
//                                .subscribe(new Consumer<String>() {
//                                    @Override
//                                    public void accept(String s) throws Exception {
//                                        Log.d(TAG, "accept() called with " + "s = [" + s + "]");
//                                    }
//                                })
//                        ;
//                    }
//                });
    }

}
