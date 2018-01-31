// IAccountManager.aidl
package huangshun.it.com.androiddesignpattern.test.IPC.aidl;
// Declare any non-default types here with import statements
import huangshun.it.com.androiddesignpattern.test.IPC.aidl.Account;
interface IAccountManager {

    List<Account> getAccountList();
    Account addAccountIn(in Account account);
    Account addAccountOut(out Account account);
    Account addAccountIntOut(inout Account account);

}
