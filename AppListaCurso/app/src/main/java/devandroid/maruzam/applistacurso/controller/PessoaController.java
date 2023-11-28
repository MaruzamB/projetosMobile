package devandroid.maruzam.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.maruzam.applistacurso.database.ListaCursoDB;
import devandroid.maruzam.applistacurso.model.Pessoa;
import devandroid.maruzam.applistacurso.view.MainActivity;

public class PessoaController extends ListaCursoDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip ";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        ContentValues dados = new ContentValues();

        Log.d("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", pessoa.getSobreNome());
        listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("Telefone", pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobreNome", pessoa.getSobreNome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato", pessoa.getTelefoneContato());

        salvarObjeto("Pessoa", dados);
    }

    public Pessoa buscarDadosSharedPreferences(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("Sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado", "NA"));
        pessoa.setTelefoneContato(preferences.getString("Telefone", "NA"));
        return pessoa;

    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();

    }

    public void alterar(Pessoa pessoa){

        ContentValues dados = new ContentValues();

        dados.put("id",pessoa.getId());
        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobreNome", pessoa.getSobreNome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato", pessoa.getTelefoneContato());

        alterarObjeto("Pessoa",dados);

    }

    public void deletar(int id){
        deletarObjeto("Pessoa",id);
    }


}
