package mx.edu.ittepic.tpdm_u4_ejercicio_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var resultado:EditText?=null
    var bciclo:Button?=null
    var bhilo:Button?=null
    var btimer:Button?=null
    var etiqueta:TextView?=null
    var ytint=0
    var vhint=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado=findViewById(R.id.resultado)
        bhilo=findViewById(R.id.hilo)
        btimer=findViewById(R.id.timer)
        bciclo=findViewById(R.id.ciclo)
        etiqueta=findViewById(R.id.etiqueta)


        bciclo?.setOnClickListener {
            (0..100000).forEach{
                etiqueta?.setText("Valor :"+it)
            }
        }

        btimer?.setOnClickListener{

            var timer=object:CountDownTimer(2000,20)
            {
                override fun onFinish() {
                    start()
                }

                override fun onTick(millisUntilFinished: Long) {
                    etiqueta?.setText("Valor :"+ytint++)
                }

            }.start()
        }

        bhilo?.setOnClickListener{
            var hilo=Hilo(this)
            hilo.start()
                }





    }
}




    private class Hilo(p:MainActivity):Thread() {
        var puntero = p

        override fun run() {
            super.run()
            while (true) {
                sleep(200)
                puntero.runOnUiThread {
                    //aqui se puede ejecutar para el mainactivity
                    puntero.setTitle("Valor : " + puntero.vhint++)
                }

            }
        }
    }

