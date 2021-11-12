package to.msn.wings.healthapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.math.*;


public class BmiCalculation extends AppCompatActivity {
    private double height;
    private double weight;
}

//TODO SQLiteから紐づけられたものを取得　9/16
double weight =

@Override
public double bmi() {
    return weight/height/height;
}
