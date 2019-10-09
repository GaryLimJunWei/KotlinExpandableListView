package com.example.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast


class MyListAdapter : BaseExpandableListAdapter
{

    var context : Context
    var sectionList : MutableList<section>
    lateinit var chapterList : MutableList<chapter>

    constructor(context: Context,sectionList: MutableList<section>) : super()
    {
        this.context = context
        this.sectionList = mutableListOf()
        this.sectionList.addAll(sectionList)
    }
    override fun getGroup(groupPosition: Int): Any
    {
        return sectionList.get(groupPosition)
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean
    {
        return true
    }

    override fun hasStableIds(): Boolean
    {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View
    {
        var s : section = getGroup(groupPosition) as section
        var inflater  : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rv : View = if(convertView == null)
        {
            inflater.inflate(R.layout.list_group,null)
        }
        else
        {
            convertView
        }
        var tv : TextView = rv.findViewById(R.id.lblListHeader) as TextView
        tv.setText(s.getName().trim())

        if(isExpanded) {}


        return rv
    }

    override fun getChildrenCount(groupPosition: Int): Int
    {
        chapterList = sectionList.get(groupPosition).getChapterList()
        return chapterList.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any
    {
        chapterList = sectionList.get(groupPosition).getChapterList()
        return chapterList.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long
    {
        return groupPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View
    {
        var c : chapter = getChild(groupPosition,childPosition) as chapter
        var inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rv : View = if(convertView == null)
        {
            inflater.inflate(R.layout.list_item,null)
        }
        else
        {
            convertView
        }
        var tv : TextView = rv.findViewById(R.id.lblListItem) as TextView
        tv.setText(c.getName().trim())
        tv.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                Toast.makeText(context,"You clicked : ${tv.text.toString()}", Toast.LENGTH_LONG).show()
            }
        })

        return rv
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long
    {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int
    {
        return sectionList.size
    }

}