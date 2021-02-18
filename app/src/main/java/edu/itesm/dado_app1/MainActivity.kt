package edu.itesm.dado_app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros_jugador1 = 0
    var tiros_jugador2 = 0
    var sumaJ1 = 0
    var sumaJ2 = 0
    var nuevoJuego = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tira_dado()
    }


    fun tira_dado() {


                roll_dice.setOnClickListener {
                    val rand = Random.nextInt(1, 6)
                    mensaje.text = "$rand"
                    if (tiros_jugador1 < 3) {
                        roll_dice.setText("TIRO JUGADOR 1")
                        tiros_jugador1++
                        mensaje_tiros.text = "TIROS: ${tiros_jugador1}"
                        sumaJ1 = sumaJ1 + rand
                        //  puntosJ1.text = "${sumaJ1}"
                    } else if (tiros_jugador1 == 3) {
                        roll_dice.setText("TIROS JUGADOR 2")
                        if (tiros_jugador2 < 3) {
                            tiros_jugador2++
                            mensaje_tiros.text = "TIROS: ${tiros_jugador2}"
                            sumaJ2 = sumaJ2 + rand
                            //  puntosJ2.text = "${sumaJ2}"
                        } else {
                            roll_dice.setText("Jugar de nuevo")
                            if (sumaJ1 > sumaJ2) {
                                mensaje.text = "Ganador Jugador 1 con ${sumaJ1} pts"

                            } else if (sumaJ2 > sumaJ1) {
                                mensaje.text = "Ganador Jugador 2 con ${sumaJ2} pts"

                            }
                            tiros_jugador1 = 0 // reinicio tiros
                            sumaJ1 = 0 // reinicio puntos
                            tiros_jugador2 = 0 // reinicio tiros
                            sumaJ2 = 0 // reinicio puntos
                        }

                    }

                }// Fin roll_dice click

    }
}

