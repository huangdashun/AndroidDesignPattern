package huangshun.it.com.androiddesignpattern.play.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.iconics.context.IconicsLayoutInflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;
import huangshun.it.com.androiddesignpattern.play.ui.adapter.ViewPagerAdapter;

public class PlayMainActivity extends AppCompatActivity {

    private static final String TAG = "PlayMainActivity";
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private View mHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));//iconics
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_main);
        ButterKnife.bind(this);
        initDrawerLayout();

        initTabLayout();
    }

    private void initTabLayout() {
        ViewPagerAdapter viewpagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mViewpager.setAdapter(viewpagerAdapter);

        mTabLayout.setupWithViewPager(mViewpager);

    }

    private void initDrawerLayout() {
//        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                Log.d(TAG, "onDrawerSlide() called with " + "drawerView = [], slideOffset = [" + slideOffset + "]");
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                Log.d(TAG, "onDrawerOpened() called with " + "drawerView ");
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                Log.d(TAG, "onDrawerClosed() called with " + "drawerView ");
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//                Log.d(TAG, "onDrawerStateChanged() called with " + "newState ");
//            }
//        });
        mHeaderView = mNavigationView.getHeaderView(0);
        mHeaderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "headerView", Toast.LENGTH_SHORT).show();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_app_update:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_message:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        mToolBar.inflateMenu(R.menu.toolbar_menu);//给ToolBar设置menu

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();//初始化状态
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

}
