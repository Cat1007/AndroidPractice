package com.example.jsonanalyse

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyDataAdapter(activity: Activity, val resourceId: Int, data: List<MyData>) :
    ArrayAdapter<MyData>(activity, resourceId, data) {

    inner class ViewHolder(val nameView: TextView, val idView: TextView, val versionView: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val nameView = view.findViewById<TextView>(R.id.name)
            val idView = view.findViewById<TextView>(R.id.id)
            val versionView = view.findViewById<TextView>(R.id.version)
            viewHolder = ViewHolder(nameView, idView, versionView)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val data = getItem(position)
        data?.let {
            with(viewHolder) {
                nameView.text = data.name
                idView.text = data.id
                versionView.text = data.version
            }
        }

        return view
    }
}