package com.mcerarslan.fotografpaylasmafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class HaberlerActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haberler)

        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()
        
        verileriAl()
    }
    
    fun verileriAl(){
        
        database.collection("Post").orderBy("tarih",Query.Direction.DESCENDING).addSnapshotListener { snapshot, exception ->
            if(exception != null){
                Toast.makeText(this,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }else {
                if (snapshot != null) {
                    if (snapshot.isEmpty == false){
                        val documents = snapshot.documents

                        for(document in documents){
                            val kullaniciEmail = document.get("email") as String
                            val kullaniciYorum = document.get("yorum") as String
                            val gorselUrl = document.get("gorselUrl") as String


                        }
                    }
                }
            }
        }
        
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.secenek_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (item.itemId == R.id.fotograf_paylas){
           val intent = Intent(this,FotografPaylasmaActivity::class.java)
           startActivity(intent)

       }else if(item.itemId == R.id.cikis_yap){

           auth.signOut()
           val intent = Intent(this,MainActivity::class.java)
           startActivity(intent)
           finish()
       }

        return super.onOptionsItemSelected(item)
    }
}