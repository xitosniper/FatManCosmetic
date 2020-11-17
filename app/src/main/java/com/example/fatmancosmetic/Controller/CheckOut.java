package com.example.fatmancosmetic.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.OrderModel;
import com.example.fatmancosmetic.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckOut#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckOut extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Spinner spinnerArrayDistrict, spinnerArrayProvincial;
    private TextInputLayout textinput_name, textinput_phone;
    private EditText getEdit_Name, getEdit_Phone, getGetEdit_Note;
    private Button checkOutBtn;
    private ImageView backBtn;
    private OrderModel orderModel;

    public CheckOut() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckOut.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckOut newInstance(String param1, String param2) {
        CheckOut fragment = new CheckOut();
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
        View view = inflater.inflate(R.layout.fragment_check_out, container, false);
        try {
            //Hooks
            getEdit_Name = view.findViewById(R.id.edit_name);
            getEdit_Phone = view.findViewById(R.id.edit_Phone);
//        getEdit_Address = view.findViewById(R.id.edit_Address);
            getGetEdit_Note = view.findViewById(R.id.edit_note);

            textinput_name = view.findViewById(R.id.textinput_name);
            textinput_phone = view.findViewById(R.id.textinput_phone);
//        textinput_address = view.findViewById(R.id.textinput_address);

            checkOutBtn = view.findViewById(R.id.checkOutBtn);
            backBtn = view.findViewById(R.id.back_pressed);

            spinnerArrayDistrict = view.findViewById(R.id.spinnerArrayDistrict);
            spinnerArrayProvincial = view.findViewById(R.id.spinnerArrayProvincial);


            //Set click listener
            textinput_name.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 0) {
                        textinput_name.setError("Tên không được để trống");
                        textinput_name.setErrorEnabled(true);
                    } else {
                        textinput_name.setErrorEnabled(false);
                    }
                }
            });

            textinput_phone.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 0) {
                        textinput_phone.setError("Số điện thoại không được để trống");
                        textinput_phone.setErrorEnabled(true);
                    } else if (s.length() < 10) {
                        textinput_phone.setError("Vui lòng kiểm tra lại số điện thoại");
                        textinput_phone.setErrorEnabled(true);
                    } else {
                        textinput_phone.setErrorEnabled(false);
                    }
                }
            });

