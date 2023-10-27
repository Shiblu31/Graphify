package com.example.mydamo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydamo.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        getDamo()
        getVerb()
        getobject()


    }

    private fun getobject() {
        binding.recyclerobject.layoutManager = LinearLayoutManager(this)
        val damoObjectList = mutableListOf<Damo2>()

        val databaseReference = FirebaseDatabase.getInstance().getReference("objects")
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val nnn = snapshot.childrenCount
                for (i in 0 until nnn) {
                    val key = "item_$i"
                    val value = snapshot.child(key).value?.toString() ?: ""
                    val damo = Damo2(value)
                    damoObjectList.add(damo)
                }

                val adapter = ObjectAdapter(damoObjectList)
                binding.recyclerobject.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }

    private fun getVerb() {
        binding.recyclerVerv.layoutManager = LinearLayoutManager(this)
        val damoVerbList = mutableListOf<Damo1>()

        val databaseReference = FirebaseDatabase.getInstance().getReference("verbs")
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val nnn = snapshot.childrenCount
                for (i in 0 until nnn) {
                    val key = "item_$i"
                    val value = snapshot.child(key).value?.toString() ?: ""
                    val damo = Damo1(value)
                    damoVerbList.add(damo)
                }

                val adapter = VerbAdapter(damoVerbList)
                binding.recyclerVerv.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }

    private fun getDamo() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        val damoList = mutableListOf<Damo>()

        val databaseReference = FirebaseDatabase.getInstance().getReference("subjects")
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val nnn = snapshot.childrenCount
                for (i in 0 until nnn) {
                    val key = "item_$i"
                    val value = snapshot.child(key).value?.toString() ?: ""
                    val damo = Damo(value)
                    damoList.add(damo)
                }

                val adapter = DemoAdapter(damoList)
                binding.recycler.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}