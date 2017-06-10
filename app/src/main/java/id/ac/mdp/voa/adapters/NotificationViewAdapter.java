package id.ac.mdp.voa.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.activities.RatingActivity;
import id.ac.mdp.voa.viewholders.NotificationViewHolder;

/**
 * Created by Tengku Kevin on 4/21/2017.
 */

public class NotificationViewAdapter extends RecyclerView.Adapter<NotificationViewHolder>{

    private Context context;
    private String[] title, description, time;
    private int[] image;

    public NotificationViewAdapter(Context context, String[] username, String[] address, String[] time, int[] profileImage){
        this.context = context;
        this.title = username;
        this.description = address;
        this.time = time;
        this.image = profileImage;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, null);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NotificationViewHolder holder, final int position) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_notification, null);

        holder.tvNotificationTitle.setText(title[position]);
        holder.tvNotificationDesc.setText(description[position]);
        //Glide.clear(holder.ivUserProfile);
        Glide.with(context)
                .load(image[position])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivNotificationImage);

        holder.tvRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Dialog rankDialog;
                RatingBar ratingBar;
                rankDialog = new Dialog(context, R.style.FullHeightDialog);
                rankDialog.setContentView(R.layout.dialog_review);
                rankDialog.setCancelable(true);
                ratingBar = (RatingBar)rankDialog.findViewById(R.id.dialog_ratingbar);
                Drawable progress = ratingBar.getProgressDrawable();
                DrawableCompat.setTint(progress, v.getResources().getColor(R.color.colorPrimary));
                text.setText(name);



                Button updateButton = (Button) rankDialog.findViewById(R.id.rank_dialog_button);
                rankDialog.show();*/
                Intent intent = new Intent(context, RatingActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}