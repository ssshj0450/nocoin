package com.example.user.a0911_2;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CustomListFragment extends ListFragment {
    ListViewAdapter adapter ;

    public interface OnTitleSelectedListener {
        public void onTitleSelected(int position) ;
    }

    OnTitleSelectedListener titleSelectedListener;

    public void showDetails(int position) {
        titleSelectedListener.onTitleSelected(position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof Activity) {
                titleSelectedListener = (OnTitleSelectedListener) context;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnTitleSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Adapter 생성 및 Adapter 지정.
        adapter = new ListViewAdapter() ;
        setListAdapter(adapter) ;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        ListViewItem item = (ListViewItem) l.getItemAtPosition(position) ;
        showDetails(position);

        String titleStr = item.getTitle() ;
        Drawable iconDrawable = item.getIcon() ;

        // TODO : use item data.
    }

    public void addItem(Drawable icon, String title) {
        adapter.addItem(icon, title) ;
    }


}


