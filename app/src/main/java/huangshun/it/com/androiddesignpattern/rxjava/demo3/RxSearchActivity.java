package huangshun.it.com.androiddesignpattern.rxjava.demo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;


public class RxSearchActivity extends AppCompatActivity {
    @BindView(R.id.et_search)
    EditText mEtSearch;
    private static final String TAG = "RxSearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_search);
        ButterKnife.bind(this);
//        RxTextView.textChanges(mEtSearch)
//                .debounce(200, TimeUnit.MILLISECONDS)
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .filter(new Predicate<CharSequence>() {
//                    @Override
//                    public boolean test(CharSequence charSequence) throws Exception {
//                        return charSequence.toString().trim().length() > 0;
//                    }
//                })
//                .flatMap(new Function<CharSequence, ObservableSource<List<String>>>() {
//                    @Override
//                    public ObservableSource<List<String>> apply(CharSequence charSequence) throws Exception {
//                        Log.d(TAG, "apply() called with " + "charSequence = [" + charSequence + "]");
//                        List<String> list = new ArrayList<>();
//                        list.add("abc");
//                        list.add("adb");
//                        return Observable.just(list);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<String>>() {
//                    @Override
//                    public void accept(List<String> strings) throws Exception {
//                        Log.d(TAG, "accept() called with " + "strings = [" + strings + "]");
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                });
    }
}
