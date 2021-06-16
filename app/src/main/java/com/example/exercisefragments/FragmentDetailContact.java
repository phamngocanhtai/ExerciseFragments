package com.example.exercisefragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDetailContact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDetailContact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView txtName, txtPhone, txtEmail;
    ImageView imgAvatar, imgCall, imgMessage, imgEmail;
    Contact detailContact;

    public FragmentDetailContact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDetailContact.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDetailContact newInstance(String param1, String param2) {
        FragmentDetailContact fragment = new FragmentDetailContact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentDetailContact newInstance(Contact contact) {
        FragmentDetailContact fragment = new FragmentDetailContact();
        Bundle args = new Bundle();
        args.putString("name", contact.name);
        args.putString("phone", contact.phone);
        args.putString("email", contact.email);
        args.putInt("avatar", contact.avatar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            detailContact = new Contact(getArguments().getString("name"), getArguments().getString("phone"),
                                        getArguments().getString("email"), getArguments().getInt("avatar", 0));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtName = view.findViewById(R.id.txtName);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtEmail = view.findViewById(R.id.txtEmail);
        imgAvatar = view.findViewById(R.id.imgAvatar);
        imgCall = view.findViewById(R.id.imgCall);
        imgMessage = view.findViewById(R.id.imgMessage);
        imgEmail = view.findViewById(R.id.imgEmail);

        txtName.setText(detailContact.name);
        txtPhone.setText(detailContact.phone);
        txtEmail.setText(detailContact.email);
        switch (detailContact.avatar)
        {
            case 0: imgAvatar.setImageResource(R.drawable.icon_female1); break;
            case 1: imgAvatar.setImageResource(R.drawable.icon_female2); break;
            case 2: imgAvatar.setImageResource(R.drawable.icon_male1); break;
            case 3: imgAvatar.setImageResource(R.drawable.icon_male2); break;
        }
        imgCall.setImageResource(R.drawable.ic_baseline_phone_24);
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "tel: ";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phone + detailContact.phone));
                startActivity(intent);
            }
        });
        imgMessage.setImageResource(R.drawable.ic_baseline_message_24);
        imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "smsto: ";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(phone + detailContact.phone));
                intent.putExtra("sms_body", "test fragment contact detail");
                startActivity(intent);
            }
        });
        imgEmail.setImageResource(R.drawable.ic_baseline_email_24);
        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String [] {"phamngocanhtai@yahoo.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "test fragment contact send mail detail");
                intent.putExtra(Intent.EXTRA_TEXT, "ok");
                startActivity(intent);
            }
        });
    }
}