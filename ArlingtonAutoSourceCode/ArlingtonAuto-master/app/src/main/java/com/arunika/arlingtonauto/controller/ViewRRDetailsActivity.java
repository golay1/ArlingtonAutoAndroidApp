package com.arunika.arlingtonauto.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.arunika.arlingtonauto.DAO.CarDAO;
import com.arunika.arlingtonauto.DAO.ReservationDAO;
import com.arunika.arlingtonauto.R;
import com.arunika.arlingtonauto.model.Car;
import com.arunika.arlingtonauto.model.Reservation;
import com.arunika.arlingtonauto.model.ReservationDetails;
import com.arunika.arlingtonauto.model.User;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class ViewRRDetailsActivity extends  BaseMenuActivity {

    private TextView carNameField;
    private TextView renterNameField;
    private TextView capacityField;
    private TextView checkOutField;
    private TextView returnField;
    private TextView extrasField;
    private TextView priceField;
    private TextView confirmationField;

    private ReservationDetails selectedReservation;
    private Car selectedCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rr_details);
        //get selected reservation from intent
        selectedReservation = (ReservationDetails) getIntent().getSerializableExtra("selectedReservation");
        getViews();
    }

    private void getViews() {
        this.carNameField = (TextView) findViewById(R.id.carName);
        this.renterNameField = (TextView)findViewById(R.id.renterUsername);
        this.capacityField = (TextView) findViewById(R.id.capacity);
        this.checkOutField = (TextView) findViewById(R.id.checkOut);
        this.returnField = (TextView) findViewById(R.id.returnBy);
        this.extrasField = (TextView) findViewById(R.id.extras);
        this.priceField = (TextView) findViewById(R.id.totalPrice);
        this.confirmationField = (TextView)findViewById(R.id.confirmationNumber);

        this.carNameField.setText(selectedReservation.getCarName());
        this.renterNameField.setText(selectedReservation.getRenterUsername());
        this.capacityField.setText(Integer.toString(selectedReservation.getCapacity()));
        this.checkOutField.setText(selectedReservation.getStartTimeAsString());
        this.returnField.setText(selectedReservation.getEndTimeAsString());
        this.extrasField.setText(selectedReservation.getAdditionalFeatures());
        this.priceField.setText("$" + selectedReservation.getTotalPrice());
        this.confirmationField.setText(Integer.toString(selectedReservation.getId()));
    }

}
