package edu.iest.androidwear

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.iest.androidwear.databinding.ActivityRelojBinding

class MainActivity : Activity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityRelojBinding
    private var primerNumero : String? = null
    private var segundoNumero : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRelojBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adaptador = ArrayAdapter.createFromResource(this,R.array.misOpciones, android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spPrimerNumero.adapter = adaptador
        binding.spPrimerNumero.onItemSelectedListener = this

        binding.spSegundoNumero.adapter = adaptador
        binding.spSegundoNumero.onItemSelectedListener = this

        binding.bnCheck.setOnClickListener{
            if (Integer.valueOf(primerNumero)  > Integer.valueOf(segundoNumero)){
                Toast.makeText(this, "El numero mayor es el Spinner Izquierdo", Toast.LENGTH_SHORT).show()
            }else if (Integer.valueOf(primerNumero)  < Integer.valueOf(segundoNumero)){
                Toast.makeText(this, "El numero mayor es el Spiner Derecho", Toast.LENGTH_SHORT).show()
            }else if (Integer.valueOf(primerNumero)  == Integer.valueOf(segundoNumero)){
                Toast.makeText(this, "Los numeros son iguales", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onItemSelected(vistaPadre: AdapterView<*>?, vistaRow: View?, position: Int, idVista: Long) {
        if(vistaPadre!!.id == R.id.spPrimerNumero)
        {
            primerNumero = vistaPadre.getItemAtPosition(position).toString()
        }
        else if(vistaPadre!!.id == R.id.spSegundoNumero)
        {
            segundoNumero = vistaPadre.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}