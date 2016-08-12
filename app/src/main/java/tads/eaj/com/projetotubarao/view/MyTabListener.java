package tads.eaj.com.projetotubarao.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by VILA on 10/05/2016.
 */
public class MyTabListener implements ActionBar.TabListener {
    private ViewPager viewPager;
    private int idx;

    public MyTabListener(ViewPager viewPager, int idx) {
        this.viewPager = viewPager;
        this.idx = idx;
    }

    @
            Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
// Navega para a página desejada do ViewPager
        viewPager.setCurrentItem(idx);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
