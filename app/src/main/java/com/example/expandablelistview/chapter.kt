package com.example.expandablelistview

class chapter
{
    private var name : String = ""
    public fun getName() : String
    {
        return name
    }

    public fun setName(name:String)
    {
        this.name = name
    }

    constructor(name:String) : super()
    {
        this.name = name
    }
}
