package tads.eaj.com.projetotubarao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tads.eaj.com.projetotubarao.view.fragments.Fragment_Consulta;
import tads.eaj.com.projetotubarao.view.fragments.Fragment_List_Usuario;

/**
 * Created by VILA on 10/05/2016.
 */
public class TabsAdapter extends FragmentPagerAdapter {
    public TabsAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int idx) {
        if (idx == 0) {
            return new Fragment_Consulta();
        } else {
            return new Fragment_List_Usuario();
        }
    }
}
