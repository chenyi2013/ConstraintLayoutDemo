package ired.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setDividerHeight(0);
        listView.setAdapter(new ConponAdapter());
    }


    static class ViewHolder {
        TopEdgeView topEdgeView;
        TextView price;
        TextView conpon;
        TextView canUsePrice;
        TextView status;
        TextView time;
        View bottomLine;


        void setOverDay(boolean isOverDay) {
            topEdgeView.setOverDay(isOverDay);
            int color = isOverDay ? Color.parseColor("#cccccc") : Color.parseColor("#ff5b73");
            price.setTextColor(color);
            conpon.setTextColor(color);
            status.setTextColor(color);
            bottomLine.setBackgroundColor(color);
        }
    }


    static class ConponAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            if(view == null){
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
            }


            return view;
        }
    }
}
