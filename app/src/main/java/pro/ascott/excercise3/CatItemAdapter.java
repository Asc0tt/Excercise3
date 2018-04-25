package pro.ascott.excercise3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CatItemAdapter  extends BaseAdapter{
    private final List<Cat> _list;
    private final LayoutInflater _layoutInflater;

    @Override
    public int getCount() {
        return _list.size();
    }

    @Override
    public Object getItem(int position) {
        return _list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = _layoutInflater.inflate(R.layout.cat_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.cat_item_image);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cat cat = _list.get(position);
        Picasso.get().load(cat.getUrl()).into(holder.imageView);
        return convertView;
    }

    public CatItemAdapter (Context context, List<Cat> list)
    {
        _list = list;
        _layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder{
        public ImageView imageView;
    }
}
