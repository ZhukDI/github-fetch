package com.github.zhukdi.githubfetch.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.zhukdi.githubfetch.R
import com.github.zhukdi.githubfetch.models.Issue
import kotlinx.android.synthetic.main.issue_item.view.*

class MainAdapter(private val issueList: List<Issue>): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return issueList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.issue_item, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val issueTitle = issueList[position].title
        val issueDescription = issueList[position].number.toString() + " " + issueList[position].createdAt
        holder.view.issueTitle.text = issueTitle
        holder.view.issueDescription.text = issueDescription
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}