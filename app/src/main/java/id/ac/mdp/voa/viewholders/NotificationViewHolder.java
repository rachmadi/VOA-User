package id.ac.mdp.voa.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.mdp.voa.utils.ItemClickListener;
import id.ac.mdp.voa.R;

/**
 * Created by Tengku Kevin on 4/21/2017.
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivNotificationImage;
    public TextView tvNotificationTitle;
    public TextView tvNotificationDesc;
    TextView tvNotificationTime;
    public TextView tvRating;
    private ItemClickListener itemClickListener;

    public NotificationViewHolder(View itemView){
        super(itemView);

        ivNotificationImage = (ImageView)itemView.findViewById(R.id.img_cardview_notification);
        tvNotificationTitle = (TextView)itemView.findViewById(R.id.tv_cardview_notification_title);
        tvNotificationDesc = (TextView)itemView.findViewById(R.id.tv_cardview_notification_desc);
        tvNotificationTime = (TextView)itemView.findViewById(R.id.tv_cardview_notification_time);
        tvRating = (TextView)itemView.findViewById(R.id.rating);

        //itemView.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View view) {
//        this.itemClickListener.onItemClick(view, getLayoutPosition());
//    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
