package ru.zagorulko.exercise1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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

        ImageView img = view.findViewById(R.id.img);
        TextView  txt = view.findViewById(R.id.number);

        Integer num = nums[position];

        // here build a list_item
        // osel - a name of the picture
        img.setImageResource(R.drawable.osel);
        txt.setText(this.buildNumber(num));
        view.setBackgroundColor(position % 2 == 0 ? 0x999999 : 0xFFFFFFFF);

        return view;

    }

    private String buildNumber(int n) {
        String result = getMillion(n / 1000000) + getHundredThousand(n / 1000 % 1000) +
                getHundred(n % 1000, false);

        return result.trim().substring(0, 1).toUpperCase() + result.substring(2);
    }

    private String getMillion(int n) {
        return (n > 0 ? " один миллион" : "");
    }

    private String getHundredThousand(int n) {
        String hundred = getHundred(n, true);
        switch (n % 10) {
            case 1: return hundred + " тысяча";
            case 2:
            case 3:
            case 4: return hundred + " тысячи";
            default: return (n == 0 ? "" : hundred + " тысяч");
        }
    }

    private String getHundred(int n, boolean thousand) {
        String decade = getDecade(n % 100, thousand);
        String hundred;
        switch (n / 100) {
            case 1: hundred = " сто"; break;
            case 2: hundred = " двести"; break;
            case 3: hundred = " триста"; break;
            case 4: hundred = " четыреста"; break;
            case 5: hundred = " пятьсот"; break;
            case 6: hundred = " шестьсот"; break;
            case 7: hundred = " семьсот"; break;
            case 8: hundred = " восемьсто"; break;
            case 9: hundred = " девятьсот"; break;
            default: hundred = "";
        }

        return hundred + decade;
    }

    private String getUnit(int n, boolean thousand) {
        switch (n) {
            case 1: return (thousand ? " одна" : " один");
            case 2: return (thousand ? " две" : " два");
            case 3: return " три";
            case 4: return " четыре";
            case 5: return " пять";
            case 6: return " шесть";
            case 7: return " семь";
            case 8: return " восемь";
            case 9: return " девять";
        }
        return "";
    }

    private  String getDecade(int n, boolean thousand) {
        String unit = getUnit(n % 10, thousand);
        switch (n / 10) {
            case 1: {
                switch (n % 10) {
                    case 0: return " десять";
                    case 1: return " одиннадцать";
                    case 2: return " девнадцать";
                    case 3: return " тринадцать";
                    case 4: return " четырьнадцать";
                    case 5: return " пятнадцать";
                    case 6: return " шестьнадцать";
                    case 7: return " семнадцать";
                    case 8: return " восемнадцать";
                    case 9: return " девятнадцать";
                }
            }
            case 2: return " двадцать" + unit;
            case 3: return " тридцать" + unit;
            case 4: return " сорок" + unit;
            case 5: return " пятьдесят" + unit;
            case 6: return " шестьдесят" + unit;
            case 7: return " семьдесят" + unit;
            case 8: return " восемьдесят" + unit;
            case 9: return " девяносто" + unit;
            default: return getUnit(n % 10, thousand);
        }
    }
}
