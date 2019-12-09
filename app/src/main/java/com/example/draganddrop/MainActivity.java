package com.example.draganddrop;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {
    TextView textview1, textView2, textView3, target_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        target_textview = findViewById(R.id.textView4);

        textview1.setOnLongClickListener(this);
        textView2.setOnLongClickListener(this);
        textView3.setOnLongClickListener(this);

        target_textview.setOnDragListener(this);


    }


    @Override
    public boolean onLongClick(View v) {
        ClipData clipData = ClipData.newPlainText("", "");
        View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
        v.startDragAndDrop(clipData, dragShadowBuilder, v, 0);
        return true;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        int drag_event_action = event.getAction();
        switch (drag_event_action) {
            case DragEvent.ACTION_DRAG_ENTERED:
                View view = (View) event.getLocalState();

                if (view.getId() == R.id.textView) {
                    target_textview.setText("Textview 1 is dragged");
                } else if (view.getId() == R.id.textView2) {
                    target_textview.setText("Textview 2 is dragged");
                } else if (view.getId() == R.id.textView3) {
                    target_textview.setText("Textview 3 is dragged");
                }

                break;

            case DragEvent.ACTION_DRAG_EXITED:

                break;
            case DragEvent.ACTION_DROP:
                break;


        }
        return true;
    }
}
