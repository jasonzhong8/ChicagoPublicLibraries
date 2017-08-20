package com.jasonzhong.chicagopubliclibraries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jasonzhong.chicagopubliclibraries.R;
import com.jasonzhong.chicagopubliclibraries.model.Library;

import java.util.List;

/**
 * Created by junzhong on 2017-08-20.
 */

public class LibraryAdapter extends BaseAdapter {

    private Context context;
    private List<Library> libraryList;
    private static LayoutInflater inflater = null;

    static class ViewHolderItem {
        TextView name_textview;
    }

    public LibraryAdapter(Context context, List<Library> libraryList) {
        this.context = context;
        this.libraryList = libraryList;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.library_list_item, parent, false);

            viewHolder = new ViewHolderItem();
            viewHolder.name_textview = (TextView) convertView.findViewById(R.id.name_textview);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        final Library library = libraryList.get(position);
        viewHolder.name_textview.setText(library.getName_());

        return convertView;
    }

    public int getCount() {
        if (libraryList.size() <= 0)
            return 1;
        return libraryList.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
}

