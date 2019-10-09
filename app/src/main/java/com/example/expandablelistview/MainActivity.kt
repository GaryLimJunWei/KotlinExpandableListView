package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import java.lang.Exception

class MainActivity : AppCompatActivity()
{

    lateinit var expListView : ExpandableListView
    lateinit var chapterList : MutableList<chapter>
    lateinit var Chapter_Name : Array<String>
    lateinit var Section_Name : Array<String>
    lateinit var listAdapter: MyListAdapter
    lateinit var c : chapter
    lateinit var s : section
    var sectionList : MutableList<section> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chapterList = ArrayList()

        prepareListData()
    }

    private fun prepareListData()
    {

        // Getting the chapter from strings.xml (Array)
        Chapter_Name = resources.getStringArray(R.array.chapter)

        // Using a loop to go through the whole array
        for(i in 0 .. Chapter_Name.size -1)
        {
            var k : String = "chapter${i+1}"
            var id : Int = resources.getIdentifier(k,"array",this.packageName)
            try
            {
                Section_Name = resources.getStringArray(id)
            }
            catch (e : Exception)
            {
                Section_Name = arrayOf()
            }

            for (j in 0..Section_Name.size-1)
            {
                c = chapter(Section_Name[j])
                chapterList.add(c)
            }

            s = section(Chapter_Name[i],chapterList)
            sectionList.add(s)
            chapterList = ArrayList()

        }

        displayList()
    }

    private fun displayList()
    {
        expListView = findViewById(R.id.lvExp) as ExpandableListView
        listAdapter = MyListAdapter(this,sectionList)
        expListView.setAdapter(listAdapter)
    }

}
