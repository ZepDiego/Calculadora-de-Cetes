package DiegoZ.cetesd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    lateinit var lm:RecyclerView
    lateinit var adapter: CDAdapter
    lateinit var dineinver:EditText
    var progreso:Int=0

    private val CDViewModel:CDViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lm=findViewById(R.id.rv_interes)
        dineinver=findViewById(R.id.dineinver)
        adapter=CDAdapter(CDViewModel.elementos)
        lm.adapter=adapter
        lm.layoutManager=LinearLayoutManager(this)

        val barra=findViewById<SeekBar>(R.id.sb_interes)

        dineinver.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                cambioDeBarra()
            }

            override fun afterTextChanged(s: Editable?) {
                cambioDeBarra()
            }

        })

        barra.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progreso=progress
                cambioDeBarra()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
    fun cambioDeBarra(){
        val can=dineinver.text.toString()
        if(can.isNotEmpty()){
            CDViewModel.elementos.clear()
            val porcentaje:Float= (11.49/12).toFloat()
            var cantidad:Float=can.toInt().toFloat()
            var intCant:Float
            for (i in 0..progreso){
                if(i!=0){
                    intCant= (cantidad*(1+(porcentaje/100))).toFloat()
                    CDViewModel.elementos.add(CDMes(i,intCant,intCant-cantidad,porcentaje))
                    cantidad=intCant
                }
            }
            adapter.notifyDataSetChanged()
        }
    }

}