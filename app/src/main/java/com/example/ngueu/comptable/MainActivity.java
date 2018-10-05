package com.example.ngueu.comptable;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, Company> listCompanies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCompanies = new HashMap<>();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listCompanies = new HashMap<>();
                setContentView(R.layout.add_compagny_main);

                Button addCompanyButton = (Button) findViewById(R.id.buttonAdd);
                final EditText nameCompany = (EditText) findViewById(R.id.editTextCompanyName);
                final EditText nameAccount = (EditText) findViewById(R.id.editTextAccountName);

                addCompanyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(nameCompany.getText().length() == 0 && nameAccount.getText().length() == 0)
                            Toast.makeText(MainActivity.this, "les champs sont vides", Toast.LENGTH_LONG).show();
                        else if(nameCompany.getText().length() == 0)
                            Toast.makeText(MainActivity.this, "Veuillez indiquer le nom de l'entreprise", Toast.LENGTH_LONG).show();
                        else if(nameAccount.getText().length() == 0)
                            Toast.makeText(MainActivity.this, "Veuillez indiquer le nom du compte", Toast.LENGTH_LONG).show();
                        else {
                            Toast.makeText(MainActivity.this, "Nom entreprise : " + nameCompany.getText().toString() + " Nom Compte : " + nameAccount.getText(), Toast.LENGTH_LONG).show();
                            listCompanies.put(nameCompany.getText().toString(), new Company(nameCompany.getText().toString()));
                            listCompanies.get(nameCompany.getText().toString()).addAccount(new Compte(nameAccount.getText().toString(), listCompanies.get(nameCompany.getText().toString())));
                        }

                        setContentView(R.layout.activity_main);
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
