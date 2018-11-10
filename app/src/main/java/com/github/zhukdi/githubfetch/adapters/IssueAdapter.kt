package com.github.zhukdi.githubfetch.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.view.ViewGroup
import com.github.zhukdi.githubfetch.R
import com.github.zhukdi.githubfetch.models.Issue

class IssueAdapter(private val issueList: List<Issue>): RecyclerView.Adapter<IssueViewHolder>() {

    override fun getItemCount(): Int {
        return issueList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.issue_item, parent, false)
        return IssueViewHolder(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.issueUserImage
        holder.issueTitle.text = issueList[position].title //ToDo: add substring
        holder.issueDescription.text = "#${issueList[position].number} opened on ${issueList[position].createdAt}"

    }

}