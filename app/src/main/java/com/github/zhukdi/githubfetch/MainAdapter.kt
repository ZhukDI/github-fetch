package com.github.zhukdi.githubfetch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.issue_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    private val issueTitles = listOf<String>("First title", "Second", "3rd")

    override fun getItemCount(): Int {
        return issueTitles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.issue_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val issueTitle = issueTitles[position]
        holder.view.textView_issue_title.text = issueTitle;
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}