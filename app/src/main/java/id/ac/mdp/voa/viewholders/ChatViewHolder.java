package id.ac.mdp.voa.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.mdp.voa.utils.ItemClickListener;
import id.ac.mdp.voa.R;

/**
 * Created by Tengku Kevin on 3/31/2017.
 */

public class ChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView ivChatUserProfile;
    public TextView tvChatUserName;
    public TextView tvChatText;
    public TextView tvChatTime;
    private ItemClickListener itemClickListener;

    public ChatViewHolder(View itemView){
        super(itemView);

        ivChatUserProfile = (ImageView)itemView.findViewById(R.id.img_cardview_chat_usr_profile);
        tvChatUserName = (TextView)itemView.findViewById(R.id.tv_cardview_chat_username);
        tvChatText = (TextView)itemView.findViewById(R.id.tv_cardview_chat_address);
        tvChatTime = (TextView)itemView.findViewById(R.id.tv_cardview_chat_time);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

