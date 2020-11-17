package com.example.fatmancosmetic.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fatmancosmetic.Adapter.CommentAdapter;
import com.example.fatmancosmetic.Adapter.ItemsAdapter;
import com.example.fatmancosmetic.Adapter.ItemsDetailsAdapter;
import com.example.fatmancosmetic.Info.CommentInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.CommentModel;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView backBtn, cartBtn;
    RecyclerView item_recyclerView, comment_recyclerView;
    RecyclerView.Adapter item_adapter, comment_adapter;
    private String page;
    private String itemID, customerID;
    private Button button_addComment;
    private EditText edit_comment;

    public ItemDetails(String page) {
        // Required empty public constructor
        this.page = page;
    }

    //    public ItemDetails(String page, String itemID, String customerID) {
//        // Required empty public constructor
//        this.page = page;
//        this.itemID = itemID;
//        this.customerID = customerID;
//    }
    public ItemDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemDetails newInstance(String param1, String param2) {
        ItemDetails fragment = new ItemDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);
        try {
            //Hooks
            item_recyclerView = view.findViewById(R.id.itemDetails_recyclerView);
            comment_recyclerView = view.findViewById(R.id.comment_recyclerView);
            edit_comment = view.findViewById(R.id.edit_comment);

            backBtn = view.findViewById(R.id.back_pressed);
            button_addComment = view.findViewById(R.id.button_addComment);
            //Get Arguments from ItemAdapter
//        if (itemID!=""){
//            itemID = getArguments().getString("itemID");
//        }
//        if (customerID!=null){
//            customerID = getArguments().getString("customerID");
//        }
            itemID = getArguments().getString("itemID");
            customerID = getArguments().getString("customerID");
            //cartBtn = view.findViewById(R.id.cart_pressed);

            //Recycle View Function Calls
            item_recyclerView();
            comment_recyclerView();

            //Set handle
            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager manager = getFragmentManager();
                    switch (page) {
                        case "BestSellerItems":
                            BestSellerItems bestSellerItems = new BestSellerItems();
                            manager.beginTransaction().replace(R.id.fragment, bestSellerItems, bestSellerItems.getTag()).commit();
                            break;
                        case "CategoryBodyCare":
                            CategoryBodyCare categoryBodyCare = new CategoryBodyCare();
                            manager.beginTransaction().replace(R.id.fragment, categoryBodyCare, categoryBodyCare.getTag()).commit();
                            break;
                        case "CategorySkinCare":
                            CategorySkinCare categorySkinCare = new CategorySkinCare();
                            manager.beginTransaction().replace(R.id.fragment, categorySkinCare, categorySkinCare.getTag()).commit();
                            break;
                        case "CategoryMakeUp":
                            CategoryMakeUp categoryMakeUp = new CategoryMakeUp();
                            manager.beginTransaction().replace(R.id.fragment, categoryMakeUp, categoryMakeUp.getTag()).commit();
                            break;
                        case "FlashSaleItems":
                            FlashSaleItems flashSaleItems = new FlashSaleItems();
                            manager.beginTransaction().replace(R.id.fragment, flashSaleItems, flashSaleItems.getTag()).commit();
                            break;
                        case "Home":
                            Home home = new Home();
                            manager.beginTransaction().replace(R.id.fragment, home, home.getTag()).commit();
                            break;
                        case "NewItems":
                            NewItems newItems = new NewItems();
                            manager.beginTransaction().replace(R.id.fragment, newItems, newItems.getTag()).commit();
                            break;
                        case "ShoppingCart":
                            ShoppingCart shoppingCart = new ShoppingCart();
                            manager.beginTransaction().replace(R.id.fragment, shoppingCart, shoppingCart.getTag()).commit();
                            break;
                        default:
                            Home home1 = new Home();
                            manager.beginTransaction().replace(R.id.fragment, home1, home1.getTag()).commit();
                    }
                }
            });
//        cartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ShoppingCart shoppingCart = new ShoppingCart(page);
//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.fragment, shoppingCart, shoppingCart.getTag()).commit();
//            }
//        });

            button_addComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommentModel commentModel = new CommentModel(getContext());
                    ArrayList<CommentInfo> listComments = commentModel.getAllComments();

                    //Get commentID
                    String commentID;

                    int checkCommentID = 0;
                    if (listComments.size() > 0) {
                        checkCommentID = listComments.get(listComments.size() - 1).getID();
                    } else {
                        checkCommentID = 0;
                    }

                    if (checkCommentID < 9) {
                        commentID = "00000" + (checkCommentID + 1);
                    } else if (checkCommentID < 99) {
                        commentID = "0000" + (checkCommentID + 1);
                    } else if (checkCommentID < 999) {
                        commentID = "000" + (checkCommentID + 1);
                    } else if (checkCommentID < 9999) {
                        commentID = "00" + (checkCommentID + 1);
                    } else if (checkCommentID < 99999) {
                        commentID = "0" + (checkCommentID + 1);
                    } else {
                        commentID = "" + (checkCommentID + 1);
                    }
                    Date currentTime = Calendar.getInstance().getTime();
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                    String currentDate = fmt.format(currentTime);
                    commentModel.addComment(new CommentInfo(commentID, customerID, itemID, currentDate, edit_comment.getText() + "", 1));

                    comment_recyclerView();
                    edit_comment.setText("");

                }
            });

        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return view;
    }

    private void item_recyclerView() {
        item_recyclerView.setHasFixedSize(true);

        item_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ItemModel itemModel = new ItemModel(getContext());

        ArrayList<ItemInfo> listItems = new ArrayList<>();


        listItems = itemModel.getItemsByItemID(itemID);

        FragmentManager fragmentManager = getFragmentManager();
        item_adapter = new ItemsDetailsAdapter(listItems, getContext(), fragmentManager);
        item_recyclerView.setAdapter(item_adapter);
    }

    private void comment_recyclerView() {
        comment_recyclerView.setHasFixedSize(true);

        comment_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        CommentModel commentModel = new CommentModel(getContext());

        ArrayList<CommentInfo> listComments = new ArrayList<>();
        listComments = commentModel.getAllCommentByItemID(itemID);

//        Log.e("comment size", listComments.size()+"");
//        Log.e("itemID", itemID);

        FragmentManager fragmentManager = getFragmentManager();
        comment_adapter = new CommentAdapter(listComments, getContext(), fragmentManager);
        comment_recyclerView.setAdapter(comment_adapter);
    }
}