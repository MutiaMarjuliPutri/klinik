package com.mutia.klinik

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mutia.klinik.adapter.AdapterListDoctors
import com.mutia.klinik.adapter.AdapterMenuIcon
import com.mutia.klinik.model.ModelIcon
import com.mutia.klinik.model.ModelListDoctors

class Doctors : AppCompatActivity() {

    private lateinit var RecyclerViewMenu: RecyclerView
    private lateinit var AdapterMenu: AdapterMenuIcon

    private lateinit var RecyclerViewDoctor: RecyclerView
    private lateinit var AdapterDoctor: AdapterListDoctors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctors)

        val menuIcons = listOf(
            ModelIcon(R.drawable.icon_heart, "cardiologist"),
            ModelIcon(R.drawable.icon_eye, "Ophthalmologyst"),
            ModelIcon(R.drawable.icon_tooth, "Dentist")
        )


        //inisialisasi recyclerview dan adapter
        RecyclerViewMenu = findViewById(R.id.recycleViewMenu)
        RecyclerViewMenu.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        AdapterMenu = AdapterMenuIcon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        val menudokter = listOf(
            ModelListDoctors(
                "Dr.Floyd Miles",
                R.drawable.dokter1,
                "Pediatrics",
                "(123 reviews)",
                "4.9"
            ),
            ModelListDoctors(
                "Dr.Guy Hawkins",
                R.drawable.dokter2,
                "Dentist",
                "(85 reviews)",
                "5.0"
            ),
            ModelListDoctors(
                "Dr.Jane Cooper",
                R.drawable.dokter3,
                "Cardiologist",
                "(44 reviews)",
                "4.9"
            ),
            ModelListDoctors(
                "Dr.Jacob Jones",
                R.drawable.dokter4,
                "Nephrologyst",
                "(101 reviews)",
                "5.0"
            ),
            ModelListDoctors(
                "Dr.Savannah Nguyen",
                R.drawable.dokter5,
                "Urologist",
                "(168 reviews)",
                "4.8"
            )
        )

        //inisialisasi recycleview dan adapter
        RecyclerViewDoctor = findViewById(R.id.recycleViewDoctor)
        RecyclerViewDoctor.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        AdapterDoctor = AdapterListDoctors(menudokter)
        RecyclerViewDoctor.adapter = AdapterDoctor
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}