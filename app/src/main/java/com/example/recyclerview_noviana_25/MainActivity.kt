package com.example.recyclerview_noviana_25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.hero1,
                "Karakter Super hero 1",
                "Rancangan desain karakter super hero laki laki berbaju hitam emas"
            ),
            Superhero(
                R.drawable.hero2,
                "Karakter hero 2",
                "Rancangan desain karakter super hero laki laki berbaju hitam merah"
            ),
            Superhero(
                R.drawable.hero3,
                "Karakter hero 3",
                "Rancangan desain karakter super hero perempuan berbaju hitam biru"
            ),
            Superhero(
                R.drawable.hero4,
                "Karakter hero 4",
                "Rancangan desain karakter super hero perempuan berbaju putih"
            ),
            Superhero(
                R.drawable.hero5,
                "Karakter hero 5",
                "Rancangan desain karakter super hero perempuan berbaju silver"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList){
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}