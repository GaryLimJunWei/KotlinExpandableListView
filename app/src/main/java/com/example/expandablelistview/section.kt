package com.example.expandablelistview

class section
{
    private lateinit var name : String

    private var chapterList : MutableList<chapter> = mutableListOf()

    constructor(name:String,chapterList : MutableList<chapter>)
    {
        this.name = name
        this.chapterList = chapterList
    }

    public fun getName() : String
    {
        return name
    }

    public fun setName(name : String)
    {
        this.name = name
    }

    public fun getChapterList() : MutableList<chapter>
    {
        return chapterList
    }
    public fun setChapterList(chapterList: MutableList<chapter>)
    {
        this.chapterList = chapterList
    }
}