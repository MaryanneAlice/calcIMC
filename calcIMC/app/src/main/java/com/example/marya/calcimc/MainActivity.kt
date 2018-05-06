package com.example.marya.calcimc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcIMC.setOnClickListener {
            val kg = peso.text.toString().toDouble();
            val h = altura.text.toString().toDouble();
            val res = kg/(h*h);

            var feedBack:String = "";

            if (res <= 16.9) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Muito abaixo do peso \n"+
                        "O que pode acontecer: Queda de cabelo, infertilidade, ausência menstrual."
            }
            else if ((res <= 18.4)) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Abaixo do peso \n"+
                        "O que pode acontecer: Fadiga, stress, ansiedade."
            }
            else if ((res <= 24.9)) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Peso normal \n"+
                        "O que pode acontecer: Menor risco de doenças cardíacas e vasculares."
            }
            else if ((res <= 29.9)) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Acima do peso \n"+
                        "O que pode acontecer: Fadiga, má circulação, varizes."
            }
            else if ((res <= 34.9)) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Obesidade Grau I \n"+
                        "O que pode acontecer: Diabetes, angina, infarto, aterosclerose."
            }
            else if ((res <= 40)) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Obesidade Grau II \n"+
                        "O que pode acontecer: Apneia do sono, falta de ar."
            }
            else if ((res > 40)) {
                feedBack = "Seu IMC é " + "%.2f".format(res) + " kg/m². \n" +
                        "Classificação: Obesidade Grau III \n"+
                        "O que pode acontecer: Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC."
            }


            val intent = Intent(this, ResultIMCActivity::class.java);
            intent.putExtra("valueRes", feedBack);
            startActivity(intent);

        }

    }

}
