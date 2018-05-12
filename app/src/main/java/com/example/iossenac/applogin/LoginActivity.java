package com.example.iossenac.applogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iossenac.applogin.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iniciaUsuarios();

        setContentView(R.layout.activity_login);
    }

    private void iniciaUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("user1","senha1"));
        listaUsuarios.add(new Usuario("user2","senha2"));
        listaUsuarios.add(new Usuario("user3","senha3"));


    }

    public void realizaLogin(View view){

        EditText textoUsuario = (EditText) findViewById(R.id.textNome);
        EditText textoSenha = (EditText) findViewById(R.id.textSenha);

        Usuario usuario = new Usuario(textoUsuario.getText().toString(),
                textoSenha.getText().toString());

        if(listaUsuarios.contains(usuario))
            Toast.makeText(this,this.getString(R.string.msg_ok),Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this,this.getString(R.string.msg_error),Toast.LENGTH_SHORT)
                    .show();

        textoUsuario.setText("");
        textoSenha.setText("");


    }


}
