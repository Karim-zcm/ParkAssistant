package de.haw.hamburg.parkassistant;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Liste extends AppCompatActivity {

    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkplatz_list);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    public void addToList(View view) {
        EditText editText = findViewById(R.id.edit_text);
        String input = editText.getText().toString();

        list.add(input);
        adapter.notifyDataSetChanged();
    }
}

// In diesem Beispiel wird eine ListView in der Benutzeroberfläche verwendet, um die Liste anzuzeigen.
// Ein ArrayAdapter wird verwendet, um die Daten in der ListView darzustellen.
// Ein Button wird verwendet, um eine neue Eingabe hinzuzufügen.
// Wenn der Benutzer auf den Button klickt, wird die Methode addToList aufgerufen,
// die die Eingabe aus einem EditText liest und zur Liste hinzufügt.
//kaka