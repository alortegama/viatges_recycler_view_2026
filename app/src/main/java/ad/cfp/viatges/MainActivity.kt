package ad.cfp.viatges

import ad.cfp.viatges.databinding.ActivityMainBinding
import ad.cfp.viatges.ui.DetallViatgeActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ViatgesAdapterActions {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viatges: MutableList<Viatge>
    private lateinit var viatgesAdapter: ViatgesAdapter


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
        viatges = mutableListOf(
            Viatge(
                1,
                "París",
                "2026-11-01",
                "2026-11-05",
                450.0,
                "https://thumb.wikimedia.org/wikipedia/commons/thumb/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg/960px-La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg"
            ),
            Viatge(
                2,
                "Roma",
                "2026-11-10",
                "2026-11-14",
                380.0,
                "https://www.turismoroma.it/sites/default/files/Roma%20in%20breve.jpg"
            ),
            Viatge(
                3,
                "Londres",
                "2026-12-01",
                "2026-12-06",
                520.0,
                "https://cdn2.civitatis.com/reino-unido/londres/guia/londres-nuit?aid=804&guide_id=5"
            ),
            Viatge(
                4,
                "Tòquio",
                "2027-01-15",
                "2027-01-25",
                1850.0,
                "https://s3.eu-west-1.amazonaws.com/ryo-prod-public-398019065442/public_endroits_manga_tokyo_fans_poster_es_e142b9f354.jpg"
            ),
            Viatge(5, "Nova York", "2027-02-05", "2027-02-12", 1250.0, "nova_york.jpg"),
            Viatge(6, "Barcelona", "2027-03-10", "2027-03-13", 220.0, "barcelona.jpg"),
            Viatge(7, "Lisboa", "2027-04-01", "2027-04-05", 310.0, "lisboa.jpg"),
            Viatge(8, "Reykjavík", "2027-05-15", "2027-05-22", 980.0, "reykjavik.jpg"),
            Viatge(9, "Atenes", "2027-06-10", "2027-06-17", 640.0, "atenes.jpg"),
            Viatge(10, "Bali", "2027-07-01", "2027-07-12", 1490.0, "bali.jpg")
        )
        viatgesAdapter = ViatgesAdapter(viatges, this)
        binding.rv.apply {
            adapter = viatgesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun click(viatge: Viatge) {
        val intent = Intent(
            this,
            DetallViatgeActivity::class.java
        )
        intent.putExtra("viatge", viatge)
        startActivity(intent)
    }

    override fun delete(id: Int, pos: Int) {
        viatges.removeIf { viatge -> viatge.id == id }
        viatgesAdapter.notifyItemRemoved(pos)
    }

    override fun preferit(id: Int, pos: Int) {
        /*
            val viatge = viatges.find { viatge -> viatge.id == id }!!
            val listPos = viatges.lastIndexOf(viatge)
            viatge.preferit = !viatge.preferit
            viatges[listPos] = viatge
            viatgesAdapter.notifyItemChanged(pos)
        */
        viatges.find { viatge -> viatge.id == id }!!.apply {
            preferit = !preferit
            viatgesAdapter.notifyItemChanged(pos)
        }

    }

    override fun add(viatge: Viatge) {
        TODO("Not yet implemented")
    }
}