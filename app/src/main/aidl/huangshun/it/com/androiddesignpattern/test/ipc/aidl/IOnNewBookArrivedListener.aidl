// IOnNewBookArrivedListener.aidl
package huangshun.it.com.androiddesignpattern.test.IPC.aidl;
import huangshun.it.com.androiddesignpattern.test.IPC.aidl.Book;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book book);
}
