package huangshun.it.com.androiddesignpattern.test.IPC.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import huangshun.it.com.androiddesignpattern.R;

public class AidlAccountActivity extends AppCompatActivity {
    private static final String TAG = "AidlAccountActivity";

    private boolean mFlagBind = false;
    private List<Account> mAccountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_account);
    }

    public void addAccountIn(View view) {
        if (!mFlagBind) {
            Intent intent = new Intent(this, AidlAccountService.class);
            intent.setAction("com.itdashun.aidl");
            bindService(intent, conn, BIND_AUTO_CREATE);
            return;
        }

        Account account = new Account();
        account.setName("黄铜In");
        account.setId(119);
        try {
            Account returnAccount = mIAccountManager.addAccountIn(account);
            Log.i(TAG, "In    : " + returnAccount.toString() + "====account:" + account.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    private IAccountManager mIAccountManager;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIAccountManager = IAccountManager.Stub.asInterface(service);
            mFlagBind = true;
            if (mIAccountManager != null) {
                try {
                    mAccountList = mIAccountManager.getAccountList();
//                    Log.i(TAG, "LIST:" + mAccountList.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "断开连接");
        }
    };

    public void addAccountOut(View view) {
        if (!mFlagBind) {
            Intent intent = new Intent(this, AidlAccountService.class);
            intent.setAction("com.itdashun.aidl");
            bindService(intent, conn, BIND_AUTO_CREATE);
            return;
        }

        Account account = new Account();
        account.setName("黄铜Out");
        account.setId(119);
        try {
            Account returnAccount = mIAccountManager.addAccountOut(account);
            Log.i(TAG, "Out    : " + returnAccount.toString() + "====account:" + account.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addAccountInOut(View view) {
        if (!mFlagBind) {
            Intent intent = new Intent(this, AidlAccountService.class);
            intent.setAction("com.itdashun.aidl");
            bindService(intent, conn, BIND_AUTO_CREATE);
            return;
        }

        Account account = new Account();
        account.setName("黄铜InOut");
        account.setId(119);
        try {
            Account returnAccount = mIAccountManager.addAccountIntOut(account);
            Log.i(TAG, "InOut    : " + returnAccount.toString() + "====account:" + account.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
