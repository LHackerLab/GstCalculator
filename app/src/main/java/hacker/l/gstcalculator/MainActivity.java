package hacker.l.gstcalculator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_price;
    CheckBox incheck, exCheck;
    Spinner spinner, spinnerdis;
    Button proced, rset;
    TextView total, gstValue, disValue;
    ArrayList<String> stringArrayList;
    double itemvalue, itemDisvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        edt_price = findViewById(R.id.edt_price);
        incheck = findViewById(R.id.check_in);
        exCheck = findViewById(R.id.check_ex);
        spinner = findViewById(R.id.spinner);
        spinnerdis = findViewById(R.id.spinnerdis);
        proced = findViewById(R.id.proced);
        rset = findViewById(R.id.reset);
        total = findViewById(R.id.total);
        disValue = findViewById(R.id.disValue);
        gstValue = findViewById(R.id.gstValue);
        setgstValueInSpinner();
        setDicValueInSpinner();
        proced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalFuction();
            }
        });
        rset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setSelection(0, true);
                spinnerdis.setSelection(0, true);
                edt_price.setText("");
                exCheck.setChecked(false);
                incheck.setChecked(true);
                total.setText("");
                gstValue.setText("");
                disValue.setText("");
            }
        });
        exCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    incheck.setChecked(false);
                    CalFuction();
                }
            }
        });
        incheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    exCheck.setChecked(false);
                    CalFuction();
                }
            }
        });
        edt_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CalFuction();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void CalFuction() {
        if (edt_price.getText().toString().isEmpty()) {
            edt_price.setError("Enter Amount Value");
        } else {
            if (itemvalue != 0) {
                if (incheck.isChecked()) {
                    InclusiveGst();
                }
                if (exCheck.isChecked()) {
                    ExclusiveGst();
                }
            } else {
                spinner.requestFocus();
            }
        }
    }

    private void ExclusiveGst() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String amount = edt_price.getText().toString();
        double price = Double.parseDouble(amount);
        double discountValue = (price * (itemDisvalue / 100));
        double totalGst = (price * itemvalue) / 100;
        double Total = Double.parseDouble(amount) + totalGst;
        total.setText(decimalFormat.format(Total));
        gstValue.setText(decimalFormat.format(totalGst));
        disValue.setText("Discnt-" + decimalFormat.format(discountValue));
    }

    private void InclusiveGst() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String amount = edt_price.getText().toString();
        double price = Double.parseDouble(amount);
        double discountValue = (price * (itemDisvalue / 100));
        double gst = price * itemvalue / (100 + itemvalue);
        //double totalPrice = price + gst;
        total.setText(decimalFormat.format(price));
        gstValue.setText(decimalFormat.format(gst));
        disValue.setText("Discnt-" + decimalFormat.format(discountValue));

    }

    private void setgstValueInSpinner() {
        stringArrayList = new ArrayList<>();
        stringArrayList.add("Select Gst Value %");
        stringArrayList.add("1%");
        stringArrayList.add("2%");
        stringArrayList.add("3%");
        stringArrayList.add("4%");
        stringArrayList.add("5%");
        stringArrayList.add("6%");
        stringArrayList.add("7%");
        stringArrayList.add("8%");
        stringArrayList.add("9%");
        stringArrayList.add("10%");
        stringArrayList.add("11%");
        stringArrayList.add("12%");
        stringArrayList.add("13%");
        stringArrayList.add("14%");
        stringArrayList.add("15%");
        stringArrayList.add("16%");
        stringArrayList.add("17%");
        stringArrayList.add("18%");
        stringArrayList.add("19%");
        stringArrayList.add("20%");
        stringArrayList.add("21%");
        stringArrayList.add("22%");
        stringArrayList.add("23%");
        stringArrayList.add("24%");
        stringArrayList.add("25%");
        stringArrayList.add("26%");
        stringArrayList.add("27%");
        stringArrayList.add("28%");
        stringArrayList.add("29%");
        stringArrayList.add("30%");
        stringArrayList.add("31%");
        stringArrayList.add("32%");
        stringArrayList.add("33%");
        stringArrayList.add("34%");
        stringArrayList.add("35%");
        stringArrayList.add("36%");
        stringArrayList.add("37%");
        stringArrayList.add("38%");
        stringArrayList.add("39%");
        stringArrayList.add("40%");
        stringArrayList.add("41%");
        stringArrayList.add("42%");
        stringArrayList.add("43%");
        stringArrayList.add("44%");
        stringArrayList.add("45%");
        stringArrayList.add("46%");
        stringArrayList.add("47%");
        stringArrayList.add("48%");
        stringArrayList.add("49%");
        stringArrayList.add("50%");
        stringArrayList.add("51%");
        stringArrayList.add("52%");
        stringArrayList.add("53%");
        stringArrayList.add("54%");
        stringArrayList.add("55%");
        stringArrayList.add("56%");
        stringArrayList.add("57%");
        stringArrayList.add("58%");
        stringArrayList.add("59%");
        stringArrayList.add("60%");
        stringArrayList.add("61%");
        stringArrayList.add("62%");
        stringArrayList.add("63%");
        stringArrayList.add("64%");
        stringArrayList.add("65%");
        stringArrayList.add("66%");
        stringArrayList.add("67%");
        stringArrayList.add("68%");
        stringArrayList.add("69%");
        stringArrayList.add("70%");
        stringArrayList.add("71%");
        stringArrayList.add("72%");
        stringArrayList.add("73%");
        stringArrayList.add("74%");
        stringArrayList.add("75%");
        stringArrayList.add("76%");
        stringArrayList.add("77%");
        stringArrayList.add("78%");
        stringArrayList.add("79%");
        stringArrayList.add("80%");
        stringArrayList.add("81%");
        stringArrayList.add("82%");
        stringArrayList.add("83%");
        stringArrayList.add("84%");
        stringArrayList.add("85%");
        stringArrayList.add("86%");
        stringArrayList.add("87%");
        stringArrayList.add("88%");
        stringArrayList.add("89%");
        stringArrayList.add("90%");
        stringArrayList.add("91%");
        stringArrayList.add("92%");
        stringArrayList.add("93%");
        stringArrayList.add("94%");
        stringArrayList.add("95%");
        stringArrayList.add("96%");
        stringArrayList.add("97%");
        stringArrayList.add("98%");
        stringArrayList.add("99%");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stringArrayList);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setSelection(0, true);
        View v = spinner.getSelectedView();
        ((TextView) v).setTextColor(Color.parseColor("#000000"));
        ((TextView) v).setGravity(Gravity.CENTER);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Change the selected item's text color
                ((TextView) view).setTextColor(Color.parseColor("#000000"));

                itemvalue = position;
                CalFuction();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setDicValueInSpinner() {
        stringArrayList = new ArrayList<>();
        stringArrayList.add("Select Discount %");
        stringArrayList.add("1%");
        stringArrayList.add("2%");
        stringArrayList.add("3%");
        stringArrayList.add("4%");
        stringArrayList.add("5%");
        stringArrayList.add("6%");
        stringArrayList.add("7%");
        stringArrayList.add("8%");
        stringArrayList.add("9%");
        stringArrayList.add("10%");
        stringArrayList.add("11%");
        stringArrayList.add("12%");
        stringArrayList.add("13%");
        stringArrayList.add("14%");
        stringArrayList.add("15%");
        stringArrayList.add("16%");
        stringArrayList.add("17%");
        stringArrayList.add("18%");
        stringArrayList.add("19%");
        stringArrayList.add("20%");
        stringArrayList.add("21%");
        stringArrayList.add("22%");
        stringArrayList.add("23%");
        stringArrayList.add("24%");
        stringArrayList.add("25%");
        stringArrayList.add("26%");
        stringArrayList.add("27%");
        stringArrayList.add("28%");
        stringArrayList.add("29%");
        stringArrayList.add("30%");
        stringArrayList.add("31%");
        stringArrayList.add("32%");
        stringArrayList.add("33%");
        stringArrayList.add("34%");
        stringArrayList.add("35%");
        stringArrayList.add("36%");
        stringArrayList.add("37%");
        stringArrayList.add("38%");
        stringArrayList.add("39%");
        stringArrayList.add("40%");
        stringArrayList.add("41%");
        stringArrayList.add("42%");
        stringArrayList.add("43%");
        stringArrayList.add("44%");
        stringArrayList.add("45%");
        stringArrayList.add("46%");
        stringArrayList.add("47%");
        stringArrayList.add("48%");
        stringArrayList.add("49%");
        stringArrayList.add("50%");
        stringArrayList.add("51%");
        stringArrayList.add("52%");
        stringArrayList.add("53%");
        stringArrayList.add("54%");
        stringArrayList.add("55%");
        stringArrayList.add("56%");
        stringArrayList.add("57%");
        stringArrayList.add("58%");
        stringArrayList.add("59%");
        stringArrayList.add("60%");
        stringArrayList.add("61%");
        stringArrayList.add("62%");
        stringArrayList.add("63%");
        stringArrayList.add("64%");
        stringArrayList.add("65%");
        stringArrayList.add("66%");
        stringArrayList.add("67%");
        stringArrayList.add("68%");
        stringArrayList.add("69%");
        stringArrayList.add("70%");
        stringArrayList.add("71%");
        stringArrayList.add("72%");
        stringArrayList.add("73%");
        stringArrayList.add("74%");
        stringArrayList.add("75%");
        stringArrayList.add("76%");
        stringArrayList.add("77%");
        stringArrayList.add("78%");
        stringArrayList.add("79%");
        stringArrayList.add("80%");
        stringArrayList.add("81%");
        stringArrayList.add("82%");
        stringArrayList.add("83%");
        stringArrayList.add("84%");
        stringArrayList.add("85%");
        stringArrayList.add("86%");
        stringArrayList.add("87%");
        stringArrayList.add("88%");
        stringArrayList.add("89%");
        stringArrayList.add("90%");
        stringArrayList.add("91%");
        stringArrayList.add("92%");
        stringArrayList.add("93%");
        stringArrayList.add("94%");
        stringArrayList.add("95%");
        stringArrayList.add("96%");
        stringArrayList.add("97%");
        stringArrayList.add("98%");
        stringArrayList.add("99%");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stringArrayList);
        spinnerdis.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdis.setSelection(0, true);
        View v = spinnerdis.getSelectedView();
        ((TextView) v).setTextColor(Color.parseColor("#000000"));
        ((TextView) v).setGravity(Gravity.CENTER);
        spinnerdis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Change the selected item's text color
                ((TextView) view).setTextColor(Color.parseColor("#000000"));

                itemDisvalue = position;
                CalFuction();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //for hid keyboard when tab outside edittext box
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}
