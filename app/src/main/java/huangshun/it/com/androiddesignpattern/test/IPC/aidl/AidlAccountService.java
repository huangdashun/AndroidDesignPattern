package huangshun.it.com.androiddesignpattern.test.IPC.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AidlAccountService extends Service {
    private static final String TAG = "AidlAccountService";
    private List<Account> mAccountList = new ArrayList<>();

    public AidlAccountService() {
    }

    private IAccountManager.Stub mIAccountManager = new IAccountManager.Stub() {
        @Override
        public List<Account> getAccountList() throws RemoteException {
            return mAccountList;
        }

        @Override
        public Account addAccountIn(Account account) throws RemoteException {
            synchronized (this) {
                if (account == null) {
                    Log.i(TAG, "addAccountIn为null");
                    account = new Account();
                }
                account.setId(000000);
                account.setName("In");
                if (!mAccountList.contains(account)) {
                    mAccountList.add(account);
                }
                Log.i(TAG, "addAccountIn:" + mAccountList.toString());
                return account;
            }
        }

        @Override
        public Account addAccountOut(Account account) throws RemoteException {
            synchronized (this) {
                if (account == null) {
                    Log.i(TAG, "addAccountOut为null");
                    account = new Account();
                }
                account.setId(111111);
                account.setName("Out");
                if (!mAccountList.contains(account)) {
                    mAccountList.add(account);
                }
                Log.i(TAG, "addAccountOut:" + mAccountList.toString());
                return account;
            }
        }

        @Override
        public Account addAccountIntOut(Account account) throws RemoteException {
            synchronized (this) {
                if (account == null) {
                    Log.i(TAG, "addAccountIntOut为null");
                    account = new Account();
                }
                account.setId(222222);
                account.setName("Inout");
                if (!mAccountList.contains(account)) {
                    mAccountList.add(account);
                }
                Log.i(TAG, "addAccountIntOut:" + mAccountList.toString());
                return account;
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Account account = new Account();
        account.setName("黄顺");
        account.setId(120);
        mAccountList.add(account);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mIAccountManager;
    }
}
