package ru.zagorulko.exercise2;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class TechPagerAdapter extends FragmentStatePagerAdapter {
    TechPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (!(object instanceof PageFragment))
            return super.getItemPosition(object);

        PageFragment pageFragment = (PageFragment) object;

        DataHolder.Data data = DataHolder.getInstance().getData(pageFragment.getTechNumber());

        if (data.graphicBitmap != null && pageFragment.hasProgressBar()) {
            return POSITION_NONE;
        }

        return POSITION_UNCHANGED;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        try{
            super.restoreState(state, loader);
        }catch (NullPointerException | IllegalStateException ignored){
        }
    }

    @Override
    public int getCount() {
        DataHolder dataHolder = DataHolder.getInstance();

        return dataHolder.size();
    }
}
