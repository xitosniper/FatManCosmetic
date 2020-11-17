package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.CommentInfo;
import com.example.fatmancosmetic.Info.CustomerInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.CustomerModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    ArrayList<CommentInfo> commentLocations;
    Context context;
    FragmentManager fragmentManager;
    CustomerModel customerModel;
    String customerID = "000001";


    public CommentAdapter(ArrayList<CommentInfo> commentLocations, Context context, FragmentManager fragmentManager) {
        this.commentLocations = commentLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public CommentAdapter.CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_card_design, parent, false);
        CommentHolder commentHolder = new CommentHolder(view);
        return commentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentHolder holder, int position) {
        try {
            CommentInfo commentInfo = commentLocations.get(position);
            customerModel = new CustomerModel(context);

            //Log.e("Count", commentLocations.size()+"");

            ArrayList<CustomerInfo> customerInfos = customerModel.getCustomerByCustomerID(commentInfo.getCustomerID());
            Bitmap bmp = BitmapFactory.decodeByteArray(customerInfos.get(0).getImage(), 0, customerInfos.get(0).getImage().length);
            holder.avatar.setImageBitmap(bmp);
            holder.customerName.setText(customerInfos.get(0).getName());
            holder.commentContent.setText(commentInfo.getContent());
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return commentLocations.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView customerName, commentContent;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.customer_avatar);
            customerName = itemView.findViewById(R.id.customer_name);
            commentContent = itemView.findViewById(R.id.comment_content);
        }
    }
}
