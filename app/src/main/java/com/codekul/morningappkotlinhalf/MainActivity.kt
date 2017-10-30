package com.codekul.morningappkotlinhalf

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        registerForContextMenu(findViewById(R.id.txtVw))

        fab.setOnClickListener {
            startActivity(
                    Intent(
                            this,
                            NextBaseActivity::class.java
                    )
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.actCt -> {
                Toast.makeText(this, "Cut", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.actCp -> {
                Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.add(1, 1, 0, "Cut")
        menu?.add(1, 2, 1, "Copy")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        Toast.makeText(
                this,
                """ Id is ${item?.itemId} """,
                Toast.LENGTH_SHORT
        ).show()

        return true
    }
}
