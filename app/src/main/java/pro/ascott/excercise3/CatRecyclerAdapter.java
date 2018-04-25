package pro.ascott.excercise3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CatRecyclerAdapter extends RecyclerView.Adapter<CatRecyclerAdapter.CatHolder> {

    private final List<Cat> _cats;

    public CatRecyclerAdapter(List<Cat> cats) {
        _cats = cats;
    }


    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cat_item, parent, false);
        return new CatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        Cat cat = _cats.get(position);
        Picasso.get().load(cat.getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return _cats.size();
    }

    static class CatHolder extends RecyclerView.ViewHolder {

        public final ImageView image;

        public CatHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cat_item_image);
        }
    }

}
