package com.example.sqlite_demo

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialogs.*
import kotlinx.android.synthetic.main.custom_dialogs.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UploadUser()

        AddButton.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                val mDialogView = LayoutInflater.from(this@MainActivity).inflate(R.layout.custom_dialogs,null)

                val mBuilder  = AlertDialog.Builder(this@MainActivity).setView(mDialogView).setTitle("Add User")

                val mAlertDialog  = mBuilder.show()

                mDialogView.ADDButton_dialog.setOnClickListener(object :View.OnClickListener{
                    override fun onClick(v: View?) {
                        val db  = AdapterDB(this@MainActivity)
                        db.AddName(mDialogView.NameText.text.toString(),mDialogView.AgeText.text.toString())
                        Toast.makeText(this@MainActivity,"good",Toast.LENGTH_LONG).show()
                        mDialogView.NameText.text.clear()
                        mDialogView.AgeText.text.clear()
                        mAlertDialog.cancel()
                        UploadUser()
                    }
                })

            }
        })

    }

    fun UploadUser(){
        val db  = AdapterDB(this)
        val userInfo  = db.getUser()
        RecyclerUser.layoutManager = LinearLayoutManager(this)
        RecyclerUser.adapter =  AdapterForRecycler(userInfo)

    }


}