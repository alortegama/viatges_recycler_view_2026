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
        val viatges = listOf(
            Viatge(1, "París", "2026-11-01", "2026-11-05", 450.0, "paris.jpg"),
            Viatge(2, "Roma", "2026-11-10", "2026-11-14", 380.0, "roma.jpg"),
            Viatge(3, "Londres", "2026-12-01", "2026-12-06", 520.0, "londres.jpg"),
            Viatge(4, "Tòquio", "2027-01-15", "2027-01-25", 1850.0, "toquio.jpg"),
            Viatge(5, "Nova York", "2027-02-05", "2027-02-12", 1250.0, "nova_york.jpg"),
            Viatge(6, "Barcelona", "2027-03-10", "2027-03-13", 220.0, "barcelona.jpg"),
            Viatge(7, "Lisboa", "2027-04-01", "2027-04-05", 310.0, "lisboa.jpg"),
            Viatge(8, "Reykjavík", "2027-05-15", "2027-05-22", 980.0, "reykjavik.jpg"),
            Viatge(9, "Atenes", "2027-06-10", "2027-06-17", 640.0, "atenes.jpg"),
            Viatge(10, "Bali", "2027-07-01", "2027-07-12", 1490.0, "bali.jpg")
        )
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