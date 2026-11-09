package ad.cfp.viatges.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ad.cfp.viatges.R
import ad.cfp.viatges.Viatge
import ad.cfp.viatges.databinding.ActivityDetallViatgeBinding
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

class DetallViatgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallViatgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetallViatgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viatge = intent.extras!!
            .getParcelable<Viatge>("viatge")!!
        binding.destinacio.text = viatge.destinacio
        binding.dataSortida.text = viatge.dataSortida
        binding.dataTornada.text = viatge.dataTornada
        binding.preu.text = viatge.preu.toString()


    }
}