//        textinput_address.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.length() == 0) {
//                    textinput_address.setError("Địa chỉ không được để trống");
//                    textinput_address.setErrorEnabled(true);
//                } else {
//                    textinput_address.setErrorEnabled(false);
//                }
//            }
//        });


            spinnerArrayProvincial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    List<String> list = new ArrayList<String>();

                    switch (spinnerArrayProvincial.getSelectedItemPosition()) {
                        case 1:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Châu Đốc");
                            list.add("Thành phố Long Xuyên");
                            list.add("Thị xã Tân Châu");
                            list.add("Huyện An Phú");
                            list.add("Huyện Châu Phú");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Chợ Mới");
                            list.add("Huyện Phú Tân");
                            list.add("Huyện Thoại Sơn");
                            list.add("Huyện Tịnh Biên");
                            list.add("Huyện Tri Tôn");
                            break;
                        case 2:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Vũng Tàu");
                            list.add("Thị xã Bà Rịa");
                            list.add("Huyện Xuyên Mộc");
                            list.add("Huyện Long Điền");
                            list.add("Huyện Côn Đảo");
                            list.add("Huyện Châu Đức");
                            list.add("Huyện Đất Đỏ");
                            break;
                        case 3:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Bắc Giang");
                            list.add("Huyện Yên Thế");
                            list.add("Huyện Lục Ngạn");
                            list.add("Huyện Sơn Động");
                            list.add("Huyện Lục Nam");
                            list.add("Huyện Tân Yên");
                            list.add("Huyện Hiệp Hoà");
                            list.add("Huyện Lạng Giang");
                            list.add("Huyện Việt Yên");
                            list.add("Huyện Yên Dũng");
                            break;
                        case 4:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Bắc Kạn");
                            list.add("Huyện Chợ Đồn");
                            list.add("Huyện Bạch Thông");
                            list.add("Huyện Na Rì");
                            list.add("Huyện Ngân Sơn");
                            list.add("Huyện Ba Bể");
                            list.add("Huyện Chợ Mới");
                            list.add("Huyện Pác Nặm");
                            break;
                        case 5:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Bạc Liêu");
                            list.add("Huyện Vĩnh Lợi");
                            list.add("Huyện Hồng Dân");
                            list.add("Huyện Giá Rai");
                            list.add("Huyện Phước Long");
                            list.add("Huyện Đông Hải");
                            list.add("Huyện Hoà Bình");
                            break;
                        case 6:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Bắc Ninh");
                            list.add("Huyện Yên Phong");
                            list.add("Huyện Quế Võ");
                            list.add("Huyện Tiên Du");
                            list.add("Huyện Từ Sơn");
                            list.add("Huyện Thuận Thành");
                            list.add("Huyện Gia Bình");
                            list.add("Huyện Lương Tài");
                            break;
                        case 7:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Bến Tre");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Chợ Lách");
                            list.add("Huyện Mỏ Cày");
                            list.add("Huyện Giồng Trôm");
                            list.add("Huyện Bình Đại");
                            list.add("Huyện Ba Tri");
                            list.add("Huyện Thạnh Phú");
                            break;
                        case 8:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Quy Nhơn");
                            list.add("Huyện An Lão");
                            list.add("Huyện Hoài Ân");
                            list.add("Huyện Hoài Nhơn");
                            list.add("Huyện Phù Mỹ");
                            list.add("Huyện Phù Cát");
                            list.add("Huyện Vĩnh Thạnh");
                            list.add("Huyện Tây Sơn");
                            list.add("Huyện Vân Canh");
                            list.add("Huyện An Nhơn");
                            list.add("Huyện Tuy Phước");
                            break;
                        case 9:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Thủ Dầu Một");
                            list.add("Huyện Bến Cát");
                            list.add("Huyện Tân Uyên");
                            list.add("Huyện Thuận An");
                            list.add("Huyện Dĩ An");
                            list.add("Huyện Phú Giáo");
                            list.add("Huyện Dầu Tiếng");
                            break;
                        case 10:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Đồng Xoài");
                            list.add("Huyện Đồng Phú");
                            list.add("Huyện Chơn Thành");
                            list.add("Huyện Bình Long");
                            list.add("Huyện Lộc Ninh");
                            list.add("Huyện Bù Đốp");
                            list.add("Huyện Phước Long");
                            list.add("Huyện Bù Đăng");
                            break;
                        case 11:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Phan Thiết");
                            list.add("Huyện Tuy Phong");
                            list.add("Huyện Bắc Bình");
                            list.add("Huyện Hàm Thuận Bắc");
                            list.add("Huyện Hàm Thuận Nam");
                            list.add("Huyện Hàm Tân");
                            list.add("Huyện Đức Linh");
                            list.add("Huyện Tánh Linh");
                            list.add("Huyện đảo Phú Quý");
                            list.add("Thị xã LaGi");
                            break;
                        case 12:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Cà Mau");
                            list.add("Huyện Thới Bình");
                            list.add("Huyện U Minh");
                            list.add("Huyện Trần Văn Thời");
                            list.add("Huyện Cái Nước");
                            list.add("Huyện Đầm Dơi");
                            list.add("Huyện Ngọc Hiển");
                            list.add("Huyện Năm Căn");
                            list.add("Huyện Phú Tân");
                            break;
                        case 13:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Cao Bằng");
                            list.add("Huyện Bảo Lạc");
                            list.add("Huyện Thông Nông");
                            list.add("Huyện Hà Quảng");
                            list.add("Huyện Trà Lĩnh");
                            list.add("Huyện Trùng Khánh");
                            list.add("Huyện Nguyên Bình");
                            list.add("Huyện Hoà An");
                            list.add("Huyện Quảng Uyên");
                            list.add("Huyện Thạch An");
                            list.add("Huyện Hạ Lang");
                            list.add("Huyện Bảo Lâm");
                            list.add("Huyện Phục Hoà");
                            break;
                        case 14:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Quận Ninh Kiều");
                            list.add("Quận Bình Thuỷ");
                            list.add("Quận Cái Răng");
                            list.add("Quận Ô Môn");
                            list.add("Huyện Phong Điền");
                            list.add("Huyện Cờ Đỏ");
                            list.add("Huyện Vĩnh Thạnh");
                            list.add("Huyện Thốt Nốt");
                            break;
                        case 15:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Quận Hải Châu");
                            list.add("Quận Thanh Khê");
                            list.add("Quận Sơn Trà");
                            list.add("Quận Ngũ Hành Sơn");
                            list.add("Quận Liên Chiểu");
                            list.add("Huyện Hoà Vang");
                            list.add("Quận Cẩm Lệ");
                            break;
                        case 16:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Buôn Ma Thuột");
                            list.add("Huyện Ea H Leo");
                            list.add("Huyện Krông Buk");
                            list.add("Huyện Krông Năng");
                            list.add("Huyện Ea Súp");
                            list.add("Huyện Cư M gar");
                            list.add("Huyện Krông Pắc");
                            list.add("Huyện Ea Kar");
                            list.add("Huyện M`Đrăk");
                            list.add("Huyện Krông Ana");
                            list.add("Huyện Krông Bông");
                            list.add("Huyện Lăk");
                            list.add("Huyện Buôn Đôn");
                            list.add("Huyện Cư Kuin");
                            break;
                        case 17:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Gia Nghĩa");
                            list.add("Huyện Dăk RLấp");
                            list.add("Huyện Dăk Mil");
                            list.add("Huyện Cư Jút");
                            list.add("Huyện Dăk Song");
                            list.add("Huyện Krông Nô");
                            list.add("Huyện Dăk GLong");
                            list.add("Huyện Tuy Đức");
                            break;
                        case 18:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("TP. Điện Biên Phủ");
                            list.add("Thị xã Mường Lay");
                            list.add("Huyện Điện Biên");
                            list.add("Huyện Tuần Giáo");
                            list.add("Huyện Mường Chà");
                            list.add("Huyện Tủa Chùa");
                            list.add("Huyện Điện Biên Đông");
                            list.add("Huyện Mường Nhé");
                            list.add("Huyện Mường Ảng");
                            break;
                        case 19:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Biên Hoà");
                            list.add("Huyện Vĩnh Cửu");
                            list.add("Huyện Tân Phú");
                            list.add("Huyện Định Quán");
                            list.add("Huyện Thống Nhất");
                            list.add("Thị xã Long Khánh");
                            list.add("Huyện Xuân Lộc");
                            list.add("Huyện Long Thành");
                            list.add("Huyện Nhơn Trạch");
                            list.add("Huyện Trảng Bom");
                            list.add("Huyện Cẩm Mỹ");
                            break;
                        case 20:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Cao Lãnh");
                            list.add("Thị xã Sa Đéc");
                            list.add("Huyện Tân Hồng");
                            list.add("Huyện Hồng Ngự");
                            list.add("Huyện Tam Nông");
                            list.add("Huyện Thanh Bình");
                            list.add("Huyện Cao Lãnh");
                            list.add("Huyện Lấp Vò");
                            list.add("Huyện Tháp Mười");
                            list.add("Huyện Lai Vung");
                            list.add("Huyện Châu Thành");
                            break;
                        case 21:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Pleiku");
                            list.add("Huyện Chư Păh");
                            list.add("Huyện Mang Yang");
                            list.add("Huyện Kbang");
                            list.add("Thị xã An Khê");
                            list.add("Huyện Kông Chro");
                            list.add("Huyện Đức Cơ");
                            list.add("Huyện Chưprông");
                            list.add("Huyện Chư Sê");
                            list.add("Huyện Ayunpa");
                            list.add("Huyện Krông Pa");
                            list.add("Huyện Ia Grai");
                            list.add("Huyện Đăk Đoa");
                            list.add("Huyện Ia Pa");
                            list.add("Huyện Đăk Pơ");
                            list.add("Huyện Phú Thiện");
                            break;
                        case 22:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Hà Giang");
                            list.add("Huyện Đồng Văn");
                            list.add("Huyện Mèo Vạc");
                            list.add("Huyện Yên Minh");
                            list.add("Huyện Quản Bạ");
                            list.add("Huyện Vị Xuyên");
                            list.add("Huyện Bắc Mê");
                            list.add("Huyện Hoàng Su Phì");
                            list.add("Huyện Xín Mần");
                            list.add("Huyện Bắc Quang");
                            list.add("Huyện Quang Bình");
                            break;
                        case 23:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Phủ Lý");
                            list.add("Huyện Duy Tiên");
                            list.add("Huyện Kim Bảng");
                            list.add("Huyện Lý Nhân");
                            list.add("Huỵện Thanh Liêm");
                            list.add("Huyện Bình Lục");
                            break;
                        case 24:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Hà Tĩnh");
                            list.add("Thị xã Hồng Lĩnh");
                            list.add("Huyện Hương Sơn");
                            list.add("Huyện Đức Thọ");
                            list.add("Huyện Nghi Xuân");
                            list.add("Huyện Can Lộc");
                            list.add("Huyện Hương Khê");
                            list.add("Huyện Thạch Hà");
                            list.add("Huyện Cẩm Xuyên");
                            list.add("Huyện Kỳ Anh");
                            list.add("Huyện Vũ Quang");
                            list.add("Huyện Lộc Hà");
                            break;
                        case 25:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Quận Hồng Bàng");
                            list.add("Quận Lê Chân");
                            list.add("Quận Ngô Quyền");
                            list.add("Quận Kiến An");
                            list.add("Quận Hải An");
                            list.add("Quận Đồ Sơn");
                            list.add("Huyện An Lão");
                            list.add("Huyện Kiến Thuỵ");
                            list.add("Huyện Thủy Nguyên");
                            list.add("Huyện An Dương");
                            list.add("Huyện Tiên Lãng");
                            list.add("Huyện Vĩnh Bảo");
                            list.add("Huyện Cát Hải");
                            list.add("Huyện Bạch Long Vĩ");
                            list.add("Quận Dương Kinh");
                            break;
                        case 26:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Quận Ba Đình");
                            list.add("Quận Hoàn Kiếm");
                            list.add("Quận Hai Bà Trưng");
                            list.add("Quận Đống Đa");
                            list.add("Quận Tây Hồ");
                            list.add("Quận Cầu Giấy");
                            list.add("Quận Thanh Xuân");
                            list.add("Quận Hoàng Mai");
                            list.add("Quận Long Biên");
                            list.add("Huyện Từ Liêm");
                            list.add("Huyện Thanh Trì");
                            list.add("Huyện Gia Lâm");
                            list.add("Huyện Đông Anh");
                            list.add("Huyện Sóc Sơn");
                            list.add("Quận Hà Đông");
                            list.add("Thị xã Sơn Tây");
                            list.add("Huyện Ba Vì");
                            list.add("Huyện Phúc Thọ");
                            list.add("Huyện Thạch Thất");
                            list.add("Huyện Quốc Oai");
                            list.add("Huyện Chương Mỹ");
                            list.add("Huyện Đan Phượng");
                            list.add("Huyện Hoài Đức");
                            list.add("Huyện Thanh Oai");
                            list.add("Huyện Mỹ Đức");
                            list.add("Huyện Ứng Hoà");
                            list.add("Huyện Thường Tín");
                            list.add("Huyện Phú Xuyên");
                            list.add("Huyện Mê Linh");
                            break;
                        case 27:
                            list.clear();
                            list.add("Thành phố Hải Dương");
                            list.add("Huyện Chí Linh");
                            list.add("Huyện Nam Sách");
                            list.add("Huyện Kinh Môn");
                            list.add("Huyện Gia Lộc");
                            list.add("Huyện Tứ Kỳ");
                            list.add("Huyện Thanh Miện");
                            list.add("Huyện Ninh Giang");
                            list.add("Huyện Cẩm Giàng");
                            list.add("Huyện Thanh Hà");
                            list.add("Huyện Kim Thành");
                            list.add("Huyện Bình Giang");
                            list.add("Chọn Quận/Huyện");
                            break;
                        case 28:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Vị Thanh");
                            list.add("Huyện Vị Thuỷ");
                            list.add("Huyện Long Mỹ");
                            list.add("Huyện Phụng Hiệp");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Châu Thành A");
                            list.add("Thị xã Ngã Bảy");
                            break;
                        case 29:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Hoà Bình");
                            list.add("Huyện Đà Bắc");
                            list.add("Huyện Mai Châu");
                            list.add("Huyện Tân Lạc");
                            list.add("Huyện Lạc Sơn");
                            list.add("Huyện Kỳ Sơn");
                            list.add("Huyện Lương Sơn");
                            list.add("Huyện Kim Bôi");
                            list.add("Huyện Lạc Thuỷ");
                            list.add("Huyện Yên Thuỷ");
                            list.add("Huyện Cao Phong");
                            break;
                        case 30:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Hưng Yên");
                            list.add("Huyện Kim Động");
                            list.add("Huyện Ân Thi");
                            list.add("Huyện Khoái Châu");
                            list.add("Huyện Yên Mỹ");
                            list.add("Huyện Tiên Lữ");
                            list.add("Huyện Phù Cừ");
                            list.add("Huyện Mỹ Hào");
                            list.add("Huyện Văn Lâm");
                            list.add("Huyện Văn Giang");
                            break;
                        case 31:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Nha Trang");
                            list.add("Huyện Vạn Ninh");
                            list.add("Huyện Ninh Hoà");
                            list.add("Huyện Diên Khánh");
                            list.add("Huyện Khánh Vĩnh");
                            list.add("Thị xã Cam Ranh");
                            list.add("Huyện Khánh Sơn");
                            list.add("Huyện Trường Sa");
                            list.add("Huyện Cam Lâm");
                            break;
                        case 32:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Rạch Giá");
                            list.add("Thị xã Hà Tiên");
                            list.add("Huyện Kiên Lương");
                            list.add("Huyện Hòn Đất");
                            list.add("Huyện Tân Hiệp");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Giồng Riềng");
                            list.add("Huyện Gò Quao");
                            list.add("Huyện An Biên");
                            list.add("Huyện An Minh");
                            list.add("Huyện Vĩnh Thuận");
                            list.add("Huyện Phú Quốc");
                            list.add("Huyện Kiên Hải");
                            list.add("Huyện U minh Thượng");
                            break;
                        case 33:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã KonTum");
                            list.add("Huyện Đăk Glei");
                            list.add("Huyện Ngọc Hồi");
                            list.add("Huyện Đăk Tô");
                            list.add("Huyện Sa Thầy");
                            list.add("Huyện Kon Plong");
                            list.add("Huyện Đăk Hà");
                            list.add("Huyện Kon Rộy");
                            list.add("Huyện Tu Mơ Rông");
                            break;
                        case 34:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Lai Châu");
                            list.add("Huyện Tam Đường");
                            list.add("Huyện Phong Thổ");
                            list.add("Huyện Sìn Hồ");
                            list.add("Huyện Mường Tè");
                            list.add("Huyện Than Uyên");
                            break;
                        case 35:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Đà Lạt");
                            list.add("Thị xã. Bảo Lộc");
                            list.add("Huyện Đức Trọng");
                            list.add("Huyện Di Linh");
                            list.add("Huyện Đơn Dương");
                            list.add("Huyện Lạc Dương");
                            list.add("Huyện Đạ Huoai");
                            list.add("Huyện Đạ Tẻh");
                            list.add("Huyện Cát Tiên");
                            list.add("Huyện Lâm Hà");
                            list.add("Huyện Bảo Lâm");
                            list.add("Huyện Đam Rông");
                            break;
                        case 36:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Lạng Sơn");
                            list.add("Huyện Tràng Định");
                            list.add("Huyện Bình Gia");
                            list.add("Huyện Văn Lãng");
                            list.add("Huyện Bắc Sơn");
                            list.add("Huyện Văn Quan");
                            list.add("Huyện Cao Lộc");
                            list.add("Huyện Lộc Bình");
                            list.add("Huyện Chi Lăng");
                            list.add("Huyện Đình Lập");
                            list.add("Huyện Hữu Lũng");
                            break;
                        case 37:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Lào Cai");
                            list.add("Huyện Xi Ma Cai");
                            list.add("Huyện Bát Xát");
                            list.add("Huyện Bảo Thắng");
                            list.add("Huyện Sa Pa");
                            list.add("Huyện Văn Bàn");
                            list.add("Huyện Bảo Yên");
                            list.add("Huyện Bắc Hà");
                            list.add("Huyện Mường Khương");
                            break;
                        case 38:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Tân An");
                            list.add("Huyện Vĩnh Hưng");
                            list.add("Huyện Mộc Hoá");
                            list.add("Huyện Tân Thạnh");
                            list.add("Huyện Thạnh Hoá");
                            list.add("Huyện Đức Huệ");
                            list.add("Huyện Đức Hoà");
                            list.add("Huyện Bến Lức");
                            list.add("Huyện Thủ Thừa");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Tân Trụ");
                            list.add("Huyện Cần Đước");
                            list.add("Huyện Cần Giuộc");
                            list.add("Huyện Tân Hưng");
                            break;
                        case 39:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("TP. Nam Định");
                            list.add("Huyện Mỹ Lộc");
                            list.add("Huyện Xuân Trường");
                            list.add("Huyện Giao Thủy");
                            list.add("Huyện Ý Yên");
                            list.add("Huyện Vụ Bản");
                            list.add("Huyện Nam Trực");
                            list.add("Huyện Trực Ninh");
                            list.add("Huyện Nghĩa Hưng");
                            list.add("Huyện Hải Hậu");
                            break;
                        case 40:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Tân An");
                            list.add("Huyện Vĩnh Hưng");
                            list.add("Huyện Mộc Hoá");
                            list.add("Huyện Tân Thạnh");
                            list.add("Huyện Thạnh Hoá");
                            list.add("Huyện Đức Huệ");
                            list.add("Huyện Đức Hoà");
                            list.add("Huyện Bến Lức");
                            list.add("Huyện Thủ Thừa");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Tân Trụ");
                            list.add("Huyện Cần Đước");
                            list.add("Huyện Cần Giuộc");
                            list.add("Huyện Tân Hưng");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Tân Trụ");
                            list.add("Huyện Cần Đước");
                            list.add("Huyện Cần Giuộc");
                            list.add("Huyện Tân Hưng");
                            break;
                        case 41:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Ninh Bình");
                            list.add("Thị xã Tam Điệp");
                            list.add("Huyện Nho Quan");
                            list.add("Huyện Gia Viễn");
                            list.add("Huyện Hoa Lư");
                            list.add("Huyện Yên Mô");
                            list.add("Huyện Kim Sơn");
                            list.add("Huyện Yên Khánh");
                            break;
                        case 42:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Phan Rang-Tháp Chàm");
                            list.add("Huyện Ninh Sơn");
                            list.add("Huyện Ninh Phước");
                            list.add("Huyện Bác Ái");
                            list.add("Huyện Thuận Bắc");
                            list.add("Huyện Ninh Hải");
                            break;
                        case 43:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("TP. Việt Trì");
                            list.add("Thị xã Phú Thọ");
                            list.add("Huyện Đoan Hùng");
                            list.add("Huyện Thanh Ba");
                            list.add("Huyện Hạ Hoà");
                            list.add("Huyện Cẩm Khê");
                            list.add("Huyện Yên Lập");
                            list.add("Huyện Thanh Sơn");
                            list.add("Huyện Phù Ninh");
                            list.add("Huyện Lâm Thao");
                            list.add("Huyện Tam Nông");
                            list.add("Huyện Thanh Thủy");
                            list.add("Huyện Tân Sơn");
                            break;
                        case 44:
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Đồng Hới");
                            list.add("Huyện Tuyên Hoá");
                            list.add("Huyện Minh Hoá");
                            list.add("Huyện Quảng Trạch");
                            list.add("Huyện Bố Trạch");
                            list.add("Huyện Quảng Ninh");
                            list.add("Huyện Lệ Thuỷ");
                            break;
                        case 45:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Tam Kỳ");
                            list.add("Thị xã Hội An");
                            list.add("Huyện Duy Xuyên");
                            list.add("Huyện Điện Bàn");
                            list.add("Huyện Đại Lộc");
                            list.add("Huyện Quế Sơn");
                            list.add("Huyện Hiệp Đức");
                            list.add("Huyện Thăng Bình");
                            list.add("Huyện Núi Thành");
                            list.add("Huyện Tiên Phước");
                            list.add("Huyện Bắc Trà My");
                            list.add("Huyện Đông Giang");
                            list.add("Huyện Nam Giang");
                            list.add("Huyện Phước Sơn");
                            list.add("Huyện Nam Trà My");
                            list.add("Huyện Tây Giang");
                            list.add("Huyện Phú Ninh");
                            break;
                        case 46:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Quảng Ngãi");
                            list.add("Huyện Lý Sơn");
                            list.add("Huyện Bình Sơn");
                            list.add("Huyện Trà Bồng");
                            list.add("Huyện Sơn Tịnh");
                            list.add("Huyện Sơn Hà");
                            list.add("Huyện Tư Nghĩa");
                            list.add("Huyện Nghĩa Hành");
                            list.add("Huyện Minh Long");
                            list.add("Huyện Mộ Đức");
                            list.add("Huyện Đức Phổ");
                            list.add("Huyện Ba Tơ");
                            list.add("Huyện Sơn Tây");
                            list.add("Huyện Tây Trà");
                            break;
                        case 47:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("TP. Hạ Long");
                            list.add("Thị xã Cẩm Phả");
                            list.add("Thị xã Uông Bí");
                            list.add("Thị xã Móng Cái");
                            list.add("Huyện Bình Liêu");
                            list.add("Huyện Đầm Hà");
                            list.add("Huyện Hải Hà");
                            list.add("Huyện Tiên Yên");
                            list.add("Huyện Ba Chẽ");
                            list.add("Huyện Đông Triều");
                            list.add("Huyện Yên Hưng");
                            list.add("Huyện Hoành Bồ");
                            list.add("Huyện Vân Đồn");
                            list.add("Huyện Cô Tô");
                            break;
                        case 48:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Đông Hà");
                            list.add("Thị xã Quảng Trị");
                            list.add("Huyện Vĩnh Linh");
                            list.add("Huyện Gio Linh");
                            list.add("Huyện Cam Lộ");
                            list.add("Huyện Triệu Phong");
                            list.add("Huyện Hải Lăng");
                            list.add("Huyện Hướng Hoá");
                            list.add("Huyện Đăk Rông");
                            list.add("Huyện đảo Cồn cỏ");
                            break;
                        case 49:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Sóc Trăng");
                            list.add("Huyện Kế Sách");
                            list.add("Huyện Mỹ Tú");
                            list.add("Huyện Mỹ Xuyên");
                            list.add("Huyện Thạnh Trị");
                            list.add("HHuyện Long Phú");
                            list.add("Huyện Vĩnh Châu");
                            list.add("Huyện Cù Lao Dung");
                            list.add("Huyện Ngã Năm");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Trần Đề");
                            break;
                        case 50:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Sơn La");
                            list.add("Huyện Quỳnh Nhai");
                            list.add("Huyện Mường La");
                            list.add("Huyện Thuận Châu");
                            list.add("Huyện Bắc Yên");
                            list.add("Huyện Phù Yên");
                            list.add("Huyện Mai Sơn");
                            list.add("Huyện Yên Châu");
                            list.add("Huyện Sông Mã");
                            list.add("Huyện Mộc Châu");
                            list.add("Huyện Sốp Cộp");
                            break;
                        case 51:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Tây Ninh");
                            list.add("Huyện Tân Biên");
                            list.add("Huyện Tân Châu");
                            list.add("Huyện Dương Minh Châu");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Hoà Thành");
                            list.add("Huyện Bến Cầu");
                            list.add("Huyện Gò Dầu");
                            list.add("Huyện Trảng Bàng");
                            break;
                        case 52:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Thái Bình");
                            list.add("Huyện Quỳnh Phụ");
                            list.add("Huyện Hưng Hà");
                            list.add("Huyện Đông Hưng");
                            list.add("Huyện Vũ Thư");
                            list.add("Huyện Kiến Xương");
                            list.add("Huyện Tiền Hải");
                            list.add("Huyện Thái Thuỵ");
                            break;
                        case 53:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("TP.Thái Nguyên");
                            list.add("Thị xã Sông Công");
                            list.add("Huyện Định Hoá");
                            list.add("Huyện Phú Lương");
                            list.add("Huyện Võ Nhai");
                            list.add("Huyện Đại Từ");
                            list.add("Huyện Đồng Hỷ");
                            list.add("Huyện Phú Bình");
                            list.add("Huyện Phổ Yên");
                            break;
                        case 54:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Thanh Hoá");
                            list.add("Thị xã Bỉm Sơn");
                            list.add("Thị xã Sầm Sơn");
                            list.add("Huyện Quan Hoá");
                            list.add("Huyện Quan Sơn");
                            list.add("Huyện Mường Lát");
                            list.add("Huyện Bá Thước");
                            list.add("Huyện Thường Xuân");
                            list.add("Huyện Như Xuân");
                            list.add("Huyện Như Thanh");
                            list.add("Huyện Lang Chánh");
                            list.add("Huyện Ngọc Lặc");
                            list.add("Huyện Thạch Thành");
                            list.add("Huyện Cẩm Thủy");
                            list.add("Huyện Thọ Xuân");
                            list.add("Huyện Vĩnh Lộc");
                            list.add("Huyện Thiệu Hoá");
                            list.add("Huyện Triệu Sơn");
                            list.add("Huyện Nông Cống");
                            list.add("Huyện Đông Sơn");
                            list.add("Huyện Hà Trung");
                            list.add("Huyện Hoằng Hoá");
                            list.add("Huyện Nga Sơn");
                            list.add("Huyện Hậu Lộc");
                            list.add("Huyện Quảng Xương");
                            list.add("Huyện Tĩnh Gia");
                            list.add("Huyện Yên Định");
                            break;
                        case 55:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("TP. Huế");
                            list.add("Huyện Phong Điền");
                            list.add("Huyện Quảng Điền");
                            list.add("Huyện Hương Trà");
                            list.add("Huyện Phú Vang");
                            list.add("Huyện Hương Thuỷ");
                            list.add("Huyện Phú Lộc");
                            list.add("Huyện Nam Đông");
                            list.add("Huyện A Lưới");
                            break;
                        case 56:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Mỹ Tho");
                            list.add("Thị xã Gò Công");
                            list.add("Huyện Cái Bè");
                            list.add("Huyện Cai Lậy");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Chợ Gạo");
                            list.add("Huyện Gò Công Tây");
                            list.add("Huyện Gò Công Đông");
                            list.add("Huyện Tân Phước");
                            break;
                        case 57:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Trà Vinh");
                            list.add("Huyện Càng Long");
                            list.add("Huyện Cầu Kè");
                            list.add("Huyện Tiểu Cần");
                            list.add("Huyện Châu Thành");
                            list.add("Huyện Trà Cú");
                            list.add("Huyện Cầu Ngang");
                            list.add("Huyện Duyên Hải");
                            break;
                        case 58:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Tuyên Quang");
                            list.add("Huyện Na Hang");
                            list.add("Huyện Chiêm Hoá");
                            list.add("Huyện Hàm Yên");
                            list.add("Huyện Yên Sơn");
                            list.add("Huyện Sơn Dương");
                            break;
                        case 59:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Quận Một");
                            list.add("Quận Hai");
                            list.add("Quận Ba");
                            list.add("Quận Bốn");
                            list.add("Quận Năm");
                            list.add("Quận Sáu");
                            list.add("Quận Bảy");
                            list.add("Quận Tám");
                            list.add("Quận Chín");
                            list.add("Quận Mười");
                            list.add("Quận Mười một");
                            list.add("Quận Mười hai");
                            list.add("Quận Gò Vấp");
                            list.add("Quận Tân Bình");
                            list.add("Quận Tân Phú");
                            list.add("Quận Bình Thạnh");
                            list.add("Quận Phú Nhuận");
                            list.add("Quận Thủ Đức");
                            list.add("Quận Bình Tân");
                            list.add("Huyện Bình Chánh");
                            list.add("Huyện Củ Chi");
                            list.add("Huyện Hóc Môn");
                            list.add("Huyện Nhà Bè");
                            list.add("Huyện Cần Giờ");
                            break;
                        case 60:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Vĩnh Long");
                            list.add("Huyện Long Hồ");
                            list.add("Huyện Mang Thít");
                            list.add("Huyện Bình Minh");
                            list.add("Huyện Tam Bình");
                            list.add("Huyện Trà Ôn");
                            list.add("Huyện Vũng Liêm");
                            list.add("Huyện Bình Tân");
                            break;
                        case 61:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Vĩnh Long");
                            list.add("Huyện Long Hồ");
                            list.add("Huyện Mang Thít");
                            list.add("Huyện Bình Minh");
                            list.add("Huyện Tam Bình");
                            list.add("Huyện Trà Ôn");
                            list.add("Huyện Vũng Liêm");
                            list.add("Huyện Bình Tân");
                            list.add("Huyện Bình Tân");
                            break;
                        case 62:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thành phố Yên Bái");
                            list.add("Thị xã Nghĩa Lộ");
                            list.add("Huyện Văn Yên");
                            list.add("Huyện Yên Bình");
                            list.add("Huyện Mù Cang Chải");
                            list.add("Huyện Văn Chấn");
                            list.add("Huyện Trấn Yên");
                            list.add("Huyện Trạm Tấu");
                            list.add("Huyện Lục Yên");
                            break;
                        case 63:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                            list.add("Thị xã Tuy Hoà");
                            list.add("Huyện Đồng Xuân");
                            list.add("Huyện Sông Cầu");
                            list.add("Huyện Tuy An");
                            list.add("Huyện Sơn Hoà");
                            list.add("Huyện Sông Hinh");
                            list.add("Huyện Đông Hoà");
                            list.add("Huyện Phú Hoà");
                            list.add("Huyện Tây Hoà");
                            break;
                        default:
                            list.clear();
                            list.add("Chọn Quận/Huyện");
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                            android.R.layout.simple_spinner_item, list);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerArrayDistrict.setAdapter(dataAdapter);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //Set handle
            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShoppingCart shoppingCart = new ShoppingCart();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, shoppingCart, shoppingCart.getTag()).commit();
                }
            });

            checkOutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textinput_name.getEditText().length() == 0 || textinput_phone.getEditText().length() == 0 || spinnerArrayProvincial.getSelectedItemPosition() == 0 || spinnerArrayDistrict.getSelectedItemPosition() == 0) {
                        Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    } else {
                        String orderID = getArguments().getString("orderID");
                        String amount = getArguments().getString("amount");
                        orderModel = new OrderModel(getContext());
                        ArrayList<OrderInfo> orderInfos = orderModel.getOrderByOrderID(orderID);
                        if (orderInfos.size() == 0) {
                            Log.e("size", "0");
                        } else {
                            String address = spinnerArrayDistrict.getSelectedItem() + ", " + spinnerArrayProvincial.getSelectedItem();
                            orderModel.updateOrder(new OrderInfo(orderInfos.get(0).getID(), orderInfos.get(0).getOrderID(), orderInfos.get(0).getCustomerID(), orderInfos.get(0).getOrderDate(), orderInfos.get(0).getShipDate(), address, getEdit_Phone.getText().toString(), getGetEdit_Note.getText().toString(), amount, 2));
                            Toast.makeText(getContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                            ShoppingCart shoppingCart = new ShoppingCart();
                            FragmentManager manager = getFragmentManager();
                            manager.beginTransaction().replace(R.id.fragment, shoppingCart, shoppingCart.getTag()).commit();
                        }


                    }
                }
            });
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }

        return view;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("\\\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}