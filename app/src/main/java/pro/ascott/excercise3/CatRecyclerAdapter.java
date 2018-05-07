package pro.ascott.excercise3;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatRecyclerAdapter extends RecyclerView.Adapter<CatRecyclerAdapter.CatHolder> {

    @NonNull
    private final List<Cat> _cats;
    @NonNull
    private final List<MediaPlayer> _players;
    @NonNull
    Random _rnd;

    public CatRecyclerAdapter(@NonNull Context context,
                              @NonNull List<Cat> cats) {
        _cats = cats;
        _players = new ArrayList<>();

        int[] meowSoundIds = new int[4];
        meowSoundIds[0] = R.raw.meow1;
        meowSoundIds[1] = R.raw.meow2;
        meowSoundIds[2] = R.raw.meow3;
        meowSoundIds[3] = R.raw.meow4;

        for (int id : meowSoundIds) {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, id);
            _players.add(mediaPlayer);
        }

        _rnd = new Random();
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
        holder.image.setOnClickListener(internalClickListener);
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

    @NonNull
    private final View.OnClickListener internalClickListener = new View.OnClickListener() {

        @Override
        public void onClick(@NonNull View view) {
            int num = _rnd.nextInt(4);
            _players.get(num).start();
        }
    };
}
