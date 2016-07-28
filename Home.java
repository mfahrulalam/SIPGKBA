package com.pgkebonagung.pgkba;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.StringTokenizer;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class Home extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    Button btn;
    int tahun, bulan, hari;
    static final int DIALOG_ID = 0;
    private static final String[][] DATA_TO_SHOW = { { "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" },{ "This", "is", "a", "test" },
            { "and", "a", "second", "test" } };
    private static final String[]header={"Uraian","Coba1","Coba2","Coba3"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lap_pemasukan_tebu);
        final Calendar cal = Calendar.getInstance();
        tahun = cal.get(Calendar.YEAR);
        bulan = cal.get(Calendar.MONTH);
        hari = cal.get(Calendar.DAY_OF_MONTH);

        showDialogButtonClick();

        TableView<String[]> tableView = (TableView<String[]>) findViewById(R.id.tableView);
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, DATA_TO_SHOW));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,header));


//        TableRow.LayoutParams wrapWrapTableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
//        int[] scrollableColumnWidths = new int[]{20, 20, 20, 20, 20};
//        int fixedRowHeight = 50;
//
//        TableLayout fixedColumn = (TableLayout) findViewById(R.id.fixed_column);
//        //rest of the table (within a scroll view)
//        TableLayout scrollablePart = (TableLayout) findViewById(R.id.scrollable_part);
//        //Kolom
//        TextView fixedView = makeTableRowWithText("row number ", scrollableColumnWidths[0], fixedRowHeight);
//        fixedView.setBackgroundColor(Color.rgb(61, 81, 181));
//        fixedColumn.addView(fixedView);
//        //Baris
//        TableRow row = new TableRow(this);
//        row.setLayoutParams(wrapWrapTableRowParams);
//        row.setBackgroundColor(Color.rgb(61, 81, 181));
//        row.addView(makeTableRowWithText("value 2", scrollableColumnWidths[1], fixedRowHeight));
//        row.addView(makeTableRowWithText("value 3", scrollableColumnWidths[2], fixedRowHeight));
//        row.addView(makeTableRowWithText("value 4", scrollableColumnWidths[3], fixedRowHeight));
//        row.addView(makeTableRowWithText("value 5", scrollableColumnWidths[4], fixedRowHeight));
//        scrollablePart.addView(row);
//
//
//    }
//
//
//    //util method
//    private TextView recyclableTextView;
//
//    public TextView makeTableRowWithText(String text, int widthInPercentOfScreenWidth, int fixedHeightInPixels) {
//        int screenWidth = getResources().getDisplayMetrics().widthPixels;
//        recyclableTextView = new TextView(this);
//        recyclableTextView.setGravity(Gravity.CENTER);
//        recyclableTextView.setText(text);
//        recyclableTextView.setTextColor(Color.WHITE);
//        recyclableTextView.setTextSize(20);
//        recyclableTextView.setWidth(widthInPercentOfScreenWidth * screenWidth / 100);
//        recyclableTextView.setHeight(fixedHeightInPixels);
//        return recyclableTextView;
    }

    public void showDialogButtonClick() {
        btn = (Button) findViewById(R.id.button);
        btn.setText(tahun + " / " + bulan + " / " + hari);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerlistener, tahun, bulan, hari);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerlistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int tahunberapa, int bulanberapa, int hariapa) {
            tahun = tahunberapa;
            bulan = bulanberapa + 1;
            hari = hariapa;
            Toast.makeText(Home.this, tahun + " / " + bulan + " / " + hari, Toast.LENGTH_LONG).show();
            Button lptbutton = (Button) findViewById(R.id.button);
            lptbutton.setText(tahun + " / " + bulan + " / " + hari);
        }
    };
}



