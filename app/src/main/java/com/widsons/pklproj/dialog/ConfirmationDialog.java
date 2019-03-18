package com.widsons.pklproj.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.widsons.pklproj.R;

/**
 * Created on : March/18/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class ConfirmationDialog extends DialogFragment {

    public static final String TITLE = "TITLE";
    public static final String MESSAGE = "MESSAGE";

    private ViewGroup parent;
    private TextView textViewTitle;
    private TextView textViewMessage;



    public static ConfirmationDialog createConfirmationDialog(String title, String message) {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog();
//        confirmationDialog.title = title;
//        confirmationDialog.message = message;
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        bundle.putString(MESSAGE, message);

        confirmationDialog.setArguments(bundle);

        return confirmationDialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        parent = (ViewGroup) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_confirmation, container, false);
        return parent;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String title = arguments.getString(TITLE, "");
        String message = arguments.getString(MESSAGE, "");
        textViewTitle = parent.findViewById(R.id.text_view_title);
        textViewMessage = parent.findViewById(R.id.text_view_message);
        textViewTitle.setText(title);
        textViewMessage.setText(message);

    }
}
