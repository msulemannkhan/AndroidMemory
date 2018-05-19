package com.example.suleman.androidmemory;

/**
 * Created by suleman on 26/02/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MemoryAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Memory> listStorage;

    public MemoryAdapter(Context context, List<Memory> customizedListView) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.memory_list, parent, false);

            listViewHolder.heading = (TextView)convertView.findViewById(R.id.memory_title);
            listViewHolder.usedSpace = (TextView)convertView.findViewById(R.id.used_space);
            listViewHolder.freeSpace = (TextView)convertView.findViewById(R.id.free_space);
            listViewHolder.totalSpace = (TextView)convertView.findViewById(R.id.total_space);
            listViewHolder.imageIcon = (ImageView)convertView.findViewById(R.id.pie_image);

            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.heading.setText(listStorage.get(position).getTitle());
        listViewHolder.usedSpace.setText(listStorage.get(position).getUsedSpace());
        listViewHolder.freeSpace.setText(listStorage.get(position).getFreeSpace());
        listViewHolder.totalSpace.setText(listStorage.get(position).getTotalSpace());
        listViewHolder.imageIcon.setImageResource(listStorage.get(position).getImage());

        return convertView;
    }

    static class ViewHolder{

        TextView heading;
        TextView usedSpace;
        TextView freeSpace;
        TextView totalSpace;
        ImageView imageIcon;
    }
}