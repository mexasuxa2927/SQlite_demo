package com.example.sqlite_demo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdapterDB (context:Context):SQLiteOpenHelper(context,"UserDb",null,1) {
    val  TABLE_NAME ="Users"
    val  COL_NAME = "name"
    val  COL_AGE  = "age"
    val  COL_ID  = "id"


    override fun onCreate(db: SQLiteDatabase?) {
        val str:String  = "CREATE TABLE " + TABLE_NAME + " ("+ COL_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +COL_NAME+ " TEXT,"+COL_AGE+" TEXT)"
        db?.execSQL(str)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME)
        onCreate(db)
    }


    fun AddName(name:String,age:String){
        val value = ContentValues()

        value.put(COL_NAME,name)
        value.put(COL_AGE,age)

        val db  = this.writableDatabase

        db.insert( TABLE_NAME,null,value)
        db.close()

    }

    fun getName():Cursor{
        val db   = this.readableDatabase

        return  db.rawQuery("SELECT * FROM "+TABLE_NAME,null)


    }

    fun getUser():ArrayList<UserData>{
        val db  =  this.writableDatabase
        val userInfo  =  ArrayList<UserData>()
        val res =  db.rawQuery("SELECT * FROM "+TABLE_NAME,null)

        while (res.moveToNext()){
            var userin  = UserData(Integer.valueOf(res.getString(0)),res.getString(1),res.getString(2))

            userInfo.add(userin)
        }
        return userInfo

    }







}