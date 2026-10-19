package ad.cfp.viatges

import ad.cfp.viatges.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ViatgesAdapterActions {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viatgesAdapter = ViatgesAdapter(viatges, this)
        binding.rv.apply {
            adapter = viatgesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun click(viatge: Viatge) {
        Snackbar
            .make(
                binding.root,
                viatge.destinacio,
                Snackbar.LENGTH_SHORT
            )
            .show()
    }
}