package com.github.zhukdi.githubfetch.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.issue_item.view.*

class IssueViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val issueTitle = view.issue_title!!
    val issueDescription = view.issue_description!!
    val issueUserImage = view.issue_user_image!!
}