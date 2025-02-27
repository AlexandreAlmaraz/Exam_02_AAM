package com.example.exam_02_aam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam_02_aam.entities.Post

class PostAdapter(private val posts: List<Post>, private val onClick: (Post) -> Unit) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvCuerpo: TextView = itemView.findViewById(R.id.tvCuerpo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.tvTitulo.text = post.title
        holder.tvCuerpo.text = post.body

        holder.itemView.setOnClickListener {
            onClick(post)
        }
    }

    override fun getItemCount(): Int = posts.size
}
