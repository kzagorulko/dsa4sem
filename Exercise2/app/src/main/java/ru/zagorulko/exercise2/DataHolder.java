package ru.zagorulko.exercise2;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private final List<Data> storage;

    private static final DataHolder holder = new DataHolder();

    public static class Data {
        public final String name;
        final String graphic;
        final String helptext;
        Bitmap graphicBitmap;
        static Bitmap graphicBitmapError;
        boolean requested;

        public Data(String name, String graphic, String helptext) {
            this.name = name;
            this.graphic = graphic;
            this.helptext = helptext;

            graphicBitmap = null;
            requested = false;
        }
    }

    private DataHolder() {
        storage = new ArrayList<>();
    }

    Data getData(int index) {
        return storage.get(index);
    }

    int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public void addData(Data data) {
        storage.add(data);
    }

    static DataHolder getInstance() {
        return holder;
    }
}