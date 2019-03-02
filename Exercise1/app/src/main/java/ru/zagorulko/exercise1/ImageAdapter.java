package ru.zagorulko.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<Integer> {
    private Integer[] nums;
    private int layout;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, int resource , Integer[] nums) {
        super(context, resource, nums);
        this.nums = nums;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Function return a list_item with imageView and textView
        // The image only one, so it load right here
        View view = inflater.inflate(this.layout, parent, false);

        ImageView img = (ImageView)view.findViewById(R.id.img);
        TextView  txt = (TextView)view.findViewById(R.id.number);

        Integer num = nums[position];

        // here build a list_item
        // osel - a name of picture
        img.setImageResource(R.drawable.osel);
        txt.setText(num.toString());

        return view;

    }
}
